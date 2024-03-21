import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Variables and data types-------------------------------------------------------------------
		int mynum = 112233457;
		String mystr = "Phaneesh";
		char mychar = 'p';
		boolean mybool = true;
		var myvar = 1234574;
		
		
		System.out.println(mynum + "\n" + mystr + "\n" + mychar + "\n" + mybool + "\n" + myvar );

		
		// -------------------------------------------------------------------
		// arrays
		int[] arr = new int[5];
		arr[0] = 1;
		arr[3] = 3;
		
		System.out.println(arr[3]);
		
		int[] arr1 = {1,2,3,4,5};
		arr1[4] = 12;
		System.out.println(arr1[4]);
		System.out.println(arr1.length);
		
		System.out.println("ascending order");	
		for(int i=0; i<arr1.length; i++)
		{
			System.out.println(i + " = " + arr1[i]);
			
		}
		
		System.out.println("descending order");
		for(int i=arr1.length-1; i>=0; i--)
		{
			System.out.println(arr1[i]);
			
		}
		
		System.out.println("String array ::");
		String[] mystr1 = {"Phaneesh","is","good","at","coding"};
		for(int i=0; i<mystr1.length; i++)
		{
			System.out.println("Line " + i + " : " + mystr1[i]);
			
		}
		
		System.out.println("Enhanced For loop ::");
		for(String s:mystr1)
		{
			System.out.println(s);			
		}
		
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		for(int i=0; i<arr2.length; i++)
		{
			if (arr2[i] % 2 == 0)
			{
				System.out.println(i+1 + " = " + arr2[i]);
			}
			else
			{
				System.out.println(arr2[i] + " not multiple of 2");
			}
		}
		
		String[] str1 = {"phaneesh","mahesh","danny","ashwini"};
		for(int i=0; i<str1.length; i++)
		{
			System.out.println(str1[i]);
			if (str1[i] == "danny")
			{
				System.out.println("I got him = " + str1[i]);
				break;
			}
		}
		
		
		// -------------------------------------------------------------------
		// array list - 
		System.out.println("********** Array List ***************");
		
		ArrayList a = new ArrayList();
		a.add("Phaneesh");
		a.add("Kashyap");
		a.add("Learning");
		a.add("Selenium");
		a.add(1445628);
		a.add(true);
		
		
		//System.out.println(a.get(0));
		//System.out.println(a.get(4));
		
		//System.out.println(a.size());
		
		for(int i=0; i<a.size(); i++)
		{
			System.out.println(a.get(i));
		}
		
		
		for(int i=a.size()-1; i>=0; i--)
		{
			var x = a.get(i);
			if (x instanceof String)
			{
				a.remove(i);
			}
		}
		
		System.out.println("*************************");
		
		for( var val :a)
		{
			System.out.println(val);
		}
		
		System.out.println("*************************");
		a.add("Phaneesh");
		a.add("Kashyap");
		a.add("Learning");
		a.add("And");
		a.add("Mastered");
		a.add("arraylist");
		
		System.out.println(a.contains("arraylist"));
		
		System.out.println("*************************");
		
		List newarray = Arrays.asList(str1);
		for(int i=0; i<newarray.size(); i++)
		{
			System.out.println(newarray.get(i));
		}
		
		// ---------- string is object representing sequence of characters ----------------
		
		// string literal
		System.out.println("************ String *************");
		
		String s = "Phaneesh learning selenium";
		String s1 = "Phaneesh learning selenium"; // new object is not created. it refers to string s, because value is same.
		
		s = "still learning";
		System.out.println(s1);
		
		// with new key word
		String S2 = new String("Welcome Phaneesh");
		String S3 = new String("Welcome Phaneesh"); // s2 and s3 are both different objects
		
		String[] strSplit = s1.split(" ");
		
		System.out.println(strSplit[0]);
		System.out.println(strSplit[1]);
		System.out.println(strSplit[2]);
		
		String[] strSplit1 = s1.split("learning");
		
		System.out.println(strSplit1[0]);
		System.out.println(strSplit1[1].trim());
		
		for(int i=0; i<strSplit[0].length(); i++)
		{
			System.out.println(strSplit[0].charAt(i));
		}
		
		System.out.println(strSplit[0].charAt(1));
		
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
