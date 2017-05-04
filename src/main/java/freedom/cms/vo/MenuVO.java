package freedom.cms.vo;

import java.util.List;

import freedom.cms.domain.Menu;

/**  
 * 创建时间: 2017年5月4日 上午1:10:05  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: MenuVO.java  
 * 类说明:  
 */
public class MenuVO {

	private Menu menu;
	private List<Menu> children;
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "MenuVO [menu=" + menu + ", children=" + children + "]";
	}
}
