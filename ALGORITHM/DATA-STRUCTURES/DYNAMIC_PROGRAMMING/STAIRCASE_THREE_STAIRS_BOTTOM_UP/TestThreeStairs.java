import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestThreeStairs {
	@Test
	public void testCountWays3() {
	   int numberOfStairs=3;
	   int excpected=4;
	   int calculated=Calc.countStairs(numberOfStairs);
       assertEquals(excpected,calculated);
	}
	
	@Test
	public void testCountWays4() {
	   int numberOfStairs=4;
	   int excpected=7;
	   int calculated=Calc.countStairs(numberOfStairs);
       assertEquals(excpected,calculated);
	}
	
	@Test
	public void testCountWays5() {
	   int numberOfStairs=5;
	   int excpected=13;
	   int calculated=Calc.countStairs(numberOfStairs);
       assertEquals(excpected,calculated);
	}

}
