package com.example.anandh.roomdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStudent extends AppCompatActivity {

	@BindView(R.id.name)
	EditText name;

	@BindView(R.id.id)
	EditText studID;
	@BindView(R.id.calssNameStanadard)
	EditText classID;
	@BindView(R.id.deleteID)
	EditText deleteId;
	@BindView(R.id.saveStudentData)
	Button save;
	@BindView(R.id.btnUpdateStudent)
	Button update;


	private Students students;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_student);
		ButterKnife.bind(this);
	}

	@OnClick(R.id.saveStudentData)
	public void saveStudentData() {

		students = new Students();
		students.setStudentId(Integer.parseInt(studID.getText().toString()));
		students.setStudentName(name.getText().toString());
		students.setStudentClass(classID.getText().toString());
		MainActivity.studentDatabase.studentDAO().addStudent(students);
	}

	@OnClick(R.id.btnUpdateStudent)
	public void updateStudent() {
		students = new Students();
		students.setStudentId(Integer.parseInt(studID.getText().toString()));
		students.setStudentName(name.getText().toString());
		students.setStudentClass(classID.getText().toString());
		MainActivity.studentDatabase.studentDAO().updateStudent(students);
	}

	@OnClick(R.id.btnDelete)
	public void delete() {
		Students stud = new Students();
		stud.setStudentId(Integer.parseInt(deleteId.getText().toString()));
		MainActivity.studentDatabase.studentDAO().delete(stud);
		//students.setStudentId(Integer.parseInt(""));
	}
}
