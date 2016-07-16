/*package com.raj.util;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyUtilConfigurer extends PropertyPlaceholderConfigurer {

	private String propertiesfileName;
	String IMS_HOME = "IMS_HOME";
	private Properties properties;

	private Properties appProperties = new Properties();

	private final String PROPERTIES_FILE = File.separator + "IMS_HOME" + File.separator;

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}

	public String fetchRequestDumperHomePath() {
		String ucm_home_path = System.getProperty(IMS_HOME);
		if (ucm_home_path == null) {
			logger.info("Not able to get system property " + IMS_HOME
					+ ". Trying to get from system environment.");
			ucm_home_path = System.getenv(IMS_HOME);
		}
		if (ucm_home_path == null) {
			throw new RuntimeException(
					"UCM/Request-Dumper Home system/envrionment property is not sepecified as a JVM arg; use the: ["
							+ IMS_HOME
							+ "] "
							+ "to define it. E.g., -DUCM_HOME=/home/vekomy/Ucm_Home or set as environment variable.");
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
			propertiesFilePath = ucm_home + PROPERTIES_FILE + getFileName();
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

	public void setFileName(String fileName) {
		this.propertiesfileName = fileName;
	}

	public String getFileName() {
		return propertiesfileName;
	}


}
*/