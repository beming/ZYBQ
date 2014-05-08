package com.gdpost.aming;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class AboutActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutactivity);
		
		FragmentManager fm = getSupportFragmentManager();  
        // 只當容器，主要內容已Fragment呈現  
		FragmentTransaction ft = fm.beginTransaction();  
        ft.replace(R.id.simple_fragment, new AboutFragment());  
        //ft.addToBackStack(null);  
        ft.commit();
	}

}
