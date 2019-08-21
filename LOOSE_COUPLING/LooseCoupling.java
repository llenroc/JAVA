/*

Example of loose Coupling

Everything works fine without interface(see example of tight coupling). The problem starts when you need to add one more class. In this case you need to change you constructor of class [Manager]. 
It means the source class is very tight.  It’s not flexible and violate [open closed principle] of SOLID

To solve it you need to use interface
*/

interface IWorker
{
   public void work();
}
class LazyWorker implements IWorker{
    public void work()
    {
        System.out.println("I am lazy worker");
    }
}
class HardWorker implements IWorker{
    public void work()
    {
        System.out.println("I am hard worker");
    }
}
class MediumWorker implements IWorker{
    public void work()
    {
        System.out.println("I am medium worker");
    }
}
class Manager{
    private IWorker worker;  
    Manager()
    {        
    }
    Manager(IWorker worker)
    {
        this.worker=worker;
    }

    public void reportWorkers()
    {
        worker.work();
    }
}


public class MainClass {
    public static void main(String[] args) throws IOException {
    LazyWorker lazyWorker= new LazyWorker();		
	HardWorker hardWorker= new HardWorker();
	MediumWorker mediumWorker= new MediumWorker();
	
    Manager managerOfLazyWorker= new Manager(lazyWorker);
	Manager managerOfHardWorker= new Manager(hardWorker);
	Manager managerOfMediumWorker= new Manager(mediumWorker);

     managerOfLazyWorker.reportWorkers();
	 managerOfHardWorker.reportWorkers();
	 managerOfMediumWorker.reportWorkers();
    }
}
