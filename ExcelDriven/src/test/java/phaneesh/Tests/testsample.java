package phaneesh.Tests;

import java.io.IOException;
import java.util.ArrayList;

public class testsample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		dataDriven d = new dataDriven();
		ArrayList<String> data = d.getData("purchase");
		
		String testcase = data.get(0);
		String data1 = data.get(1);
		String data2 = data.get(2);
		String data3 = data.get(3);
		String data4 = data.get(4);
		
		System.out.println("Purchase test details from excel :: " + "\n" + testcase + "\n" 
		+ data1 + "\n" + data2 + "\n" + data3 + "\n" + data4);
		
		
	}

}
