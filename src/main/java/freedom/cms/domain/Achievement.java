package freedom.cms.domain;
/**
 * 业绩
 * */
public class Achievement {

	private Long id;
	//会员ID
	private String code;
	//电子币
	private Double electronicCoin; 
	//复消币
	private Double repeatSaleCoin;
	//奖金币
	private Double bonusCoin;
	//报单币
	private Double baoDanCoin;
	//报单购物币
	private Double baoDanGouWuCoin;
	//左区底层会员
	private String leftChild;
	//右区底层会员
	private String rightChild;
	//会员级别
	private String level;
	//电子币复消单累计
	private Double electCoinCumulative;
	//开店状态描述
	private String openShopStatus;
	public Double getElectCoinCumulative() {
		return electCoinCumulative;
	}
	public void setElectCoinCumulative(Double electCoinCumulative) {
		this.electCoinCumulative = electCoinCumulative;
	}
	public String getOpenShopStatus() {
		return openShopStatus;
	}
	public void setOpenShopStatus(String openShopStatus) {
		this.openShopStatus = openShopStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getElectronicCoin() {
		return electronicCoin;
	}
	public void setElectronicCoin(Double electronicCoin) {
		this.electronicCoin = electronicCoin;
	}
	public Double getRepeatSaleCoin() {
		return repeatSaleCoin;
	}
	public void setRepeatSaleCoin(Double repeatSaleCoin) {
		this.repeatSaleCoin = repeatSaleCoin;
	}
	public Double getBonusCoin() {
		return bonusCoin;
	}
	public void setBonusCoin(Double bonusCoin) {
		this.bonusCoin = bonusCoin;
	}
	public Double getBaoDanCoin() {
		return baoDanCoin;
	}
	public void setBaoDanCoin(Double baoDanCoin) {
		this.baoDanCoin = baoDanCoin;
	}
	public Double getBaoDanGouWuCoin() {
		return baoDanGouWuCoin;
	}
	public void setBaoDanGouWuCoin(Double baoDanGouWuCoin) {
		this.baoDanGouWuCoin = baoDanGouWuCoin;
	}
	public String getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(String leftChild) {
		this.leftChild = leftChild;
	}
	public String getRightChild() {
		return rightChild;
	}
	public void setRightChild(String rightChild) {
		this.rightChild = rightChild;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
