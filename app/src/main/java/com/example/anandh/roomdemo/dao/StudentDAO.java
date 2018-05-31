package com.example.anandh.roomdemo.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.anandh.roomdemo.Students;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    public void addStudent(Students students);

    @Query("select * from students")
    List<Students> getALlStudents();


    @Query("select student_name from students where standard_class_id is :standardClassName")
    List<Students> getStudentForClass(String standardClassName);



    @Query("select student_name from students where standard_class_id is :standardClassName and division_id is :division")
    List<Students> getStudentForClassWithDivision(String standardClassName, String division);

    @Delete
    void delete(Students students);

    @Update
    void updateStudent(Students students);
}
