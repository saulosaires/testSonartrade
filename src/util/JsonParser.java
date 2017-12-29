package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
 

public class JsonParser {

	static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
	
	public static Object fromJson(String json, Class<?> c){
	
		return gson.fromJson(json,c);
		
	}
	
	public static String toJson(Object obj){
		 
		return gson.toJson(obj);
		
	}
	
}
