package freedom.cms;
import java.lang.reflect.Field;

import freedom.cms.domain.Achievement;

public class Generater {

	public static void main1(String[] args) {
		
		Class<?> clazz = Achievement.class;
		StringBuilder create = new StringBuilder();
		String template= "create table %s(%s)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4";
	
	
		StringBuilder sb = new StringBuilder();
		Field[] fs = clazz.getDeclaredFields();
		boolean hasId = false;
		int count = fs.length;
		int i = 1;
		for (Field f : fs) {
			f.setAccessible(true);
			String name = f.getName();
			Class<?> type = f.getType();
			if(!"serialVersionUID".equals(name))
			{
				sb.append(name);
				if(type == Integer.class){
					sb.append(" int(11) not null").append(name.equals("id") ? "" :  "  default 0");
				}
				else if(type == Long.class)
					sb.append(" bigint(20) not null").append(name.equals("id") ? "" :  "  default 0");
				else if(type == String.class)
					sb.append(" varchar(255)");
				else if(type == java.util.Date.class)
					sb.append(" datetime default null");
				else if(type == java.lang.Double.class)
					sb.append(" double default null");
				if(name.equals("id")){
					sb.append(" auto_increment");
				}
			}
			if(i++ < count && !"serialVersionUID".equals(name))
				sb.append(",");
			
			if(i > count && hasId){
				sb.append(" ,PRIMARY KEY (`id`)");
			}
			
			if(name.equals("id"))
				hasId = true;
		}
		
		String sql = String.format(template, clazz.getSimpleName(),sb.toString());
		System.out.println(sql);
		
		System.out.println(createSqlmap(clazz));
	}
	public static final <T> String createSqlmap(Class<T> clazz)
	{
		String selectKey = "<selectKey keyColumn=\"id\" keyProperty=\"id\" resultType=\"Integer\">SELECT LAST_INSERT_ID()</selectKey>";
		String template = "insert into %s(%s) values(%s)";
		Field[] fs = clazz.getDeclaredFields();
		StringBuilder first = new StringBuilder();
		StringBuilder two   = new StringBuilder();
		boolean isFirst = false;
		for (Field f : fs) {
			f.setAccessible(true);
			String name = f.getName();
			if(!"serialVersionUID".equals(name))
			{
				if(!isFirst){
					isFirst = true;
					first.append(name);
					two.append("#{" +name+ "}");
				}else{
					first.append(",").append(name);
					two.append(",#{" +name+"}");
				}
			}
		}
		return String.format(template, clazz.getSimpleName(),first.toString(),two.toString());
	}
	
}
