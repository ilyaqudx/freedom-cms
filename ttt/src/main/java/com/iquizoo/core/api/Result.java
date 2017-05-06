package com.iquizoo.core.api;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;


/**
 * 返回结果
 * 
 * @author majl
 * 
 * @param <V>
 *            返回的数据
 */
public class Result<V>{

	
	private int code;
	private String msg;
	private V result;
	
	/**
	 * 结果码
	 * 	0-成功
	 * 	其他失败
	 */
	public static final int SUCCESS = 0, ERROR = -1;
	
	public V getResult() {
		return result;
	}

	public Result<V> setResult(V result) {
		this.result = result;
		return this;
	}

	public static final <V> Result<V> ok() {
		return ok(SUCCESS, null);
	}

	public static final <V> Result<V> ok(int code) {
		return ok(code, null);
	}

	public static final <V> Result<V> ok(V value) {
		return ok(SUCCESS, value);
	}
	
	public static final <V>  String toJson(Result<V> response)throws Exception
	{
		return toJson(response, null);
	}
	
	public static final <V>  String toJson(Result<V> response,String callback)throws Exception
	{
		String value = JSON.toJSONString(response);
		return StringUtils.isBlank(callback) ? value : callback + "(" + value + ")";
	}
	
	
	/**
	 * 默认成功代码(0)
	 * 
	 * @param value
	 *            实体内容
	 * @return
	 */
	public static final <V> Result<V> ok(int code, V v) 
	{
		return new Result<V>().setResult(v).setCode(code).setMsg("success");
	}
	
	/**
	 * 默认错误代码(-1)
	 * 
	 * @return
	 */
	public static final <V> Result<V> err() {
		return err("");
	}


	/**
	 * 默认错误代码(-1)
	 * 
	 * @return
	 */
	public static final <V> Result<V> err(String msg) 
	{
		return err(ERROR, msg);
	}
	
	public static final <V> Result<V> err(int code, String msg) 
	{
		return new Result<V>().setCode(code).setMsg(msg);
	}
	
	public static final <V> Result<V> err(APIExceptionCode e)
	{
		return new Result<V>().setCode(e.code).setMsg(e.msg);
	}

	
	public Result<V> setCode(int code) {
		this.code = code;
		return this;
	}
	
	public String getMsg() {
		return msg;
	}

	public Result<V> setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	
	public boolean isOk()
	{
		return code == SUCCESS;
	}
	
	public int getCode()
	{
		return this.code;
	}

	@Override
	public String toString() {
		return "ResponseResult [code=" + code + ", msg=" + msg + ", result=" + result + "]";
	}
}
