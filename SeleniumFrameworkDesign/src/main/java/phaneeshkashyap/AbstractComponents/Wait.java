package phaneeshkashyap.AbstractComponents;

public class Wait {

	public void Wait() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("got interrupted!");
		}

	}
	
	public void Wait(int sec) {

		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			System.out.println("got interrupted!");
		}

	}

	
}
