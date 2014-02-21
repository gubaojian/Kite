/**
 * 
 */
package com.efurture.kite.expression;

import java.util.Map;

import org.mvel2.MVEL;

/**
 * mvel2 implementation of evaluator. mvel2: http://mvel.codehaus.org/
 * @author gubaojian   email: gubaojian@163.com
 *  */
public class MVEL2Evaluator  extends Evaluator{
	
	//mvel2 require java 1.5
	static{
		String javaVersion = System.getProperty("java.version");
		try {
			if (javaVersion == null || Float.parseFloat(javaVersion.substring(0,3)) < 1.6) {
				System.setProperty("java.version", "1.6");
			}
		}catch (Exception e) {
			System.setProperty("java.version", "1.6");
		}
	}
	
	
	@Override
	public int evalute(String expression, Map<String, Object> paramsMap){
		Number value =  MVEL.eval(expression, paramsMap, Number.class);
		return value.intValue();
	}
}
