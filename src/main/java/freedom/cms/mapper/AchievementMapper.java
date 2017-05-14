package freedom.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import freedom.cms.Kit;
import freedom.cms.domain.Achievement;
import freedom.cms.query.AchievementQuery;
@Mapper
public interface AchievementMapper {

	@SelectKey(statement = "SELECT @@IDENTITY AS ID",before = false,keyColumn = "id" , keyProperty = "id" , resultType = Long.class)
	@InsertProvider(type = AchievementProvider.class,method = "insert")
	public Long insert(Achievement achievement);
	
	@DeleteProvider(type = AchievementProvider.class,method = "delete")
	public Long delete(Long id);
	
	@UpdateProvider(type = AchievementProvider.class,method = "update")
	public void update(Achievement achievement);
	
	@SelectProvider(type = AchievementProvider.class,method = "get")
	public Achievement get(Long id);
	
	@SelectProvider(type = AchievementProvider.class,method = "getByCode")
	public Achievement getByCode(String code);
	
	@SelectProvider(type = AchievementProvider.class,method = "list")
	public List<Achievement> list(AchievementQuery achievement);

	public class AchievementProvider {

		public String insert(Achievement achievement) {
			return "INSERT INTO Achievement(code,electronicCoin,repeatSaleCoin,bonusCoin,baoDanCoin,baoDanGouWuCoin,leftChild,rightChild,level,electCoinCumulative,openShopStatus) "
					+ "VALUES(#{code},#{electronicCoin},#{repeatSaleCoin},#{bonusCoin},#{baoDanCoin},#{baoDanGouWuCoin},#{leftChild},#{rightChild},#{level},#{electCoinCumulative},#{openShopStatus})";
		}
		
		public String delete(Achievement achievement){
			return "DELETE FROM Achievement WHERE id = #{id};";
		}
		
		public String get(Long id){
			return "SELECT * FROM Achievement WHERE id = #{id};";
		}
		
		public String getByCode(String code){
			return "SELECT * FROM Achievement WHERE code = #{code} LIMIT 1;";
		}
		
		public String list(AchievementQuery achievement)
		{
			StringBuilder sql = new StringBuilder();
			String str = "SELECT * FROM  Achievement WHERE 1 = 1 %s";
			if (Kit.isNotBlank(achievement.getCode())) {
				sql.append(",code = #{code}");
			}
			if (Kit.isNotBlank(achievement.getElectronicCoin())) {
				sql.append(",electronicCoin = #{electronicCoin}");
			}
			if (Kit.isNotBlank(achievement.getRepeatSaleCoin())) {
				sql.append(",repeatSaleCoin = #{repeatSaleCoin}");
			}
			if (Kit.isNotBlank(achievement.getBonusCoin())) {
				sql.append(",bonusCoin = #{bonusCoin}");
			}
			if (Kit.isNotBlank(achievement.getBaoDanCoin())) {
				sql.append(",baoDanCoin = #{baoDanCoin}");
			}
			if (Kit.isNotBlank(achievement.getBaoDanGouWuCoin())) {
				sql.append(",baoDanGouWuCoin = #{baoDanGouWuCoin}");
			}
			if (Kit.isNotBlank(achievement.getLeftChild())) {
				sql.append(",leftChild = #{leftChild}");
			}
			if (Kit.isNotBlank(achievement.getRightChild())) {
				sql.append(",rightChild = #{rightChild}");
			}
			if (Kit.isNotBlank(achievement.getLevel())) {
				sql.append(",level = #{level}");
			}
			return String.format(str, sql.toString());
		}
		
		public String update(Achievement achievement) {
			StringBuilder sql = new StringBuilder();
			String str = "UPDATE Achievement SET id = #{id} %s WHERE id = #{id}";
			if (Kit.isNotBlank(achievement.getCode())) {
				sql.append(",code = #{code}");
			}
			if (Kit.isNotBlank(achievement.getElectronicCoin())) {
				sql.append(",electronicCoin = #{electronicCoin}");
			}
			if (Kit.isNotBlank(achievement.getRepeatSaleCoin())) {
				sql.append(",repeatSaleCoin = #{repeatSaleCoin}");
			}
			if (Kit.isNotBlank(achievement.getBonusCoin())) {
				sql.append(",bonusCoin = #{bonusCoin}");
			}
			if (Kit.isNotBlank(achievement.getBaoDanCoin())) {
				sql.append(",baoDanCoin = #{baoDanCoin}");
			}
			if (Kit.isNotBlank(achievement.getBaoDanGouWuCoin())) {
				sql.append(",baoDanGouWuCoin = #{baoDanGouWuCoin}");
			}
			if (Kit.isNotBlank(achievement.getLeftChild())) {
				sql.append(",leftChild = #{leftChild}");
			}
			if (Kit.isNotBlank(achievement.getRightChild())) {
				sql.append(",rightChild = #{rightChild}");
			}
			if (Kit.isNotBlank(achievement.getLevel())) {
				sql.append(",level = #{level}");
			}
			return String.format(str, sql.toString());
		}
	}
}
