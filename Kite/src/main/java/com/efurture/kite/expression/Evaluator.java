/**
 * 
 */
package com.efurture.kite.expression;

import java.util.Map;

import com.efurture.kite.param.Params;

/**
 * 
 * Math expression evaluator, if you want to make customer math evaluator. 
 * just make a subclass of Evaluator.
 * 
 * @author gubaojian   email: gubaojian@163.com
 *  */
public abstract class Evaluator {

	/**
	 * evaluate match expression, and return value
	 * @param expression expression to evaluate
	 * @param paramsMap  variable for evaluate expression
	 * */
	public final int eval(String expression, Map<String, Object> paramsMap) throws EvaluatorException{
		String standardExpression = standard(expression);
		return evalute(standardExpression, paramsMap);
	}

	
	/**
	 * subclass implements to evaluate standard expression
	 * @param expression  standard expression, which is lowercase, dp is replace by *density
	 * @param paramsMap   variable for evaluate expression
	 * */
	protected  abstract int  evalute(String expression, Map<String, Object> paramsMap) throws EvaluatorException;
	

	/**
	 * standard expression,
	 * 1, make expression lowercase
	 * 2, replace dp with   *density.  40dp to 40*density;
	 * */
	private String standard(String expression){
		String standard = expression.toLowerCase();
		standard = standard.replaceAll("dp",  "*" + Params.DENSITY);
		return standard;
	}
		

}
