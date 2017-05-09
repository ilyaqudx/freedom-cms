package freedom.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;

import freedom.cms.Kit;
import freedom.cms.domain.User;
import freedom.cms.query.UserQuery;

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

	@Insert("insert into User(id,code,name,loginPassword,payPassword,phone,identityCode,sex,address,createTime,status,recommender,settler,bank,bankAccount,bankAccountName,bankAddress,province,city,area,receivingAddress,marketLocation) values(#{id},#{code},#{name},#{loginPassword},#{payPassword},#{phone},#{identityCode},#{sex},#{address},#{createTime},#{status},#{recommender},#{settler},#{bank},#{bankAccount},#{bankAccountName},#{bankAddress},#{province},#{city},#{area},#{receivingAddress},#{marketLocation})")
	@SelectKey(before = false,keyColumn = "id",statement = "select @@IDENTITY",statementType=StatementType.PREPARED,keyProperty="id",resultType=Long.class)
	public Long insert(User user);
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User get(Long id);
	@Select("select * from user where code = #{code}")
	public User getByCode(String code);
	@Select("select count(id) from user where code = #{code}")
	public Long isExist(String code);
	@SelectProvider(type=UserProvider.class,method = "list")
	public List<User> list(UserQuery query);
	public class UserProvider{
		public String list(UserQuery userQuery)
		{
			StringBuilder sql = new StringBuilder();
			String str = "select * from User where 1 = 1 %s";
			if (Kit.isNotBlank(userQuery.getStartTime())) {
				sql.append(" and createTime >= #{startTime}");
			}
			if (Kit.isNotBlank(userQuery.getEndTime())) {
				sql.append(" and createTime <= #{endTime}");
			}
			if (Kit.isNotBlank(userQuery.getCode())) {
				sql.append(" and code = #{code}");
			}
			if (Kit.isNotBlank(userQuery.getPhone())) {
				sql.append(" and phone = #{phone}");
			}
			if (Kit.isNotBlank(userQuery.getName())) {
				sql.append(" and name = #{name}");
			}
			return String.format(str, sql.toString());
		}
	}
}
