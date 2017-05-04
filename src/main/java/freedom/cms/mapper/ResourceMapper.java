package freedom.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**  
 * 创建时间: 2017年5月4日 上午1:50:38  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: ResourceMapper.java  
 * 类说明:  
 */
@Mapper
public interface ResourceMapper {

	
	@Select(  "SELECT path FROM resource WHERE id IN("
			+ "SELECT resource_id FROM role_resource WHERE role_id = "
			+ "(SELECT role_id FROM user_role WHERE user_id = #{userId})"
			+ ")")
	public List<String> listUserResource(Long userId);
}
