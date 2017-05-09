package freedom.cms;

public class P{

	private Integer currentPage;
	private Integer prePage;
	private Integer nextPage;
	private Integer firstPage;
	private Integer lastPage;
	private Integer totalPage;
	private Long totalCount;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPrePage() {
		return currentPage > 1 ? currentPage - 1 : 1;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return currentPage < getTotalPage() ? currentPage + 1 : getTotalPage();
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getFirstPage() {
		return 1;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getLastPage() {
		return getTotalPage();
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "P [currentPage=" + currentPage + ", prePage=" + prePage + ", nextPage=" + nextPage + ", firstPage="
				+ firstPage + ", lastPage=" + lastPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ "]";
	}
	
}
