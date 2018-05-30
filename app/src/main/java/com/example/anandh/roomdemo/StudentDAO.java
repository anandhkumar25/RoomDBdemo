package com.example.anandh.roomdemo;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    public void addStudent(Students students);

    @Query("select * from students")
    public List<Students> getALlStudents();

    @Delete
    public void delete(Students students);

    @Update
    public void updateStudent(Students students);
}
