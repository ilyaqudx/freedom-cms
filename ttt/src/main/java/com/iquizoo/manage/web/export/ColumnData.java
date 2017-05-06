package com.iquizoo.manage.web.export;

/**数据库字段内容
 * @author JiangZhiYong
 * @date 2015年4月17日 16:32:28
 * */
public class ColumnData
{
	/**字段名称*/
	private String name;
	
	/**字段内容*/
	private String value;


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String toString() {
		return "ColumnData [name=" + name + ", value=" + value + "]";
	}
	
	
}
