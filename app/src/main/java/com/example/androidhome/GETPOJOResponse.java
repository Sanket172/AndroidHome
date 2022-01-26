package com.example.androidhome;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GETPOJOResponse{

	@SerializedName("GETPOJOResponse")
	private List<GETPOJOResponseItem> gETPOJOResponse;
	public List<GETPOJOResponseItem> getGETPOJOResponse(){
		return gETPOJOResponse;
	}
}