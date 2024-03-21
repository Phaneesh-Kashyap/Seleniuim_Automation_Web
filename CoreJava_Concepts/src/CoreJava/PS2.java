package CoreJava;

public class PS2 extends PS3{
	
	int a;
	
	//Constructor
	public PS2(int a) {
		super(a); //parent class constructor is invoked
		super.multiplybytwo();
		super.multiplybythree();
		this.a = a;
	}

	public int increment()
	{
		a++;
		return a;
		
	}

	public int decrement()
	{
		a--;
		return a;
		
	}
}
