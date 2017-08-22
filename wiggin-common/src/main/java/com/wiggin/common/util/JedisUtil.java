package com.wiggin.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Properties;

public class JedisUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JedisUtil.class);

	private static final int TIMEOUT = 3000;
	private static JedisPool jedisPool;

	private JedisUtil(){}

	/**
	 * 初始化连接池配置
	 */
	static {
		Properties properties = PropertiesUtil.loadProperties("application.properties");
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("redis.pool.maxTotal")));
		jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("redis.pool.maxIdle")));
		jedisPoolConfig.setMaxWaitMillis(Long.parseLong(properties.getProperty("redis.pool.maxWaitMillis")));
		jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(properties.getProperty("redis.pool.testOnBorrow")));
		jedisPoolConfig.setTestOnReturn(Boolean.parseBoolean(properties.getProperty("redis.pool.testOnReturn")));
		jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("redis.ip"),
				Integer.valueOf(properties.getProperty("redis.port")),TIMEOUT,properties.getProperty("redis.password"));
	}


	/**
	 * 由列表尾部添加字符串值
	 * 
	 * @param key
	 * @param value
	 */
	public static void lpush(String key, String value) {
		if (LOGGER.isDebugEnabled()){
			LOGGER.debug("lpush   key:{}, value:{}",key,value);
		}
		Jedis jedis = jedisPool.getResource();
		jedis.lpush(key, value);
		jedis.close();
	}

	/**
	 * 返回和移除列表的最后一个元素
	 * 
	 * @param key
	 * @return
	 */
	public static String lpop(String key) {
		if (LOGGER.isDebugEnabled()){
			LOGGER.debug("lpop  key:{}",key);
		}
		Jedis jedis = jedisPool.getResource();
		String value = jedis.lpop(key);
		jedis.close();
		return value;
	}

	/**
	 * 由列表头部添加字符串值
	 * 
	 * @param key
	 * @param value
	 */
	public static void rpush(String key, String value) {
		if (LOGGER.isDebugEnabled()){
			LOGGER.debug("rpush   key:{}, value:{}",key,value);
		}
		Jedis jedis = jedisPool.getResource();
		jedis.lpush(key, value);
		jedis.close();
	}

	/**
	 * 返回和移除列表的第一个元素
	 * 
	 * @param key
	 * @return
	 */
	public static String rpop(String key) {
		if (LOGGER.isDebugEnabled()){
			LOGGER.debug("rpop  key:{}",key);
		}
		Jedis jedis = jedisPool.getResource();
		String value = jedis.rpop(key);
		jedis.close();
		return value;
	}

	/**
	 * 删除缓存
	 * 
	 * @param key
	 */
	public static void del(String key) {

		if (LOGGER.isDebugEnabled()){
			LOGGER.debug("del  key:{}",key);
		}
		Jedis jedis = jedisPool.getResource();
		jedis.del(key);
		jedis.close();
	}


}
