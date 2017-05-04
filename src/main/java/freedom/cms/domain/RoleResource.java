package freedom.cms.domain;
/**  
 * 创建时间: 2017年5月3日 下午11:34:26  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: RoleResource.java  
 * 类说明:  
 */
public class RoleResource {

	private Long roleId;
	private Long resourceId;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	@Override
	public String toString() {
		return "RolePermission [roleId=" + roleId + ", resourceId="
				+ resourceId + "]";
	}
	
}
