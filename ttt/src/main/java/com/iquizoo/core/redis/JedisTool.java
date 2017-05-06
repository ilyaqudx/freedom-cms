package com.iquizoo.core.redis;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.iquizoo.core.config.Config;
import com.iquizoo.core.config.ConfigKey;
import com.iquizoo.core.constants.Consts;

public class JedisTool {

	private static JedisPool pool = null;

	/**评测客户端缓存KEY的标记*/
	public static final String HEAD_CLIENT = "CLIENT";
	
	/**评测客户端缓存数据时长（s）*/
	public static final int EXPIRE_CLIENT = 60*60*24*7;

	private static  Logger logger = Logger.getLogger(JedisTool.class);
	
	/**
	 * 构建redis连接池
	 * 
	 * @param ip
	 * @param port
	 * @return JedisPool
	 */
	public static JedisPool getPool() {
		if (pool == null) {
			JedisPoolConfig config = new JedisPoolConfig();
			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
			config.setMaxTotal(20);
			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
			config.setMaxIdle(15);
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(5000);
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			if(Consts.TRUE == Config.getInt(ConfigKey.REDIS_AUTH))
			{
				String host = Config.getString(ConfigKey.REDIS_HOST);
				int port = Config.getInt(ConfigKey.REDIS_PORT);
				String password = Config.getString(ConfigKey.REDIS_PASSWORD);
				pool = new JedisPool(config, 
						host, 
						port,
						1000, password);
			}
			else
			{
				pool = new JedisPool(config, Config.getString(ConfigKey.REDIS_HOST),Config.getInt(ConfigKey.REDIS_PORT));
			}
		}
		return pool;
	}

	/**
	 * 返还到连接池
	 * 
	 * @param pool
	 * @param redis
	 */
	public static void returnResource(JedisPool pool, Jedis redis) {
		if (redis != null) {
			pool.returnResource(redis);
		}
	}

	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		String value = null;

		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			logger.error("get key : " + key,e);
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}

		return value;
	}

	public static void set(String key, String value) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			logger.error("set key : " + key +",value = "+value,e);
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
	}
	
	public static void setex(String key, int seconds, String value) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			jedis.setex(key, seconds, value);
		} catch (Exception e) {
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
	}

	public static void delete(String key) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			jedis.del(key);
		} catch (Exception e) {
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
	}

	public static void expire(String key, int expireSeconds) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			jedis.expire(key, expireSeconds);
		} catch (Exception e) {
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
	}

	public static void hmset(String key, Map<String, String> map) {
		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			jedis.hmset(key, map);
		} catch (Exception e) {
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
	}

	public static List<String> hmget(String key, String... fields) {
		JedisPool pool = null;
		Jedis jedis = null;
		List<String> list = null;
		try {
			pool = getPool();
			jedis = pool.getResource();
			list = jedis.hmget(key, fields);
		} catch (Exception e) {
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
		return list;
	}
	
	public static final void lpush(String key,String... strings)
	{
		JedisPool pool = null;
		Jedis jedis = null;
		try 
		{
			pool = getPool();
			jedis = pool.getResource();
			jedis.lpush(key, strings);
		} 
		catch (Exception e) 
		{
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
	}
	public static final List<String> lrange(String key,int start,int end)
	{
		JedisPool pool = null;
		Jedis jedis = null;
		try 
		{
			pool = getPool();
			jedis = pool.getResource();
			return jedis.lrange(key, start, end);
		} 
		catch (Exception e) 
		{
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
		return null;
	}
	
	public static final List<String> brpop(String key)
	{
		JedisPool pool = null;
		Jedis jedis = null;
		List<String> list = null;
		try 
		{
			pool = getPool();
			jedis = pool.getResource();
			list = jedis.brpop(30,key);
		} catch (Exception e) 
		{
			// 释放redis对象
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			// 返还到连接池
			returnResource(pool, jedis);
		}
		return list;
	}
	
	/**
	 * 得到评测客户端的用户key
	 */
	public static String getEvalClientKey(Integer userId, Integer subId, Integer examId) {
		return JedisTool.HEAD_CLIENT + userId + ":" + subId + ":" + examId;
	}
	
	public static String getEvalClientSubKey(Integer subId) {
		return JedisTool.HEAD_CLIENT + subId;
	}
	
	public static void main(String[] args) {
		
		JedisPoolConfig config = new JedisPoolConfig();
		// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
		// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
		config.setMaxTotal(20);
		// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
		config.setMaxIdle(15);
		// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
		config.setMaxWaitMillis(5000);
		// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
		config.setTestOnBorrow(true);
		pool = new JedisPool(config, 
				"114.215.211.36", 
				6379,
				30000, "Iquizoo999");
		Jedis jedis = pool.getResource();
		
		jedis.set("name", "张三");
		String name = jedis.get("name");
		
		System.out.println(name);
	}
}
