package freedom.cms.vo;

public class ChangePasswordVO {

	private String oldLoginPassword;
	private String newLoginPassword;
	private String oldPayPassword;
	private String newPayPassword;
	@Override
	public String toString() {
		return "ChangePasswordVO [oldLoginPassword=" + oldLoginPassword + ", newLoginPassword=" + newLoginPassword
				+ ", oldPayPassword=" + oldPayPassword + ", newPayPassword=" + newPayPassword + "]";
	}
	public String getOldLoginPassword() {
		return oldLoginPassword;
	}
	public void setOldLoginPassword(String oldLoginPassword) {
		this.oldLoginPassword = oldLoginPassword;
	}
	public String getNewLoginPassword() {
		return newLoginPassword;
	}
	public void setNewLoginPassword(String newLoginPassword) {
		this.newLoginPassword = newLoginPassword;
	}
	public String getOldPayPassword() {
		return oldPayPassword;
	}
	public void setOldPayPassword(String oldPayPassword) {
		this.oldPayPassword = oldPayPassword;
	}
	public String getNewPayPassword() {
		return newPayPassword;
	}
	public void setNewPayPassword(String newPayPassword) {
		this.newPayPassword = newPayPassword;
	}
}
