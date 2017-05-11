package freedom.cms.vo;

public class LoginVO {

	private String code;
	private String loginPassword;
	private String kaptcha;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getKaptcha() {
		return kaptcha;
	}
	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}
	@Override
	public String toString() {
		return "LoginVO [code=" + code + ", loginPassword=" + loginPassword + ", kaptcha=" + kaptcha + "]";
	}
}
