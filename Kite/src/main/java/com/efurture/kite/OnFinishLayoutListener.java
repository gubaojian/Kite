/**
 * 
 */
package com.efurture.kite;

import org.json.JSONObject;

import android.view.View;

/**
 * Kite finish layout on target view listener
 * @author gubaojian   email: gubaojian@163.com
 **/
public interface OnFinishLayoutListener {
	
	/**
	 * called after Kite finish layout on target view.
	 * @param v   target view
	 * @param data  json object parsed from android:tag or android:contentDescription attribute
	 * */
	public void onFinishLayout(View v, JSONObject data);
	
}
