package com.example.anandh.roomdemo.standard;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anandh.roomdemo.R;
import com.example.anandh.roomdemo.database.StudentDatabase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStandards extends AppCompatActivity {

	@BindView(R.id.etStandardName)
	EditText standName;
	@BindView(R.id.etStandardId)
	EditText standID;
	@BindView(R.id.listOfStandard)
	TextView listOfStandard;
	StudentDatabase studentDatabase;

	private Standared standared;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_standards);
		ButterKnife.bind(this);
		studentDatabase = Room.databaseBuilder(getApplicationContext(), StudentDatabase.class, "standard_db").allowMainThreadQueries().build();
	}


	@OnClick(R.id.btnAddStand)
	public void addStandards() {
		standared = new Standared();
		standared.setStandardName(standName.getText().toString());
		standared.setStandardId(Integer.parseInt(standID.getText().toString()));
		studentDatabase.standardDAO().addStandard(standared);
	}

	@OnClick(R.id.btnStandDetails)
	public void seeStandardInfo() {

		List<Standared> standaredsList = studentDatabase.standardDAO().getAlStandard();
		String standInfo = "";
		for (Standared stand : standaredsList) {
			int standID = stand.getStandardId();
			String standName = stand.getStandardName();

			standInfo = standInfo + "\n\n" + "id: " + standID + "\n name: " + standName;
			listOfStandard.setText(standInfo);
		}
	}
}
