package com.example.anandh.roomdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
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

    @BindView(R.id.listOfStudent)
    TextView studentList;




    @BindView(R.id.save)
    Button save;


    private Students students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        students=new Students();
        students.setStudentId(Integer.parseInt(studID.getText().toString()));
        students.setStudentName(name.getText().toString());
        students.setStudentClass(Integer.parseInt(classID.getText().toString()));

        List<Students> studentsList=MainActivity.studentDatabase.studentDAO().getALlStudents();
        String studInfo="";
        for (Students stud :studentsList){

            int studID= stud.getStudentId();
            String studName=stud.getStudentName();
            int studClass=stud.getStudentClass();
            studInfo = studInfo +"\n\n"+ "id" +studID+"\n name:"+studName+"\n class:"+studClass;
            studentList.setText(studInfo);
        }

    }

    @OnClick(R.id.save)
    public void save(){

        MainActivity.studentDatabase.studentDAO().addStudent(students);
        students.setStudentId(Integer.parseInt(""));
        students.setStudentName("");
        students.setStudentClass(Integer.parseInt(""));
    }

    @OnClick(R.id.btnDelete)
    public void delete(){

        students.setStudentId(Integer.parseInt(deleteId.getText().toString()));
        MainActivity.studentDatabase.studentDAO().delete(students);
        students.setStudentId(Integer.parseInt(""));
    }
}
