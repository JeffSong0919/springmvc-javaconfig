package springmvc.rootconfig;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CachingConfig {
	/**
	 * 缓存管理器
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
		RedisCacheManager  cacheManager	=new RedisCacheManager(redisTemplate);
//		Map<String,Long> key=new HashMap<String, Long>();
//		key.put("spittle", 2L);
//		cacheManager.setExpires(key);
		cacheManager.setDefaultExpiration(1);
		return cacheManager;

	}

	/**
	 * 连接Redis
	 * 
	 * @return
	 */
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		// host地址
		jedisConnectionFactory.setHostName("10.10.13.12");
		// 端口号
		jedisConnectionFactory.setPort(6379);
		jedisConnectionFactory.afterPropertiesSet();
		return jedisConnectionFactory;
	}

	/**
	 * RedisTemplate配置
	 * 
	 * @param redisCF
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(
			RedisConnectionFactory redisCF) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(redisCF);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
