package com.gdpost.aming;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		yc_cmd = (MyImageView) findViewById(R.id.yc_cmd);
		yc_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		tb_cmd = (MyImageView) findViewById(R.id.tb_cmd);
		tb_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		zyjk_cmd = (MyImageView) findViewById(R.id.zyjk_cmd);
		zyjk_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		zyhk_cmd = (MyImageView) findViewById(R.id.zyhk_cmd);
		zyhk_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		scjlq_cmd = (MyImageView) findViewById(R.id.scjlq_cmd);
		scjlq_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		jfxxbg_cmd = (MyImageView) findViewById(R.id.jfxxbg_cmd);
		jfxxbg_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		syrbg_cmd = (MyImageView) findViewById(R.id.syrbg_cmd);
		syrbg_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		tbrbg_cmd = (MyImageView) findViewById(R.id.tbrbg_cmd);
		tbrbg_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		bdbf_cmd = (MyImageView) findViewById(R.id.bdbf_cmd);
		bdbf_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
		
		jsbe_cmd = (MyImageView) findViewById(R.id.jsbe_cmd);
		jsbe_cmd.setOnClickIntent(new MyImageView.OnViewClick() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Log.v("-------menu on option item selected-----", item.getTitle().toString());
		//UpdateInfo ui = getServerUpdateInfo();
		//Log.v("----url:", ui.getUrl());
		// 这里来检测版本是否需要更新
		
		return true;
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