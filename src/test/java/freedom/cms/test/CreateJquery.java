package freedom.cms.test;

import java.lang.reflect.Field;

import freedom.cms.domain.User;

/**  
 * 创建时间: 2017年5月4日 下午11:48:13  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: CreateJquery.java  
 * 类说明:  
 */
public class CreateJquery {

	public static void main(String[] args) {
		
		Field[] fs = User.class.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		for (Field f : fs) {
			f.setAccessible(true);
			sb.append(String.format("var %s = $('#%s').val();\r\n",f.getName(),f.getName()));
		}
		System.out.println(sb.toString());
		
	}
}
