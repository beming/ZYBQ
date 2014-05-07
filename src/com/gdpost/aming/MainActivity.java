package com.gdpost.aming;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	MyImageView joke;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		joke = (MyImageView) findViewById(R.id.c_joke);
		joke.setOnClickIntent(new MyImageView.OnViewClick() {

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "事件触发", 1000).show();
				System.out.println("1");
			}
		});
	}
}