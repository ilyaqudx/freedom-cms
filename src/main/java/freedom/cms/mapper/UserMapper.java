package freedom.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

import freedom.cms.domain.User;

/**  
 * 创建时间: 2017年5月3日 下午12:26:15  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: UserMapper.java  
 * 类说明:  
 */
@Mapper
public interface UserMapper {

	@Insert("INSERT INTO user(name,identityCode,status,createTime) VALUES(#{name},#{identityCode},#{status},#{createTime})")
	@SelectKey(before = false,keyColumn = "id",statement = "select @@IDENTITY",statementType=StatementType.PREPARED,keyProperty="id",resultType=Long.class)
	public Long insert(User user);
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User get(Long id);
	
	@Select("SELECT * FROM user")
	public List<User> list();
	
	
}
