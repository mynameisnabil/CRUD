package com.example.crud.model;

import java.lang.annotation.Annotation;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseData implements SerializedName{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private boolean status;

	public String getPesan(){
		return pesan;
	}

	public List<DataItem> getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
	public String value() {
		return null;
	}

	@Override
	public String[] alternate() {
		return new String[0];
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		return null;
	}
}