package com.gdpost.aming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TableRow;
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
		//wvShow.getSettings().setJavaScriptEnabled(true);
		wvShow.getSettings().setSupportZoom(true);
		wvShow.getSettings().setBuiltInZoomControls(true);
		
		if (title.equals(mTabTitles[0])) {// 条件
			/*
			 * =======================================
			 * 下面部分为保全条件
			 * =======================================
			 */
			switch (itemPosi) {
			case 1:
				contextView = inflater.inflate(R.layout.wvshow, container, false);
				TextView featureName = (TextView) contextView.findViewById(R.id.theItemName);
				featureName.setText(R.string.yc);
				TextView tv1 = (TextView) contextView.findViewById(R.id.tv1);
				tv1.setText(R.string.yctj1);
				TextView tv6 = (TextView) contextView.findViewById(R.id.tv6);
				tv6.setText(R.string.yctj2);
				/*mTextView.setText(R.string.yc);
				try {
					wvShow.loadUrl("file:///android_asset/www/yctj.html");
				} catch (Exception e) {
					e.printStackTrace();
				}*/
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
			
		} else if (title.equals(mTabTitles[1])) {// 资料
			/*
			 * =======================================
			 * 下面部分为提交的资料
			 * =======================================
			 */
			switch (itemPosi) {
			case 1:
				contextView = inflater.inflate(R.layout.wvshow, container, false);
				TextView featureName = (TextView) contextView.findViewById(R.id.theItemName);
				featureName.setText(R.string.yc);
				TextView tv = (TextView) contextView.findViewById(R.id.tv1);
				tv.setText(R.string.yczl1);
				tv.setTextColor(Color.BLACK);
				TableRow tr2 = (TableRow) contextView.findViewById(R.id.tr2);
				tr2.setVisibility(View.VISIBLE);
				TextView tv2 = (TextView) contextView.findViewById(R.id.tv2);
				tv2.setText(R.string.yczl2);
				TableRow tr3 = (TableRow) contextView.findViewById(R.id.tr3);
				tr3.setVisibility(View.VISIBLE);
				TextView tv3 = (TextView) contextView.findViewById(R.id.tv3);
				tv3.setText(R.string.yczl3);
				TableRow tr4 = (TableRow) contextView.findViewById(R.id.tr4);
				tr4.setVisibility(View.VISIBLE);
				TextView tv4 = (TextView) contextView.findViewById(R.id.tv4);
				tv4.setText(R.string.yczl4);
				TableRow tr5 = (TableRow) contextView.findViewById(R.id.tr5);
				tr5.setVisibility(View.VISIBLE);
				TextView tv5 = (TextView) contextView.findViewById(R.id.tv5);
				tv5.setText(R.string.yczl5);
				TextView tv6 = (TextView) contextView.findViewById(R.id.tv6);
				tv6.setText(R.string.yczl6);
				tv6.setTextColor(Color.RED);
				/*
				mTextView.setText(R.string.yc);
				try {
					wvShow.loadUrl("file:///android_asset/www/yczl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				break;
			case 2:
				mTextView.setText(R.string.tb);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbzl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				mTextView.setText(R.string.zyjk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjkzl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				mTextView.setText(R.string.zyhk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjkzl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				mTextView.setText(R.string.scjlq);
				try {
					wvShow.loadUrl("file:///android_asset/www/scjlqzl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				mTextView.setText(R.string.jfxxbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/jfxxbgzl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				mTextView.setText(R.string.syrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/syrbgzl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				mTextView.setText(R.string.tbrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbrbgzl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				mTextView.setText(R.string.bdbf);
				try {
					wvShow.loadUrl("file:///android_asset/www/bdbfzl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 10:
				mTextView.setText(R.string.jsbe);
				try {
					wvShow.loadUrl("file:///android_asset/www/jsbezl.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 11:
				//search function 
				break;
			}
			
		} else if (title.equals(mTabTitles[2])) {// 规则
			/*
			 * =======================================
			 * 下面部分为规则
			 * =======================================
			 */
			switch (itemPosi) {
			case 1:
				contextView = inflater.inflate(R.layout.wvshow, container, false);
				TextView featureName = (TextView) contextView.findViewById(R.id.theItemName);
				featureName.setText(R.string.yc);
				TextView tv = (TextView) contextView.findViewById(R.id.tv1);
				tv.setText(R.string.ycgz1);
				TableRow tr2 = (TableRow) contextView.findViewById(R.id.tr2);
				tr2.setVisibility(View.VISIBLE);
				TextView tv2 = (TextView) contextView.findViewById(R.id.tv2);
				//最后字体变色
				String str = getResources().getString(R.string.ycgz2);
				Log.v("---SubFragment---gz", str);
				SpannableStringBuilder mSpannableStringBuilder=new SpannableStringBuilder(str);   
		        mSpannableStringBuilder.setSpan  
		        (new ForegroundColorSpan(Color.RED), 24, 33, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);       
				tv2.setText(R.string.ycgz2);
				tv2.setText(mSpannableStringBuilder);
				TableRow tr3 = (TableRow) contextView.findViewById(R.id.tr3);
				tr3.setVisibility(View.VISIBLE);
				TextView tv3 = (TextView) contextView.findViewById(R.id.tv3);
				tv3.setText(R.string.ycgz3);
				tv3.setTextColor(Color.RED);
				TextView tv6 = (TextView) contextView.findViewById(R.id.tv6);
				tv6.setText(R.string.ycgz4);
				
		        /*
				mTextView.setText(R.string.yc);
				try {
					wvShow.loadUrl("file:///android_asset/www/ycgz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/
				break;
			case 2:
				mTextView.setText(R.string.tb);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbgz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				mTextView.setText(R.string.zyjk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjkgz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				mTextView.setText(R.string.zyhk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjkgz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				mTextView.setText(R.string.scjlq);
				try {
					wvShow.loadUrl("file:///android_asset/www/scjlqgz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				mTextView.setText(R.string.jfxxbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/jfxxbggz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				mTextView.setText(R.string.syrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/syrbggz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				mTextView.setText(R.string.tbrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbrbggz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				mTextView.setText(R.string.bdbf);
				try {
					wvShow.loadUrl("file:///android_asset/www/bdbfgz.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 10:
				mTextView.setText(R.string.jsbe);
				try {
					wvShow.loadUrl("file:///android_asset/www/jsbegz.html");
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
					wvShow.loadUrl("file:///android_asset/www/ycmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				mTextView.setText(R.string.tb);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				mTextView.setText(R.string.zyjk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjkmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				mTextView.setText(R.string.zyhk);
				try {
					wvShow.loadUrl("file:///android_asset/www/zyjkmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				mTextView.setText(R.string.scjlq);
				try {
					wvShow.loadUrl("file:///android_asset/www/scjlqmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				mTextView.setText(R.string.jfxxbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/jfxxbgmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 7:
				mTextView.setText(R.string.syrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/syrbgmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				mTextView.setText(R.string.tbrbg);
				try {
					wvShow.loadUrl("file:///android_asset/www/tbrbgmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				mTextView.setText(R.string.bdbf);
				try {
					wvShow.loadUrl("file:///android_asset/www/bdbfmb.html");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 10:
				mTextView.setText(R.string.jsbe);
				try {
					wvShow.loadUrl("file:///android_asset/www/jsbemb.html");
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