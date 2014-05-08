package com.gdpost.aming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

@SuppressLint("SetJavaScriptEnabled") public class SubFragment extends Fragment {

	// private static final String TAG = "SoftwareFragment";
	// private ListView listView;
	View contextView;
	TextView mTextView;
	WebView wvShow;
	ImageView imgView;
	SQLiteDatabase sqldb;

	public static SubFragment newInstance() {
		return new SubFragment();
	}

	@Override
	public void onAttach(Activity activity) {
		// this.activity = activity;
		super.onAttach(activity);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    setUserVisibleHint(true);
	}

	@Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// 获取Activity传递过来的参数
		Bundle mBundle = getArguments();
		String title = mBundle.getString("arg");
		Integer productPosi = Integer.valueOf(mBundle.getString("productPosi"));
		//Log.v("ProductFragment", title);
		//Log.v(" ----- PF ProductPosi", String.valueOf(productPosi));
		
		setRetainInstance(true);
		//String mypath = "file:///android_asset/www/";
		//String sellpath = "file:///android_asset/www/sell";

		String[] mTabTitles = getResources().getStringArray(R.array.about_title);
		if (title.equals(mTabTitles[0])) {// 产品简介

			switch (productPosi) {
			case 1:


				break;
			case 2:


				break;
			case 3:


				break;
			case 4:


				break;
			}
		}
		return contextView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	public interface CalendarPageFragmentListener {
		void onSwitchToNextFragment();
	}
	
	public boolean onKeyDown(int keyCoder,KeyEvent event){
        if(wvShow.canGoBack() && keyCoder == KeyEvent.KEYCODE_BACK){
        	wvShow.goBack();   //goBack()表示返回webView的上一页面
            return true;
         }
         return false;
	}
}