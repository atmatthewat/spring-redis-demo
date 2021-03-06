package de.adesso.redis;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;


public class RedisCache {

	@Test
	public void testCache() throws Exception {
		StringRedisTemplate redisTemplate = RedisHelper.setupRedisStringTemplate();
		redisTemplate.delete("cachekey");
		String text="Lots and lots of text";
		redisTemplate.opsForValue().set("cachekey", text, 1000, TimeUnit.MILLISECONDS);
		Assert.assertEquals(text, redisTemplate.opsForValue().get("cachekey"));
		Thread.sleep(3000);
		Assert.assertNull(redisTemplate.opsForValue().get("cachekey"));
	}
	
}
