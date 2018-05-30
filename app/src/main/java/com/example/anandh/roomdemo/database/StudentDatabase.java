package com.example.anandh.roomdemo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.anandh.roomdemo.StudentDAO;
import com.example.anandh.roomdemo.Students;

@Database(entities = {Students.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDAO studentDAO();
}
