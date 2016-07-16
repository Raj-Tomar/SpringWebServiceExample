package com.raj.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyFileConfigurer extends PropertyPlaceholderConfigurer{
	
	private String propertiesFileName;
	final String WEBSERVICE_HOME = "WEBSERVICE_HOME";
	private final String PROPERTIES_FILE = File.separator + WEBSERVICE_HOME + File.separator;
	
	private Properties appProperties = new Properties();
	
	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}
	
	public String fetchRequestDumperHomePath() {
		String ucm_home_path = System.getProperty(WEBSERVICE_HOME);
		if (ucm_home_path == null) {
			logger.info("Not able to get system property " + WEBSERVICE_HOME
					+ ". Trying to get from system environment.");
			ucm_home_path = System.getenv(WEBSERVICE_HOME);
		}
		if (ucm_home_path == null) {
			throw new RuntimeException(
					"UCM/Request-Dumper Home system/envrionment property is not sepecified as a JVM arg; use the: ["
							+ WEBSERVICE_HOME
							+ "] "
							+ "to define it. E.g., -DUCM_HOME=/home/raj/WebService_Home or set as environment variable.");
		} else {
			return ucm_home_path;
		}
	}

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {

		String propertiesFilePath = null;
		try {
			String ucm_home = fetchRequestDumperHomePath();
			propertiesFilePath = ucm_home + PROPERTIES_FILE + getPropertiesFileName();
			logger.info("Reading properties file: " + propertiesFilePath);

			appProperties.load(new FileInputStream(propertiesFilePath));

			setProperties(appProperties);
		} catch (IOException ex) {
			logger.error("Unable to read properties file at "
					+ propertiesFilePath);
		}
		super.postProcessBeanFactory(beanFactory);
	}

	@Override
	protected void loadProperties(Properties props) throws IOException {
		super.loadProperties(props);
	}
	
	
	public String getPropertiesFileName() {
		return propertiesFileName;
	}
	public void setPropertiesFileName(String propertiesFileName) {
		this.propertiesFileName = propertiesFileName;
	}
	
	

}
