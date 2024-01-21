package com.redis.cache;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//public class CacheConfigurationProperties {
//
//}
@Configuration
@ConfigurationProperties(prefix="cache")
public
 class CacheConfigurationProperties{
	
	private String port;
	private String host;
	private String defaultTTL;
	private Map<String, String> cacheTTL;
	private String password;
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDefaultTTL() {
		return defaultTTL;
	}
	public void setDefaultTTL(String defaultTTL) {
		this.defaultTTL = defaultTTL;
	}
	public Map<String, String> getCacheTTL() {
		return cacheTTL;
	}
	public void setCacheTTL(Map<String, String> cacheTTL) {
		this.cacheTTL = cacheTTL;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}				
}
