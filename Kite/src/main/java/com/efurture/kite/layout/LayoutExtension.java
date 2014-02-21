/**
 * 
 */
package com.efurture.kite.layout;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;

import com.efurture.kite.OnFinishLayoutListener;
import com.efurture.kite.expression.EvaluatorManager;
import com.efurture.kite.param.ParamMap;
import com.efurture.kite.param.Params;

/**
 * @author gubaojian   email: gubaojian@163.com
 *  */
public class LayoutExtension {
	/**
	 *  layout v with json data, when layout finished call listener
	 *  @param  v   target v
	 *  @param data  json format data
	 *  @param finishLayoutListener  listener
	 * */
	public static void layout(final View v, Object data, final OnFinishLayoutListener finishLayoutListener){
		if (data == null) {
			return;
		}
		String json = data.toString().trim();
		if (TextUtils.isEmpty(json)) {
			return;
		}
		
		if(!(json.startsWith("{") && json.endsWith("}"))){
			return;
		}
		try {
			final JSONObject jsonObject = new JSONObject(json);
			v.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
				@Override
				public boolean onPreDraw() {
					 LayoutParams layoutParams = v.getLayoutParams();
				     if (layoutParams == null) {
						 return true;
					 }
					 v.getViewTreeObserver().removeOnPreDrawListener(this);
				     Map<String, Object> paramsMap  = ParamMap.from(v);
				     paramsMap.put(Params.HEIGHT,  v.getHeight());
				     paramsMap.put(Params.WIDTH,   v.getWidth());
					
					 boolean updateLayoutParams = false;
					 String heightExpression = jsonObject.optString(Params.HEIGHT, null);
					 if (!TextUtils.isEmpty(heightExpression)) {
						layoutParams.height = EvaluatorManager.getDefaultEvaluator().eval(heightExpression, paramsMap);
						updateLayoutParams = true;
					 }
					 
					 String widthExpression = jsonObject.optString(Params.WIDTH, null);
					 if (!TextUtils.isEmpty(widthExpression)) {
						 layoutParams.width = EvaluatorManager.getDefaultEvaluator().eval(widthExpression, paramsMap);
					     updateLayoutParams = true;
					}
					if (updateLayoutParams) {
						 v.setLayoutParams(layoutParams);
					}
				    if (finishLayoutListener != null) {
						finishLayoutListener.onFinishLayout(v, jsonObject);
					}
					return false;
				}
			});
		}catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
