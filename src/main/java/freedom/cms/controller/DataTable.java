package freedom.cms.controller;

import java.util.List;

import com.github.pagehelper.Page;

public class DataTable<E> extends Page<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8079181858877147022L;
	
    private List<E> data;
    private int recordsTotal;
	public List<E> getData() {
		return data;
	}
	public void setData(List<E> data) {
		this.data = data;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
}
