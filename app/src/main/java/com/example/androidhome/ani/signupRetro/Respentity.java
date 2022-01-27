package com.example.androidhome.ani.signupRetro;

import com.google.gson.annotations.SerializedName;

public class Respentity{


	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}