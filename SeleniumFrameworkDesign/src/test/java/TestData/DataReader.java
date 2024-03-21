package TestData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException
	{
		//read JSON to String
		String jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\"+path),
				StandardCharsets.UTF_8);
		
		//String to Hashamp ==> Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data 
		= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
		
		
	}
	

}
