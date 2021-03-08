package org.oday.Messanger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExciptionError {

	private String msg;
	private int errorcode;
	public ExciptionError(String msg, int errorcode) {
		super();
		this.msg = msg;
		this.errorcode = errorcode;
	}
	

	public ExciptionError() {
		super();
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	
	
}
