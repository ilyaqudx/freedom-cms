package freedom.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import freedom.cms.domain.Region;
@Mapper
public interface RegionMaaper {

	@Select("select * from region where name = #{name} limit 1")
	public Region get(String name);
	
	/**省名称列表*/
	@Select("select name from region where type = 1")
	public List<String> listProvince();
	/**指定省-市全名列表 */
	@Select("select name from region where parentCode = #{parentCode}")
	public List<String> listCity(Integer parentCode);
}
