package com.redis.cache;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.lettuce.core.RedisCommandTimeoutException;

import org.apache.catalina.webresources.Cache;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@SuppressWarnings("deprecation")
@Configuration
@EnableCaching
public class RedisCacheConfiguration extends CachingConfigurerSupport{

	@Autowired
	private CacheConfigurationProperties cacheConfigurationProperties = null;
	
	private org.springframework.data.redis.cache.RedisCacheConfiguration createCacheConfiguration(long timeoutInSeconds, ObjectMapper objectMapper){
		return org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig()
				.serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper)))
				.entryTtl(Duration.ofSeconds(timeoutInSeconds));
				
	}
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Bean
	public CacheManager cacheManager(JedisConnectionFactory redis1ConnectionFactory) {
		Map<String, org.springframework.data.redis.cache.RedisCacheConfiguration> cacheConfigurations = new HashMap<>();
		
		if(Objects.nonNull(cacheConfigurationProperties.getDefaultTTL())) {
			for(Entry<String, String> cacheNameAndTimeout: cacheConfigurationProperties.getCacheTTL().entrySet()) {
				cacheConfigurations.put(cacheNameAndTimeout.getKey(), createCacheConfiguration(Long.parseLong(cacheNameAndTimeout.getValue()),objectMapper));
			}
		}
		
		return RedisCacheManager
				.builder(redis1ConnectionFactory)
				.cacheDefaults(createCacheConfiguration(Long.parseLong(cacheConfigurationProperties.getDefaultTTL()), objectMapper))
				.withInitialCacheConfigurations(cacheConfigurations)
				.build();
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public JedisConnectionFactory redis1ConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		

		redisConnectionFactory.setHostName(cacheConfigurationProperties.getHost());
		redisConnectionFactory.setPassword(cacheConfigurationProperties.getPassword());
		redisConnectionFactory.setPort(Integer.parseInt(cacheConfigurationProperties.getPort()));
		redisConnectionFactory.setUseSsl(false);
		
		return redisConnectionFactory;
	}
	
	@Override
	public CacheErrorHandler errorHandler() {
		return new RedisCacheErrorHandler();
	}
	
	public static class RedisCacheErrorHandler implements CacheErrorHandler{

		private static final org.slf4j.Logger log = LoggerFactory.getLogger(RedisCacheErrorHandler.class);
		@Override
		public void handleCacheGetError(RuntimeException exception, org.springframework.cache.Cache cache, Object key) {
			handleTimeOutException(exception);
			// TODO Auto-generated method stub
			 log.info("Unable to get from cache " + cache.getName() + " : " + exception.getMessage());
			
		}

		@Override
		public void handleCachePutError(RuntimeException exception, org.springframework.cache.Cache cache, Object key,
				Object value) {
			handleTimeOutException(exception);
			// TODO Auto-generated method stub
			log.info("Unable to put into cache " + cache.getName() + " : " + exception.getMessage());
			
		}

		@Override
		public void handleCacheEvictError(RuntimeException exception, org.springframework.cache.Cache cache,
				Object key) {
			handleTimeOutException(exception);
			// TODO Auto-generated method stub
			log.info("Unable to evict from cache " + cache.getName() + " : " + exception.getMessage());
			
		}

		@Override
		public void handleCacheClearError(RuntimeException exception, org.springframework.cache.Cache cache) {
			handleTimeOutException(exception);
			// TODO Auto-generated method stub
			log.info("Unable to clean cache " + cache.getName() + " : " + exception.getMessage());
			
		}
		
		private void handleTimeOutException(RuntimeException exception) {

	        if (exception instanceof RedisCommandTimeoutException)
	            return;
	    }
		
	}
	
//	@Configuration
//	@ConfigurationProperties(prefix="cache")
//	public
//	 class CacheConfigurationProperties{
//		
//		private String port;
//		private String host;
//		private String defaultTTL;
//		private Map<String, String> cacheTTL;
//		private String password;
//		public String getPort() {
//			return port;
//		}
//		public void setPort(String port) {
//			this.port = port;
//		}
//		public String getHost() {
//			return host;
//		}
//		public void setHost(String host) {
//			this.host = host;
//		}
//		public String getDefaultTTL() {
//			return defaultTTL;
//		}
//		public void setDefaultTTL(String defaultTTL) {
//			this.defaultTTL = defaultTTL;
//		}
//		public Map<String, String> getCacheTTL() {
//			return cacheTTL;
//		}
//		public void setCacheTTL(Map<String, String> cacheTTL) {
//			this.cacheTTL = cacheTTL;
//		}
//		public String getPassword() {
//			return password;
//		}
//		public void setPassword(String password) {
//			this.password = password;
//		}				
//	}
//	
}
