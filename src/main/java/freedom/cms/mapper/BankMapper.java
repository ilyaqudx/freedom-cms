package freedom.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import freedom.cms.domain.Bank;

@Mapper
public interface BankMapper {

	@Select("select * from Bank")
	public List<Bank> list();
}
