
public class Wait {

	public void Wait()
	{
	
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException e) {
		    System.out.println("got interrupted!");
		}
	
	}
	
}
