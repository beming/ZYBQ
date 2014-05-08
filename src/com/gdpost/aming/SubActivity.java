package com.gdpost.aming;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.viewpagerindicator.TabPageIndicator;

public class SubActivity extends FragmentActivity {
	/**
	 * Tab标题
	 */
	private String[] mTabTitles;
	ArrayList<View> pagesArrayList;// 添加listview 然后传给MyPagerAdapter 充当媒介
	ListView listView;
	private String productPosi;
	private UpdateManager mUpdateManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// display
		setContentView(R.layout.subactivity_main);

		Bundle bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        productPosi = bundle.getString("productPosi");
            
		//Log.v("------get the click posi:", productPosi);

		// 从资源文件在获取Tab的title
		mTabTitles = getResources().getStringArray(R.array.about_title);
		// ViewPager的adapter
		final FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
		ViewPager pager = (ViewPager) findViewById(R.id.aboutpager);
		pager.setAdapter(adapter);

		// 实例化TabPageIndicator然后设置ViewPager与之关联
		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.aboutindicator);

		indicator.setViewPager(pager);

		// 如果我们要对ViewPager设置监听，用indicator设置就行了
		indicator.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				//Toast.makeText(getApplicationContext(), mTabTitles[arg0], Toast.LENGTH_SHORT).show();
				//FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();  
				//transaction.replace(R.id.aboutpager,adapter.getItem(arg0));  
				//transaction.addToBackStack(null);  
				//transaction.commit(); 
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}
			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	/**
	 * ViewPager适配器
	 * 
	 * @author len
	 * 
	 */
	class TabPageIndicatorAdapter extends FragmentPagerAdapter {
		public TabPageIndicatorAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// 新建一个Fragment来展示ViewPager item的内容，并传递参数
			Fragment fragment = new SubFragment();
			Bundle args = new Bundle();
			args.putString("arg", mTabTitles[position]);
			args.putString("productPosi", productPosi);
			fragment.setArguments(args);
			
			return fragment;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mTabTitles[position % mTabTitles.length];
		}

		@Override
		public int getCount() {
			return mTabTitles.length;
		}
	}
	/*
	 * 获取当前程序的版本号
	 */
	private String getVersionName() throws Exception {
		// 获取packagemanager的实例
		PackageManager packageManager = getPackageManager();
		// getPackageName()是你当前类的包名，0代表是获取版本信息
		PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
		return packInfo.versionName;
	}

	public class GetResource {
		public byte[] readResource(InputStream inputStream) throws Exception {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] array = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(array)) != -1) {
				outputStream.write(array, 0, len);
			}
			inputStream.close();
			outputStream.close();
			return outputStream.toByteArray();
		}
	}

	public UpdateInfo getServerUpdateInfo() {
		String path = getResources().getString(R.string.updateServer);
		UpdateInfo udi = new UpdateInfo();
		try {
			URL url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(2000);
			httpURLConnection.setRequestMethod("GET");
			InputStream inputStream = httpURLConnection.getInputStream();
			if (httpURLConnection.getResponseCode() == 200) {
				byte[] b = new GetResource().readResource(inputStream);// readResource(InputStrea
				String str = new String(b,"utf-8");
				Log.v("----", str);
				//str = new String(Base64.decode(b, Base64.DEFAULT));
				//Log.v("----", str);
				JSONArray jsonArray = new JSONArray(str);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					udi.setVersion(jsonObject.getString("Ver"));
					udi.setUrl(jsonObject.getString("Url"));
					udi.setDescription(jsonObject.getString("Desc"));
				}
			}
		} catch (Exception e) {
			try {
				udi.setVersion(getVersionName());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return udi;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	/** 
     * 检测网络是否连接 
     *  
     * @return 
     */  
    private boolean isNetConnected() {  
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);  
        if (cm != null) {  
            NetworkInfo[] infos = cm.getAllNetworkInfo();  
            if (infos != null) {  
                for (NetworkInfo ni : infos) {  
                    if (ni.isConnected()) {  
                        return true;  
                    }  
                }  
            }  
        }  
        return false;  
    }  
  
    /** 
     * 检测wifi是否连接 
     *  
     * @return 
     */  
    private boolean isWifiConnected() {  
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);  
        if (cm != null) {  
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();  
            if (networkInfo != null  
                    && networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {  
                return true;  
            }  
        }  
        return false;  
    }  
  
    /** 
     * 检测3G是否连接 
     *  
     * @return 
     */  
    private boolean is3gConnected() {  
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);  
        if (cm != null) {  
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();  
            if (networkInfo != null  
                    && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {  
                return true;  
            }  
        }  
        return false;  
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Log.v("-------menu on option item selected-----", item.getTitle().toString());
		//UpdateInfo ui = getServerUpdateInfo();
		//Log.v("----url:", ui.getUrl());
		// 这里来检测版本是否需要更新
		if(!this.isWifiConnected() && !this.is3gConnected() && !this.isNetConnected()) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setIcon(R.drawable.ic_launcher);
			builder.setTitle("网络提示信息");
			builder.setMessage("网络不可用，如果继续，请先设置网络！");
			builder.setPositiveButton("确定", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			builder.create();
			builder.show();
		} else {
			mUpdateManager = new UpdateManager(this);
			try {
				mUpdateManager.checkUpdateInfo(true, getServerUpdateInfo(), getVersionName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
