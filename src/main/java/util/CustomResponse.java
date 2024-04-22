package util;

import java.util.Date;

public class CustomResponse<T> {

	private boolean sucess;
	private int code;
	private String message;
	private Date date;
	
	public CustomResponse() {
	}

	public CustomResponse(boolean sucess, int code, String message, Date date) {
		this.sucess = sucess;
		this.code = code;
		this.message = message;
		this.date = date;
	}

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
