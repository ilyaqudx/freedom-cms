package freedom.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import freedom.cms.Kit;
import freedom.cms.domain.CashOrder;
import freedom.cms.query.CashOrderQuery;
@Mapper
public interface CashOrderMapper {

	@InsertProvider(type = CashOrderProvider.class,method = "insert")
	public Long insert(CashOrder cashOrder);
	
	@DeleteProvider(type = CashOrderProvider.class,method = "delete")
	public Long delete(Long id);
	
	@UpdateProvider(type = CashOrderProvider.class,method = "update")
	public void update(CashOrder cashOrder);
	
	@SelectProvider(type = CashOrderProvider.class,method = "get")
	public CashOrder get(Long id);
	
	@SelectProvider(type = CashOrderProvider.class,method = "list")
	public List<CashOrder> list(CashOrderQuery cashOrder);

	public class CashOrderProvider {

		public String insert(CashOrder cashOrder) {
		 	return "INSERT INTO CashOrder(orderNo,userId,amount,actualAmount,status,operator,remark,createTime,updateTime) VALUES(#{orderNo},#{userId},#{amount},#{actualAmount},#{status},#{operator},#{remark},#{createTime},#{updateTime})" ;
		}
		
		public String delete(CashOrder cashOrder){
			return "DELETE FROM CashOrder WHERE orderNo = #{orderNo};";
		}
		
		public String get(String orderNo){
			return "SELECT * FROM CashOrder WHERE orderNo = #{orderNo};";
		}
		
		public String list(CashOrderQuery cashOrder)
		{
			StringBuilder sql = new StringBuilder();
			String str = "SELECT * FROM  CashOrder WHERE 1 = 1 %s";
			if (Kit.isNotBlank(cashOrder.getOrderNo())) {
				sql.append(",orderNo = #{orderNo}");
			}
			if (Kit.isNotBlank(cashOrder.getUserId())) {
				sql.append(",userId = #{userId}");
			}
			if (Kit.isNotBlank(cashOrder.getAmount())) {
				sql.append(",amount = #{amount}");
			}
			if (Kit.isNotBlank(cashOrder.getActualAmount())) {
				sql.append(",actualAmount = #{actualAmount}");
			}
			if (Kit.isNotBlank(cashOrder.getStatus())) {
				sql.append(",status = #{status}");
			}
			if (Kit.isNotBlank(cashOrder.getOperator())) {
				sql.append(",operator = #{operator}");
			}
			if (Kit.isNotBlank(cashOrder.getCreateTime())) {
				sql.append(",createTime = #{createTime}");
			}
			if (Kit.isNotBlank(cashOrder.getUpdateTime())) {
				sql.append(",updateTime = #{updateTime}");
			}
			return String.format(str, sql.toString());
		}
		
		public String update(CashOrder cashOrder) {
			StringBuilder sql = new StringBuilder();
			String str = "UPDATE SET CashOrder id = #{id} %s WHERE id = #{id}";
			if (Kit.isNotBlank(cashOrder.getOrderNo())) {
				sql.append(",orderNo = #{orderNo}");
			}
			if (Kit.isNotBlank(cashOrder.getUserId())) {
				sql.append(",userId = #{userId}");
			}
			if (Kit.isNotBlank(cashOrder.getAmount())) {
				sql.append(",amount = #{amount}");
			}
			if (Kit.isNotBlank(cashOrder.getActualAmount())) {
				sql.append(",actualAmount = #{actualAmount}");
			}
			if (Kit.isNotBlank(cashOrder.getStatus())) {
				sql.append(",status = #{status}");
			}
			if (Kit.isNotBlank(cashOrder.getOperator())) {
				sql.append(",operator = #{operator}");
			}
			if (Kit.isNotBlank(cashOrder.getCreateTime())) {
				sql.append(",createTime = #{createTime}");
			}
			if (Kit.isNotBlank(cashOrder.getUpdateTime())) {
				sql.append(",updateTime = #{updateTime}");
			}
			return String.format(str, sql.toString());
		}
	}
}
