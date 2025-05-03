package com.shisui.unleasherz;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import android.view.ViewStructure;

public class Selector implements OnItemSelectedListener {

	private static int posty;

	
	public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		
					   posty=pos;
					   
	}
	public static int getData(){ 
	return posty;
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

}




	
