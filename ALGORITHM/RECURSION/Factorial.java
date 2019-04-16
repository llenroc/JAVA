class Algorithm
{
    public int factorial(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        else 
        {
            return (n*factorial(n-1));
        }

    }
}
public class MainClass {
    public static void main(String[] args) {
    Algorithm algor = new Algorithm();
    System.out.println(algor.factorial(14));
    }
}