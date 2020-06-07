package RestApi.gitapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
	
	public Properties prop;
	
	public Base() throws IOException {
		try {
			prop = new Properties();
			FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\RestApi\\gitapi\\config.properties");
		    prop.load(fil);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
