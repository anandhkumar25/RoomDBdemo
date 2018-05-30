package com.example.anandh.roomdemo;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.anandh.roomdemo.database.StudentDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nameUpdate)
    EditText updateName;

    @BindView(R.id.idStudentUpdate)
    EditText studIDUPdate;
    @BindView(R.id.calssNameStanadardUpdate)
    EditText classIDUpadte;

    @BindView(R.id.update)
    Button upadte;

    private Activity mActivity;
    public static StudentDatabase studentDatabase;
    private Students students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mActivity=this;
        studentDatabase= Room.databaseBuilder(getApplicationContext(),StudentDatabase.class,"studentdb").allowMainThreadQueries().build();
    }

    @OnClick(R.id.update)
    public void upadte(){
        students=new Students();
        students.setStudentId(Integer.parseInt(studIDUPdate.getText().toString()));
        students.setStudentName(updateName.getText().toString());
        students.setStudentClass(Integer.parseInt(classIDUpadte.getText().toString()));
        MainActivity.studentDatabase.studentDAO().updateStudent(students);
    }
}
