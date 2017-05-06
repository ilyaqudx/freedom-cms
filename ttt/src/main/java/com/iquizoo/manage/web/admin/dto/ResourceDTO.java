package com.iquizoo.manage.web.admin.dto;

/**
 * @Description 资源DTO
 * @author GouZhongLiang
 * @date 2015-11-23 下午8:30:44
 */
public class ResourceDTO {
	/**ID */
	private Integer id;	

	/**父节点url */
	private String parentUrl;	

	/**名称 */
	private String name;	

	/**地址 */
	private String url;

	/**描述*/
	private String description;
	
	/**日志1是0否*/
	private Integer log;
	
	/**权限1是0否*/
	private Integer authority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParentUrl() {
		return parentUrl;
	}

	public void setParentUrl(String parentUrl) {
		this.parentUrl = parentUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLog() {
		return log;
	}

	public void setLog(Integer log) {
		this.log = log;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	
}
