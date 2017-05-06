package com.iquizoo.core.api;



public class APIException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1980666124535757769L;

	private int code;

	private String msg;

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public APIException(APIExceptionCode code)
	{
		super();
		this.code = code.code;
		this.msg = code.msg;

	}

	public APIException()
	{
		super();
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

}
