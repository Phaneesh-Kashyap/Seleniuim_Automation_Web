package Selenium_learning;

public class Interview {

	public static void main(String[] args) {
        //System.out.println("Try programiz.pro");
        
        //HappyNewYear  --> HapyNewr
        //MerryChristmas --> MeryChista
        
        String str = "MerryChristmas";
        String str1 = "";
        int j =0;
        
        
        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);
            String str2 = String.valueOf(ch);
            
            
            if (!str1.toLowerCase().contains(str2.toLowerCase()))
            {
            	str1 = str1 + str2;
            }
            
            //str1 = str1.replace(str2, "");
            //System.out.println(str1);
            //System.out.print(ch);
            
        }
        
        System.out.println(str1);
        
        
        
        
        
        



        
            
        
    }
	
}