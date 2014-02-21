/**
 * 
 */
package com.efurture.kite;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.efurture.kite.expression.Evaluator;
import com.efurture.kite.expression.EvaluatorManager;
import com.efurture.kite.layout.LayoutExtension;

/**
 * give you powerful layout extension via android:tag or android:contentDescription attribute.
 * <br/>
 * <br/>
 * Demo Usage:
 * <br/>
 * <br/>
 * {@code
 *  <View
 *  android:id="@+id/textview"
 *  android:contentDescription='{"height":"width*0.333 + 2*66 + 0.5*screen_width"}'/>
 *  }
 * <br/>
 * <br/>
 * {@code
 *  <View
 *  android:id="@+id/view"
 *  android:tag='{"height":"width*0.333 + 2*66 + 0.5*screen_width"}'/>
 * }
 * <br/>
 * <br/>
 * make layout effect via Kite:
 * <br/>
 * <br/>
 * {@code
 *   Kite.layout(findViewById(R.id.view)); 
 * }
 * 
 * @author gubaojian   email: gubaojian@163.com
 *  */
public class Kite {
    
	/**
	 *  layout view and view's subview
	 *  @param view                    target view
	 * */
	public static void layout(View view){
		layout(view, true);
	} 
	
	/**
	 * layout view and view's subview, when layout complete, call OnFinishLayoutListener
	 * @param view                    target view
	 * @param finishLayoutListener    layout complete listener
	 * */
	public static void layout(View view, OnFinishLayoutListener finishLayoutListener){
		 layout(view, finishLayoutListener, true);  
	}

	/**
	 * layout view
	 * @param view                 target view
	 * @param tranverse            whether tranverse view's subview and layout them
	 * */
	public static void layout(View view, boolean tranverse){
		layout(view, null, tranverse);
	}

	/**
	 * layout view
	 * @param view                 target view
	 * @param layoutFinishListener layout complete listener, called when layout complete
	 * @param tranverse            whether tranverse view's subview and layout them
	 * */
    public static void layout(View view, OnFinishLayoutListener layoutFinishListener, boolean tranverse){
    	    if (view.getTag() != null) {
			LayoutExtension.layout(view, view.getTag(), layoutFinishListener);
		}
		if (!TextUtils.isEmpty(view.getContentDescription())) {
			LayoutExtension.layout(view, view.getContentDescription(), layoutFinishListener);
		}
		if (tranverse) {
			if (view instanceof ViewGroup) {
				 ViewGroup root = (ViewGroup) view;
				 int count = root.getChildCount();
				 for(int i=0; i<count; i++){
					 layout(root.getChildAt(i), layoutFinishListener, tranverse); 
				 }
			}
		}
	}
    
    /**
     * customer default math expression Evaluator.
     * @param defaultEvaluator  default math expression evaluator
	 * */
    public static void setDefaultEvaluator(Evaluator defaultEvaluator){
    	    EvaluatorManager.setDefaultEvaluator(defaultEvaluator);
    }
}
