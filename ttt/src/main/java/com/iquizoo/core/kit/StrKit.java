package com.iquizoo.core.kit;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**字符串处理工具
 * @author majl
 *
 */
public class StrKit {

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
	
	public static void main(String[] args) 
	{
		String str = join(Lists.newArrayList("ttt","eee","ggg"), ",");
		
		System.out.println(str);
	}
}
