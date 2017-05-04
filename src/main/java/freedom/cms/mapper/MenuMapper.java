package freedom.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import freedom.cms.domain.Menu;

/**  
 * 创建时间: 2017年5月3日 下午11:51:46  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: MenuMapper.java  
 * 类说明:  
 */
@Mapper
public interface MenuMapper {

	@Select("SELECT * FROM menu WHERE parent_id = 0")
	public List<Menu> listParentMenu();
	@Select("SELECT * FROM menu WHERE parent_id = #{parentId}")
	public List<Menu> listChildren(Long parentId);
}
