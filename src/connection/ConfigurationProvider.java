package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProvider {
	private Properties proper= null;
	private InputStream inStream = null;
	private final String path = "config.properties";
	private File file = null;
	
	
	public ConfigurationProvider() {
		proper = new Properties();
	}

	public Properties getProperties() {
		
		try {
			file = new File(path);
			inStream = new FileInputStream(file);
			proper.load(inStream);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return proper;
	}
}
