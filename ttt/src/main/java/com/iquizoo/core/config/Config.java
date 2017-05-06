package com.iquizoo.core.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import com.iquizoo.core.kit.LogKit;

/**
 * 配置文件
 * */
public class Config {

	public static final String EVN_LOCALHOST = "localhost" ,ENV_DEV = "dev", ENV_ALPHA = "alpha",EVN_BETA = "beta",EVN_BETA_PRE = "beta_pre";
	
	//服务器环境
	public static final String ENVRIONMENT = "envrionment";
	
	public static String CURRENT_ENVRIONMENT;
	
	public static PropertiesConfiguration config;
	
	static
	{
		try 
		{
			//获取当前程序运行的环境(alpha,beta)
			PropertiesConfiguration cfg = new PropertiesConfiguration(ENVRIONMENT);
			//解析环境
			String envrionment = parseEnvrionment(cfg.getString(ENVRIONMENT));
			CURRENT_ENVRIONMENT = envrionment;
			//根据环境加载不同的配置
			config = new PropertiesConfiguration();
			//设置编码(如果要设置编码只能使用空的构造方法,设置编码后,再手动调用load方法,否则编码设置无效)
			config.setEncoding("UTF-8");
			//加载配置
			config.load(Config.class.getResource("/config/" +envrionment +".properties"));
			//文件重加载机制(文件改变时则重新加载,spring配置默认检查时间间隔)
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
			//添加配置改变监听
			config.addConfigurationListener(new ConfigurationListener() {
				
				@Override
				public void configurationChanged(ConfigurationEvent event) 
				{
					String name = event.getPropertyName();
					Object value= event.getPropertyValue();
					LogKit.info("配置文件被修改 ==> name : " + name + ",value = " + value,Config.class);
				}
			});
		} 
		catch (ConfigurationException e) 
		{
			LogKit.error("环境配置文件加载出错,程序退出!",e,Config.class);
			System.exit(-1);
		}
	}
	
	/**
	 * 解析运行环境,如果匹配不成功,则默认为本地运行
	 * */
	public static String parseEnvrionment(String envrionment)
	{
		if(ENV_ALPHA.equals(envrionment) || EVN_BETA.equals(envrionment) ||ENV_DEV.equals(envrionment) || EVN_BETA_PRE.equals(envrionment)){
			return envrionment;
		}
		return EVN_LOCALHOST;
	}
	
	public static final String getString(String key)
	{
		return config.getString(key);
	}
	public static final long getLong(String key)
	{
		return config.getLong(key);
	}
	public static final int getInt(String key)
	{
		return config.getInt(key);
	}
	public static final short getShort(String key)
	{
		return config.getShort(key);
	}
	public static final byte getByte(String key)
	{
		return config.getByte(key);
	}
	public static final double getDouble(String key)
	{
		return config.getDouble(key);
	}
	public static final float getFloat(String key)
	{
		return config.getFloat(key);
	}
}
