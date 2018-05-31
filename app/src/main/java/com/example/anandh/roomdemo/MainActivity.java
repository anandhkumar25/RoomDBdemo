package com.example.anandh.roomdemo;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.anandh.roomdemo.database.StudentDatabase;
import com.example.anandh.roomdemo.standard.AddStandards;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


	@BindView(R.id.listOfStudent)
	TextView studentList;

	private Activity mActivity;
	public static StudentDatabase studentDatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		mActivity = this;
		studentDatabase = Room.databaseBuilder(getApplicationContext(), StudentDatabase.class, "studentdb").allowMainThreadQueries().build();
	}

	@OnClick(R.id.addStudent)
	public void addStudent() {
		startActivity(new Intent(mActivity, AddStudent.class));
	}

	@OnClick(R.id.btnAddStandard)
	public void addStandards() {
		startActivity(new Intent(mActivity, AddStandards.class));
	}

	@OnClick(R.id.viewStudentInfo)
	public void seeStudentInfo() {

		List<Students> studentsList = MainActivity.studentDatabase.studentDAO().getALlStudents();
		String studInfo = "";
		for (Students stud : studentsList) {
			int studID = stud.getStudentId();
			String studName = stud.getStudentName();
			String studClass = stud.getStudentClass();
			studInfo = studInfo + "\n\n" + "id: " + studID + "\n name: " + studName + "\n class: " + studClass;
			studentList.setText(studInfo);
		}

	}


}
