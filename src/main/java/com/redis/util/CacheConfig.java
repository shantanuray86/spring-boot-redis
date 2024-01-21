package com.redis.util;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@EnableCaching
@Configuration
public class CacheConfig {

	@Bean
	@Primary
	public RedisCacheConfiguration defaultCacheConfig(ObjectMapper objectMapper) {
		
		return RedisCacheConfiguration.defaultCacheConfig()
				.serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper)));
	}
}
