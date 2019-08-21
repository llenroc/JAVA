/*
Example of TIGHT Coupling
Everything works fine. The problem starts when you need to add one more class. In this case you need to change you constructor of class [Manager]. 
It means the source class is very tight.  It’s not flexible and violate [open closed principle] of SOLID

To solve it you need to use interface
*/

class LazyWorker{
    public void work()
    {
        System.out.println("I am lazy worker");
    }
}
class HardWorker{
    public void work()
    {
        System.out.println("I am hard worker");
    }
}
class Manager{
    private LazyWorker lazyWorker;
    private HardWorker hardWorker;    
    Manager()
    {        
    }
    Manager(LazyWorker lazyWorker, HardWorker hardWorker)
    {
        this.lazyWorker=lazyWorker;
        this.hardWorker=hardWorker;
    }

    public void reportWorkers()
    {
        lazyWorker.work();
        hardWorker.work();
    }
}


public class MainClass {
    public static void main(String[] args) throws IOException {
    LazyWorker lazyWorker= new LazyWorker();		
	HardWorker hardWorker= new HardWorker();
    Manager manager= new Manager(lazyWorker,hardWorker);
     manager.reportWorkers();
    }
}