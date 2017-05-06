package com.iquizoo.core.kit;

import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.util.Base64;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.BeanUtils;

import sun.misc.BASE64Encoder;

public class Kit {

	public static final <T> boolean isNull(T obj)
	{
		return null == obj;
	}
	
	public static final <T> boolean isNotNull(T obj)
	{
		return !isNull(obj);
	}
	
	@SuppressWarnings("rawtypes")
	public static final <T> boolean isBlank(T obj)
	{
		if(isNull(obj))
			return true;
		else if(obj instanceof String)
			return StrKit.isBlank((String)obj);
		else if(obj instanceof List)
			return ((List)obj).isEmpty();
		else if(obj instanceof Map)
			return ((Map)obj).isEmpty();
		return false;
	}
	
	public static final <T> boolean isNotBlank(T obj)
	{
		return !isBlank(obj);
	}
	
	public static final String time2String(Date date,String pattern)
	{
		return new SimpleDateFormat(pattern).format(date == null ? new Date() : date);
	}
	
	public static final int age(Date birthday)
	{
		if(null == birthday)
			return -1;
		DateTime time = new DateTime(birthday);
		
		return Years.yearsBetween(time, new DateTime()).getYears();
	}
	
	public static final String date2String(Date date,String pattern)
	{
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public static final Map<String,String> mapOf(String k1,String v1)
	{
		Map<String,String> map = new HashMap<String, String>(1);
		map.put(k1, v1);
		return map;
	}
	public static final Map<String,Object> mapOf(String k1,Object v1)
	{
		Map<String,Object> map = new HashMap<String, Object>(1);
		map.put(k1, v1);
		return map;
	}
	public static final Map<String,Object> mapOf(String k1,Object v1,String k2,Object v2)
	{
		Map<String,Object> map = new HashMap<String, Object>(2);
		map.put(k1, v1);
		map.put(k2, v2);
		return map;
	}
	public static final Map<String,Object> mapOf(String k1,Object v1,String k2,Object v2,String k3,Object v3)
	{
		Map<String,Object> map = new HashMap<String, Object>(3);
		map.put(k1, v1);
		map.put(k2, v2);
		map.put(k3, v3);
		return map;
	}
	public static final Map<String,Object> mapOf(String k1,Object v1,String k2,Object v2,String k3,Object v3,String k4,Object v4)
	{
		Map<String,Object> map = new HashMap<String, Object>(3);
		map.put(k1, v1);
		map.put(k2, v2);
		map.put(k3, v3);
		map.put(k4, v4);
		return map;
	}
	
	public static final Map<String,Object> toMap(String[] keys,Object[] values)
	{
		if(null == keys || values == null)
			return new HashMap<String, Object>();
		int min = Math.min(keys.length, values.length);
		
		if(min == 0)
			return new HashMap<String, Object>();
		
		Map<String,Object> params = new HashMap<String, Object>();
		for (int i = 0; i < min; i++) 
		{
			params.put(keys[i], values[i]);
		}
		
		return params;
	}
	
	public static final Map<String,String> toMap(String[] keys,String[] values)
	{
		if(null == keys || values == null)
			return new HashMap<String, String>();
		int min = Math.min(keys.length, values.length);
		
		if(min == 0)
			return new HashMap<String, String>();
		
		Map<String,String> params = new HashMap<String, String>();
		for (int i = 0; i < min; i++) 
		{
			params.put(keys[i], values[i] + "");
		}
		
		return params;
	}
	
	public static final int default0(Object obj)
	{
		return obj == null ? 0 : (Integer)obj;
	}
	
	public static final String defaultEmpty(Object obj)
	{
		return obj == null ? "" : (String)obj;
	}
	
	public static final int default1(Integer value)
	{
		return value == null ? 1 : value;
	}
	
	public static final int checkRange(int value,int min,int max)
	{
		if(between(value, min, max))
			return value;
		return value < min ? min : max;
	}
	
	public static final boolean between(int value,int min,int max)
	{
		if(value >= min && value <= max)
			return true;
		return false;
	}
	
	public static final String generatorToken()
	{
		return UUID.randomUUID().toString();
	}
	
	public static final <T> T trueOrFalse(boolean check,T trueValue,T falseValue)
	{
		return check ? trueValue : falseValue;
	}
	
	public static final String getIp(HttpServletRequest request)
	{
		String ip = request.getHeader("X-Forwarded-For");  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("WL-Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("HTTP_CLIENT_IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getRemoteAddr();  
		}  
		return ip;  
	}
	
	public static final <S,T> T copy(S source,Class<T> targetClass)throws NullPointerException
	{
		if(null == source || targetClass == null)
			throw new NullPointerException("source or targetClass is null");
		try 
		{
			T target = targetClass.newInstance();
			BeanUtils.copyProperties(source,target);
			return target;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		throw new NullPointerException("targetClass is null");
	}
	
	/**
	 * 每76添加 \r\n
	 * */
	private static final String jdkCodecBase64(String str)
	{
		return new BASE64Encoder().encode(str.getBytes());
	}
	/**
	 * 每76添加 \r\n 并且在最后固定加上\r\n
	 * */
	private static final String apacheCodecBase64(String str)
	{
		return new String(new Base64().encode(str.getBytes()));
	}
	
	public static final String BASE64_CODE= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";  
	/**每76添加\r\n*/
	public static final String encode(String str)
	{
		if(str == null)
			return null;
		byte[] bytes = str.getBytes();
		int count = bytes.length / 3;
		int mod   = bytes.length % 3;
		int offset = 0;
		int len = count * 4  + (mod > 0 ? 3 + 1 : 0);
		final int newLineChars = 2;
		int newLine = len / 76 * newLineChars;//每76个字符添加\r\n
		CharBuffer charBuffer = CharBuffer.allocate(len + newLine);
		int newLineCount = 0;
		while(offset < count)
		{
			int first  = (bytes[offset * 3] >> 2) & 0x3F;
			int secend = (bytes[offset * 3] << 4 & 0x30) + ((bytes[offset * 3 + 1] >> 4) & 0x0F);
			int third  = (bytes[offset * 3 +1] << 2 & 0x3C) + ((bytes[offset * 3 + 2] >> 6) & 0x03);
			int four   = (bytes[offset * 3 + 2]) & 0x3F;
			offset++;
			charBuffer.put(BASE64_CODE.charAt(first));
			charBuffer.put(BASE64_CODE.charAt(secend));
			charBuffer.put(BASE64_CODE.charAt(third));
			charBuffer.put(BASE64_CODE.charAt(four));
			if(charBuffer.position() > 0 && (((charBuffer.position() - (newLineCount * newLineChars)) % 76) == 0)){
				charBuffer.put('\r');
				charBuffer.put('\n');
				newLineCount++;
			}
		}
		
		if(mod > 0){
			int pad = 6 - (mod << 3) % 6;//按6位补齐
			if(pad == 4){
				//只有一个字节
				int first  = (bytes[offset * 3] >> 2) & 0x3F;
				int secend = (bytes[offset * 3] << 4 & 0x30);
				charBuffer.put(BASE64_CODE.charAt(first));
				charBuffer.put(BASE64_CODE.charAt(secend));
			}else if(pad == 2){
				//有2个字节
				int first  = (bytes[offset * 3] >> 2) & 0x3F;
				int secend = (bytes[offset * 3] << 4 & 0xC0) + ((bytes[offset * 3 + 1] >> 4) & 0x0F); 
				int third  = (bytes[offset * 3 +1] << 2 & 0x3C);
				charBuffer.put(BASE64_CODE.charAt(first));
				charBuffer.put(BASE64_CODE.charAt(secend));
				charBuffer.put(BASE64_CODE.charAt(third));
			}
			for (int i = 0; i < 3 - mod; i++) {
				charBuffer.put('=');
			}
			if(charBuffer.position() > 0 && (((charBuffer.position() - (newLineCount * newLineChars)) % 76) == 0)){
				charBuffer.put('\r');
				charBuffer.put('\n');
				newLineCount++;
			}
		}
		charBuffer.flip();
		return charBuffer.toString();
	}

	public static final Date now() 
	{
		return new Date();
	}
	
	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		Matcher m = p.matcher(str);
		return m.matches();
	}
	
	public static final char[] chars = "0123456789ABCDEF".toCharArray();

    public static final String ALL = "0123456789QWERTYUIOPASDFGHJKLZXCVBNM";

    public static final String LETTER = "QWERTYUIOPASDFGHJKLZXCVBNM";
	
	/**
     * @param str the str
     * @return string
     * @throws Exception the exception
     */
    public static String md5(String str) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        StringBuilder sb = new StringBuilder();
        for (byte b : md5.digest(str.getBytes("utf-8"))) {
            sb.append(str2HexStr(b));
        }
        return sb.toString();
    }
    
    /**
     * Str to hex str.
     * @param b the b
     * @return the string
     */
    public static String str2HexStr(byte b) {
        char[] r = new char[2];
        int bit = (b & 0x0f0) >> 4;
        r[0] = chars[bit];
        bit = b & 0x0f;
        r[1] = chars[bit];
        String str = new String(r);
        return str;
    }
}
