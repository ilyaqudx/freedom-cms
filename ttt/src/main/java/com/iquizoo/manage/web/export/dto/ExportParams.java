package com.iquizoo.manage.web.export.dto;

/**
 * @Description 导出的参数
 * @author GouZhongLiang
 * @date 2016-9-27 下午3:39:35
 */
public class ExportParams {

	private int type;//类型
	
	private int excerciseId;//试题ID
	private String table;
	private int gameId;// 游戏ID
	private int zd;//终端
	
	private String area;//地区
	
	private String startTime;//开始时间
	
	private String endTime;//结束时间


	
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getExcerciseId() {
		return excerciseId;
	}

	public void setExcerciseId(int excerciseId) {
		this.excerciseId = excerciseId;
	}

	public int getZd() {
		return zd;
	}

	public void setZd(int zd) {
		this.zd = zd;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ExportParams [type=" + type + ", excerciseId=" + excerciseId
				+ ", table=" + table + ", gameId=" + gameId + ", zd=" + zd
				+ ", area=" + area + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	
}
