package com.example.anandh.roomdemo;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.anandh.roomdemo.division.Division;
import com.example.anandh.roomdemo.standard.Standared;

@Entity(foreignKeys = {@ForeignKey(entity = Standared.class,
		parentColumns = "studentId",
		childColumns = "standard_class_id"),

		@ForeignKey(entity = Division.class,
				parentColumns = "studentId",
				childColumns = "division_id")})

public class Students {

	@PrimaryKey
	private int studentId;

	@ColumnInfo(name = "student_name")
	private String studentName;

	@ColumnInfo(name = "standard_class_id")//this ID points to standard
	private String studentClass;

	@ColumnInfo(name = "division_id")//this ID points to division
	private String divisionId;

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

}
