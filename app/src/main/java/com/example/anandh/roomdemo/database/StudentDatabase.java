package com.example.anandh.roomdemo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.anandh.roomdemo.dao.StandardDAO;
import com.example.anandh.roomdemo.dao.StudentDAO;
import com.example.anandh.roomdemo.Students;
import com.example.anandh.roomdemo.standard.Standared;

@Database(entities = {Students.class, Standared.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDAO studentDAO();

    public abstract StandardDAO standardDAO();
}
