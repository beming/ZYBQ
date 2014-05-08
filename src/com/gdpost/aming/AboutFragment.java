package com.gdpost.aming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("SetJavaScriptEnabled") public class AboutFragment extends Fragment {

	// private static final String TAG = "SoftwareFragment";
	// private ListView listView;
	View contextView;
	TextView mTextView;
	WebView wvShow;
	ImageView imgView;
	SQLiteDatabase sqldb;

	public static AboutFragment newInstance() {
		return new AboutFragment();
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
		
		setRetainInstance(true);
		View contextView = inflater.inflate(R.layout.about, container, false);
		WebView wvShow = (WebView) contextView.findViewById(R.id.logView);
		wvShow.getSettings().setSupportZoom(true);
		wvShow.getSettings().setBuiltInZoomControls(true);
		wvShow.loadUrl("file:///android_asset/www/log.html");
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