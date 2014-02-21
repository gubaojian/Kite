package com.efurture.kite.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.efurture.kite.Kite;

public class KiteItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kite_item);
		Kite.layout(findViewById(R.id.image_container));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.kite_item, menu);
		return true;
	}

}
