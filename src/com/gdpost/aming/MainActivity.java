package com.gdpost.aming;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	
	private UpdateManager mUpdateManager;
	
	MyImageView tb_cmd;
	MyImageView yc_cmd;
	MyImageView scjlq_cmd;
	MyImageView zyjk_cmd;
	MyImageView zyhk_cmd;
	MyImageView jfxxbg_cmd;
	MyImageView syrbg_cmd;
	MyImageView tbrbg_cmd;
	MyImageView bdbf_cmd;
	MyImageView jsbe_cmd;
	Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = this.getApplicationContext();
		
		/*
		 * ====================test
		GridView gridview = (GridView) findViewById(R.id.main_gv);
		//生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        SimpleAdapter arrayAdapter = new SimpleAdapter(context, getItems(),// 数据来源
				R.layout.mainitems,// 每一个user xml 相当ListView的一个组件
				new String[] { "ItemImage", "ItemText"},
				// 分别对应view 的id
				new int[] { R.id.ItemImage, R.id.ItemText});
        //添加并且显示
        gridview.setAdapter(arrayAdapter);
        //添加消息处理
        gridview.setOnItemClickListener(new ItemClickListener());
        */
		yc_cmd = (MyImageView) findViewById(R.id.yc_cmd);
		yc_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				// TODO Auto-generated method stub
				//Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				//System.out.println("1");
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(1));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
		tb_cmd = (MyImageView) findViewById(R.id.tb_cmd);
		tb_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {

			@Override
			public void onViewClick(MyImageView view) {
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(2));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		}); 
		
		zyjk_cmd = (MyImageView) findViewById(R.id.zyjk_cmd);
		zyjk_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(3));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
		zyhk_cmd = (MyImageView) findViewById(R.id.zyhk_cmd);
		zyhk_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(4));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
		scjlq_cmd = (MyImageView) findViewById(R.id.scjlq_cmd);
		scjlq_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(5));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
		jfxxbg_cmd = (MyImageView) findViewById(R.id.jfxxbg_cmd);
		jfxxbg_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(6));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
		syrbg_cmd = (MyImageView) findViewById(R.id.syrbg_cmd);
		syrbg_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(7));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
		tbrbg_cmd = (MyImageView) findViewById(R.id.tbrbg_cmd);
		tbrbg_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(8));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
		bdbf_cmd = (MyImageView) findViewById(R.id.bdbf_cmd);
		bdbf_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(9));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
		jsbe_cmd = (MyImageView) findViewById(R.id.jsbe_cmd);
		jsbe_cmd.setOnClickIntent(new MyImageView.OnViewClickListener() {
			@Override
			public void onViewClick(MyImageView view) {
				Intent myIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("itemPosi", String.valueOf(10));
				myIntent.putExtras(bundle);
				myIntent.setClass(context, SubActivity.class);
				startActivity(myIntent);
			}
		});
		
	}
	
	/*
	//当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class  ItemClickListener implements OnItemClickListener
    {
		public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened 
				                          View arg1,//The view within the AdapterView that was clicked
				                          int arg2,//The position of the view in the adapter
				                          long arg3//The row id of the item that was clicked
				                          ) {
			//在本例中arg2=arg3
			HashMap<String, Object> item=(HashMap<String, Object>) arg0.getItemAtPosition(arg2);
			//显示所选Item的ItemText
			setTitle((String)item.get("ItemText"));
		}
    	
    }
    
    public ArrayList<HashMap<String, Object>> getItems() {
		ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String, Object>>();
		for (int i=0; i<ContextDefine.itemsStr.length; i++) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("ItemImage", ContextDefine.itemImgs[i]);
			item.put("ItemText", ContextDefine.itemsStr[i]);
			items.add(item);
		}
		return items;
	}
	*/
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Log.v("-------menu on option item selected-----", String.valueOf(item.getOrder()));
		//UpdateInfo ui = getServerUpdateInfo();
		//Log.v("----url:", ui.getUrl());
		// 这里来检测版本是否需要更新
		int io = item.getOrder();
		if(io == 1) {
			Intent myIntent = new Intent();
			myIntent.setClass(this.getApplicationContext(), AboutActivity.class);
			startActivity(myIntent);
		} else if(io == 2) {
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
		}
		return true;
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
	
	private long exitTime = 0;
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if(keyCode == KeyEvent.KEYCODE_BACK &&     event.getAction() == KeyEvent.ACTION_DOWN){ 
	        if((System.currentTimeMillis()-exitTime) > 2000){ 
	            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
	            exitTime = System.currentTimeMillis(); 
	        } else {
	            finish();
	            System.exit(0);
	        }
	        return true; 
	    }
	    return super.onKeyDown(keyCode, event);
	}
}