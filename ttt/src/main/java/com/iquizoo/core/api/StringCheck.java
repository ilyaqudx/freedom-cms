package com.iquizoo.core.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCheck {

	/**
	 * 替换掉字符串中的
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String checkString(String str) throws Exception{
		Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;
	    Matcher emojiMatcher = emoji.matcher(str);
	    if ( emojiMatcher.find())
	    {
	        str = emojiMatcher.replaceAll("*");
	    }
	    return str;
	}
}
