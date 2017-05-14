package freedom.cms.vo;

import freedom.cms.domain.CashOrder;

public class CashOrderVO extends CashOrder{

	private String code;
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CashOrderVO [code=" + code + ", name=" + name + "]";
	}
}
