package com.datapower;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetVersionInfo {
	
    public static void main(String[] args) throws IOException {
        //TODO: update the version string below to match the DataPower firmware version the WSDL was taken from
    	Properties prop = new Properties();
    	InputStream input = null;
    	try {
    		input = GetVersionInfo.class.getClassLoader().getResourceAsStream("version.properties");
    		if(input == null) {
    			System.out.println("Version file does not exist.");
    		}
    		
    		prop.load(input);
    		String versionString = prop.getProperty("datapower.firmware.version");
            System.out.println("Compiled from DataPower firmware version " + versionString);

    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
        			input.close();    				
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
}
