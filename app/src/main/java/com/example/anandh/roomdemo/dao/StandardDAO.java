package com.example.anandh.roomdemo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.anandh.roomdemo.standard.Standared;

import java.util.List;

@Dao
public interface StandardDAO {

	@Insert
	public void addStandard(Standared standared);


	@Query("select * from standared")
	public List<Standared> getAlStandard();
}
