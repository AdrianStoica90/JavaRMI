package rmiPeripherals;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/**
 * Retrieve IP of the user using a webservice
 * @author Adrian
 *
 */

public class IPClass {
	
	static String ip;
		
	public static String GetIP(String apiLink) {
		
		try {
			URL url = new URL(apiLink);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
		
			//Convert the InputStream into a string
		
			int ch;
			StringBuilder sb = new StringBuilder();
			while((ch = is.read()) != -1) {
				sb.append((char)ch);
			}
			
			String [] stringResult = sb.toString().split(",");
			for(String item: stringResult) {
				item = item + "\n";
				//newString = newString + item;
				if(item.contains("query")) {
					ip = item.substring(7,22);
					return ip;
				}
			}
				
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return ip;
	}
	
}
