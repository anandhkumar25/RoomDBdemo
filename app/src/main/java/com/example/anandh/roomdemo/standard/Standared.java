package com.example.anandh.roomdemo;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Standared {

    @PrimaryKey
    private int standardId;
    
    @ColumnInfo (name = "class_name")
    private int standaredName;
}
