package com.example.anandh.roomdemo.standard;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.anandh.roomdemo.Students;

@Entity
public class Standared {

	@PrimaryKey
    @ColumnInfo (name = "standardId")
    private int standardId;

    @ColumnInfo (name = "standardName")
    private String standardName;

	public int getStandardId() {
		return standardId;
	}

	public void setStandardId(int standardId) {
		this.standardId = standardId;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
}
