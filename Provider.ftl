package ${package};

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import ${allClassName};

public interface ${className}Mapper {

	@SelectKey(statement = "SELECT @@IDENTITY AS ID",before = false,keyColumn = "id" , keyProperty = "id" , resultType = Long.class)
	@InsertProvider(type = ${className}Provider.class,method = "insert")
	public Long insert(${className} ${className ? uncap_first});
	
	@DeleteProvider(type = ${className}Provider.class,method = "delete")
	public Long delete(Long id);
	
	@UpdateProvider(type = ${className}Provider.class,method = "update")
	public void update(${className} ${className ? uncap_first});
	
	@SelectProvider(type = ${className}Provider.class,method = "get")
	public ${className} get(Long id);
	
	@SelectProvider(type = ${className}Provider.class,method = "list")
	public List<${className}> list(Map<String,Object> params);

	public class ${className}Provider {

		public String insert(${className} ${className ? uncap_first}) {
			return ${insertBody};
		}
		
		public String delete(${className} ${className ? uncap_first}){
			return ${deleteBody};
		}
		
		public String get(Long id){
			return ${selectBody};
		}
		
		public String list(Map<String,Object> params)
		{
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM ${className}");
			Iterator<Entry<String, Object>> it = params.entrySet().iterator();
			if(it.hasNext()){
				Entry<String, Object> e = it.next();
				//手动添加
			}
			return sql.toString();
		}
		
		public String update(${className} ${className ? uncap_first}) {
			${updateBody}
		}
	}
}
