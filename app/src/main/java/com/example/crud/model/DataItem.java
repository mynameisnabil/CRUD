package com.example.crud.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataItem implements Serializable {

	@SerializedName("nama_siswa")
	private String namaSiswa;

	@SerializedName("email_siswa")
	private String emailSiswa;

	@SerializedName("kelas_siswa")
	private String kelasSiswa;

	@SerializedName("id_siswa")
	private String idSiswa;

	public String getNamaSiswa(){
		return namaSiswa;
	}

	public String getEmailSiswa(){
		return emailSiswa;
	}

	public String getKelasSiswa(){
		return kelasSiswa;
	}

	public String getIdSiswa(){
		return idSiswa;
	}
}