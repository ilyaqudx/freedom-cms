package freedom.cms.domain;
/**  
 * 创建时间: 2017年5月3日 下午11:57:43  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: Resource.java  
 * 类说明:  
 */
public class Resource {

	private Long id;
	private Long parentId;
	private String name;
	private String path;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", parentId=" + parentId + ", name="
				+ name + ", path=" + path + "]";
	}
}
