package com.iquizoo.config;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.iquizoo.config.database.Person;
import com.iquizoo.config.database.User;
import com.iquizoo.core.kit.StrKit;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class ReflectUtils {

	public static final int ORM_IBATIS = 1,ORM_MYBATIS = 2;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		Class<?> clazz = Person.class;
		String packageName = "freedom.mapper";
		String className   = clazz.getSimpleName();
		String allClassName= clazz.getName();
		String insertBody = reflectInsertSqlOfMybatis(clazz);
		String updateBody = reflectUpdateSqlOfMybatis(clazz);
		String deleteBody = reflectDeleteSqlOfMybatis(clazz);
		String selectBody = reflectSelectSqlOfMybatis(clazz);
		System.out.println(insertBody);
		System.out.println(updateBody);
		Person user = new Person();
		user.setId(100L);
		user.setPassword("123456");
		user.setName("abcd");
		user.setCreateTime(new Date());
		
		Configuration config = Configuration.getDefaultConfiguration();
		//设置模版目录
		config.setDirectoryForTemplateLoading(new File("F:/azy-maven-workspace-21/azy/azy-auto-config/src/main/resources/templates"));
		//获取Target模版
		//config.gettemplate
		Template template = config.getTemplate("Provider.ftl");
		Map<String,String> parameter = new HashMap<String,String>();
		parameter.put("package", packageName);
		parameter.put("className", className);
		parameter.put("allClassName", allClassName);
		parameter.put("insertBody", insertBody);
		parameter.put("deleteBody", deleteBody);
		parameter.put("updateBody", updateBody);
		parameter.put("selectBody", selectBody);
		//输出Target文件
		Writer fos = new FileWriter(new File(String.format("d:/%s.java", user.getClass().getSimpleName())));
		template.process(parameter, fos);
		fos.close();
	}
	
	public static final <T> String reflectDeleteSqlOfMybatis(Class<T> clazz)
	{
		return String.format("\"DELETE FROM %s WHERE id = #{id}\"", clazz.getSimpleName());
	}
	
	public static final <T> String reflectSelectSqlOfMybatis(Class<T> clazz)
	{
		return String.format("\"SELECT * FROM %s WHERE id = #{id}\"", clazz.getSimpleName());
	}
	
	public static final <T> String reflectInsertSqlOfIbatis(Class<T> clazz)
	{
		String insertFields = reflectInsertFields(clazz);
		String insertValues = reflectFieldValuesOfIbatis(clazz.getSimpleName(), insertFields);
		return insertValues;
	}
	public static final <T> String reflectInsertSqlOfMybatis(Class<T> clazz)
	{
		String insertFields = reflectInsertFields(clazz);
		String insertValues = reflectFieldValuesOfMybatis(clazz.getSimpleName(), insertFields);
		return insertValues;
	}
	
	public static final <T> String reflectUpdateSqlOfIbatis(Class<T> clazz)
	{
		String insertFields = reflectInsertFields(clazz);
		return reflectUpdateValuesOfIbatis(clazz.getSimpleName(), insertFields);
	}
	public static final <T> String reflectUpdateSqlOfMybatis(Class<T> clazz)
	{
		String insertFields = reflectInsertFields(clazz);
		return reflectUpdateValuesOfMybatis(clazz.getSimpleName(), insertFields);
	}
	
	private static final <T> String reflectInsertFields(Class<T> clazz)
	{
		boolean first = true;
		StringBuilder fieldBuilder = new StringBuilder();
		
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) 
		{
			String name = field.getName();
			if("id".equalsIgnoreCase(name))
				//默认ID为主键且自增,不需要放在insert,update字段中
				continue;
			Class<?> type = field.getType();
			
			try {
				boolean isBoolean = type.isAssignableFrom(boolean.class);
				Method getter = null;
				if(isBoolean)
					getter = clazz.getMethod("is" + StrKit.firstUpper(name), new Class<?>[]{});
				else 
					getter = clazz.getMethod("get" + StrKit.firstUpper(name),new Class<?>[]{});
				if(null != getter)
				{
					if(first){
						fieldBuilder.append(name);
						first = false;
					}else
						fieldBuilder.append(",").append(name);
				}
			}
			catch (NoSuchMethodException e) 
			{
				e.printStackTrace();
			}
			catch (SecurityException e) 
			{
				e.printStackTrace();
			}
		}
		
		return fieldBuilder.toString();
	}

	private static final <T> String reflectFieldValuesOfIbatis(String table,String insertFields)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append(table)
		.append("(").append(insertFields).append(")")
		.append(" VALUES(#").append(insertFields.replace(",", "#,#")).append("#)");
		
		return sql.toString();
	}
	
	private static final <T> String reflectFieldValuesOfMybatis(String table,String insertFields)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("\"");
		sql.append("INSERT INTO ").append(table)
		.append("(").append(insertFields).append(")")
		.append(" VALUES(#{").append(insertFields.replace(",", "},#{")).append("})")
		.append("\"");
		
		return sql.toString();
	}
	
	private static final <T> String reflectUpdateValuesOfIbatis(String table,String insertFields)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ").append(table)
		.append(" SET ");
		
		String[] fields = insertFields.split(",");
		int count = fields.length;
		int last = fields.length - 1;
		for (int i = 0;i < count ; i++) 
		{
			String field = fields[i];
			sql.append(" ").append(field).append(" = ").append("#").append(field).append("#");
			if(last != i)
				sql.append(",");
		}
		sql.append(" WHERE id = #id#");
		
		return sql.toString();
	}
	
	private static final <T> String reflectUpdateValuesOfMybatis(String table,String insertFields)
	{
		String str = "StringBuilder sql = new StringBuilder();";
		String template = "String str = \"UPDATE SET " +table+ " id = #{id} %s WHERE id = #{id}\";";
		StringBuilder sql = new StringBuilder();
		sql.append(str);
		sql.append(template);
		
		String[] fields = insertFields.split(",");
		int count = fields.length;
		for (int i = 0;i < count ; i++) 
		{
			String field = fields[i];
			sql.append("if(").append(StrKit.firstLower(table)).append(".get").append(StrKit.firstUpper(field)).append("()").append(" != null)").append("{");
			sql.append("sql.append(\"").append(",").append(field).append(" = ").append("#{").append(field).append("}");
			sql.append("\"").append(");");
			sql.append("}");
		}
		sql.append("return String.format(str,sql.toString());");
		
		return sql.toString();
	}
}
