package com.example.vitospizzaserver.utility;

public class StandardResponse {

	private Integer code;
    private String message;
    private Object data;
    
    
    public StandardResponse(Integer code, String message, Object data) {
    	this.code = code;
    	this.message = message;
    	this.data = data;
    }
    
    
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
    
}
