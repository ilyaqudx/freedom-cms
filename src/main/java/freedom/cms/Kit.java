package freedom.cms;

import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;

public class Kit {

	public static final int TRUE = 1,FALSE = 0;
	
	static Random r = new Random();
	
	public static final String generatorNumber(int length)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}
	
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
			return isBlank((String)obj);
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
    
    public static final boolean isEmpty(String str)
	{
		return null == str;
	}
	
	public static final boolean isNotEmpty(String str)
	{
		return !isEmpty(str);
	}
	
	public static final boolean isBlank(String str)
	{
		return null == str || "".equals(str);
	}
	
	public static final boolean isNotBlank(String str)
	{
		return !isBlank(str);
	}
	
	
	/**
	 * 首字母大写
	 * */
	public static final String firstUpper(String str)
	{
		if(isBlank(str))
			return str;
		char[] chars = str.toCharArray();
		char first = chars[0];
		if(first >= 'a' && first <= 'z')
			chars[0] = (char) (first - 32);
		return String.valueOf(chars);
	}
	
	/**
	 * 首字母小写
	 * */
	public static final String firstLower(String str)
	{
		if(isBlank(str))
			return str;
		char[] chars = str.toCharArray();
		char first = chars[0];
		if(first >= 'A' && first <= 'Z')
			chars[0] = (char) (first + 32);
		return String.valueOf(chars);
	}
	
	/**将列表元素以固定分隔符分割组成字符串返回
	 * @param list
	 * @param spliter
	 * @return
	 */
	public static final <T> String join(List<T> list,String spliter)
	{
		return null == list ? "" : join(list.toArray(), spliter);
	}
	
	/**将列表元素以固定分隔符分割组成字符串返回
	 * @param array
	 * @param spliter
	 * @return
	 */
	public static final <T> String join(T[] array,String spliter)
	{
		if(array == null || array.length == 0)
			return "";
		StringBuilder builder = new StringBuilder();
		builder.append(array[0]);
		int count = array.length;
		for(int i = 1;i < count;i++)
		{
			builder.append(spliter).append(array[i]);
		}
		return builder.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static final <T> List<T> split2NumberList(String str,String sep,Class<T> clazz)
		throws NullPointerException,NumberFormatException
	{
		if(null == str)
			throw new NullPointerException(str);
		if(null == sep)
			throw new NullPointerException(sep);
		
		String[] array = str.split(sep);
		
		List<T> data = new ArrayList<T>();
		
		Object value = null;
		for (String s : array) {
			
			if(clazz == int.class){
				 value = Integer.parseInt(s);
			}
			else if(clazz == long.class){
				 value = Long.parseLong(s);
			}
			else if(clazz == float.class){
				 value = Float.parseFloat(s);
			}
			else if(clazz == double.class){
				 value = Double.parseDouble(s);
			}
			
			data.add((T)value);
		}
		
		return data;
	}
}
