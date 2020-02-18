package connection;

import java.util.Properties;

public enum Config {
	
	
	URL(),USERNAME(),PASS(),PORT();
	
	
	private ConfigurationProvider config = null;
	private Properties pro = null;
	private Config() {
		config =new ConfigurationProvider();
		pro = config.getProperties();
	}
	public String getvalue() {
		return pro.getProperty(this.toString());
	}
	
}
