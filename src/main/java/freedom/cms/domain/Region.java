package freedom.cms.domain;

public class Region {

	private Integer code;
	private Integer parentCode;
	private Integer type;
	private String name;
	private String fullName;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getParentCode() {
		return parentCode;
	}
	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "Region [code=" + code + ", parentCode=" + parentCode + ", type=" + type + ", name=" + name
				+ ", fullName=" + fullName + "]";
	}
	
}
