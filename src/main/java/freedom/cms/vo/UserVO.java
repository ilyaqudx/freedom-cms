package freedom.cms.vo;

import freedom.cms.domain.User;

public class UserVO extends User
{

	//推荐人姓名
	private String recommenderName;
	//安置人姓名
	private String settlerName;
	public String getRecommenderName() {
		return recommenderName;
	}
	public void setRecommenderName(String recommenderName) {
		this.recommenderName = recommenderName;
	}
	public String getSettlerName() {
		return settlerName;
	}
	public void setSettlerName(String settlerName) {
		this.settlerName = settlerName;
	}
	@Override
	public String toString() {
		return "UserVO [recommenderName=" + recommenderName + ", settlerName=" + settlerName + "]";
	}
}
