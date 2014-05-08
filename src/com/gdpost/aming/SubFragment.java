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
		Integer itemPosi = Integer.valueOf(mBundle.getString("itemPosi"));
		//Log.v("ItemFragment", title);
		//Log.v(" ----- PF itemPosi", String.valueOf(itemPosi));
		
		setRetainInstance(true);

		String[] mTabTitles = getResources().getStringArray(R.array.sub_title);
		
		contextView = inflater.inflate(R.layout.items, container, false);
		imgView = (ImageView) contextView.findViewById(R.id.pImg);
		imgView.setImageResource(R.drawable.zyrs);
		mTextView = (TextView) contextView.findViewById(R.id.ItemName);
		wvShow = (WebView) contextView.findViewById(R.id.show);
		//wvShow.getSettings().setLayoutAlgorithm(LayoutAlgorithm.TEXT_AUTOSIZING);
		wvShow.getSettings().setJavaScriptEnabled(true);
		wvShow.getSettings().setSupportZoom(true);
		wvShow.getSettings().setBuiltInZoomControls(true);
		
		if (title.equals(mTabTitles[0])) {// 产品简介
			switch (itemPosi) {
			case 1:
				mTextView.setText(R.string.yc);
				try {
					wvShow.loadUrl("file:///android_asset/www/yctj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				mTextView.setText(R.string.tb);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				mTextView.setText(R.string.zyjk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjktj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				mTextView.setText(R.string.zyhk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjktj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				mTextView.setText(R.string.scjlq);
				try {
					wvShow.loadUrl("file:///android_asset/www/scjlqtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				mTextView.setText(R.string.jfxxbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/jfxxbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				mTextView.setText(R.string.syrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/syrbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				mTextView.setText(R.string.tbrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbrbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				mTextView.setText(R.string.bdbf);
				try {
					wvShow.loadUrl("file:///android_asset/www/bdbftj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 10:
				mTextView.setText(R.string.jsbe);
				try {
					wvShow.loadUrl("file:///android_asset/www/jsbetj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 11:
				//search function 
				break;
			}
		} else if (title.equals(mTabTitles[1])) {// 产品简介
			switch (itemPosi) {
			case 1:
				mTextView.setText(R.string.yc);
				try {
					wvShow.loadUrl("file:///android_asset/www/yctj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				mTextView.setText(R.string.tb);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				mTextView.setText(R.string.zyjk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjktj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				mTextView.setText(R.string.zyhk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjktj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				mTextView.setText(R.string.scjlq);
				try {
					wvShow.loadUrl("file:///android_asset/www/scjlqtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				mTextView.setText(R.string.jfxxbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/jfxxbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				mTextView.setText(R.string.syrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/syrbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				mTextView.setText(R.string.tbrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbrbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				mTextView.setText(R.string.bdbf);
				try {
					wvShow.loadUrl("file:///android_asset/www/bdbftj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 10:
				mTextView.setText(R.string.jsbe);
				try {
					wvShow.loadUrl("file:///android_asset/www/jsbetj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 11:
				//search function 
				break;
			}
		} else if (title.equals(mTabTitles[2])) {// 产品简介
			switch (itemPosi) {
			case 1:
				mTextView.setText(R.string.yc);
				try {
					wvShow.loadUrl("file:///android_asset/www/yctj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				mTextView.setText(R.string.tb);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				mTextView.setText(R.string.zyjk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjktj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				mTextView.setText(R.string.zyhk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjktj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				mTextView.setText(R.string.scjlq);
				try {
					wvShow.loadUrl("file:///android_asset/www/scjlqtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				mTextView.setText(R.string.jfxxbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/jfxxbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				mTextView.setText(R.string.syrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/syrbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				mTextView.setText(R.string.tbrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbrbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				mTextView.setText(R.string.bdbf);
				try {
					wvShow.loadUrl("file:///android_asset/www/bdbftj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 10:
				mTextView.setText(R.string.jsbe);
				try {
					wvShow.loadUrl("file:///android_asset/www/jsbetj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 11:
				//search function 
				break;
			}
		} else if (title.equals(mTabTitles[3])) {// 产品简介
			switch (itemPosi) {
			case 1:
				mTextView.setText(R.string.yc);
				try {
					wvShow.loadUrl("file:///android_asset/www/yctj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				mTextView.setText(R.string.tb);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				mTextView.setText(R.string.zyjk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjktj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				mTextView.setText(R.string.zyhk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjktj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				mTextView.setText(R.string.scjlq);
				try {
					wvShow.loadUrl("file:///android_asset/www/scjlqtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				mTextView.setText(R.string.jfxxbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/jfxxbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				mTextView.setText(R.string.syrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/syrbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				mTextView.setText(R.string.tbrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbrbgtj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				mTextView.setText(R.string.bdbf);
				try {
					wvShow.loadUrl("file:///android_asset/www/bdbftj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 10:
				mTextView.setText(R.string.jsbe);
				try {
					wvShow.loadUrl("file:///android_asset/www/jsbetj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 11:
				//search function 
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