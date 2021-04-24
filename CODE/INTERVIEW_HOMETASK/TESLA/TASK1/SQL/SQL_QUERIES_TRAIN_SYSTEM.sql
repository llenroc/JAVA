/*
[Task a]. What is the revenue for a given location?

solution: I consider A revenue for one ticket as a total price of the ticket: actual price plus fee&taxes and minus discounts
So, that amount that customer pays for a ticket
*/

SELECT 
      L1.CITY AS CITY_FROM
	 ,L2.CITY AS CITY_TO
	 ,SUM(T.TOTAL) AS REVENUE
FROM 
               LOCATION L1
	 INNER JOIN
               TICKET_ORDER	O
               ON (L1.LOCATION_SK=O.LOCATION_FROM_SK)			 			  
	 INNER JOIN	 
               LOCATION L2	 	 
	           ON (L2.LOCATION_SK=O.LOCATION_TO_SK)	
	 INNER JOIN	 
	 	       TICKET_PRICE P 
			   ON (P.TICKET_PRICE_SK=O.TICKET_PRICE_SK)		   			                   
WHERE	 
          L1.CITY="CITY_A"
	  AND L2.CITY="CITY_B"
GROUP BY 	  
      L1.CITY
	 ,L2.CITY;

/*	 
[Task b]. How many new customers have used service today?
Solution: i define a new customer as:

A customer is been registered in a system, because he/she already bought a ticket,
but did not have any trips yet(before today)
*/
SELECT 
	 COUNT(DISTINCT O.PASSENGER_SK) AS TOTAL_NUMBER_OF_NEW_CUSTOMERS
FROM 	 
               TICKET_ORDER	O 			  
	 INNER JOIN	 
	 	       TRIP T
			   ON (T.TICKET_ORDER_SK=O.TICKET_ORDER_SK)				   			                   
WHERE	 
        EXISTS 
	        (SELECT 1 FROM TRIP T1 WHERE T1.TRIP_SK = T.TRIP_SK AND TO_DATE(T1.ACTUAL_START_DATE,'YYYY=MM-DD') = TO_DATE(SYSDATE(),'YYYY=MM-DD'))
     AND NOT EXISTS 
	        (SELECT 1 FROM TRIP T2 WHERE T2.TRIP_SK = T.TRIP_SK AND TO_DATE(T1.ACTUAL_START_DATE,'YYYY=MM-DD') < TO_DATE(SYSDATE(),'YYYY=MM-DD')) 			
/*
[Task c]. How many trips or trains travelled between point A and point B
*/
SELECT 
      COUNT(*) AS TOTAL_NUMBER_OF_TRIPS
FROM 
               LOCATION L1
	 INNER JOIN
               TICKET_ORDER	O
               ON (L1.LOCATION_SK=O.LOCATION_FROM_SK)			 			  
	 INNER JOIN	 
               LOCATION L2	 	 
	           ON (L2.LOCATION_SK=O.LOCATION_TO_SK)		   			                  
WHERE	 
          L1.CITY="CITY_A"
	  AND L2.CITY="CITY_B";