package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class ConfigReader {
	
	Properties prop;
	
// 	@Test
	public  Properties init_prop() throws IOException {
		prop=new Properties();
		 
		
		FileInputStream fs=new FileInputStream("./src/test/resources/config.properties");
		
		prop.load(fs);

		return prop;
		
		
	}
	
}
