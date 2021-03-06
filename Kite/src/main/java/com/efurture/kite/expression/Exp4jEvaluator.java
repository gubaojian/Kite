/**
 * 
 */
package com.efurture.kite.expression;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import de.congrace.exp4j.ExpressionBuilder;

/**
 * exp4j implementation of evaluator. exp4j: http://www.objecthunter.net/exp4j/
 * @author gubaojian   email: gubaojian@163.com
 *  */
public class Exp4jEvaluator extends Evaluator{

	/* (non-Javadoc)
	 * @see com.efurture.kite.expression.ExpressionProvider#evalInt(java.lang.String, java.util.Map)
	 */
	@Override
	public int evalute(String expression, Map<String, Object> paramsMap){
		try {
			ExpressionBuilder builder = new ExpressionBuilder(expression);
			Set<Entry<String, Object>> entries = paramsMap.entrySet();
			for(Entry<String, Object> entry : entries){
				String key = entry.getKey();
				Object value = entry.getValue();
				if (value instanceof Number) {
					Number num = (Number)value;
					builder.withVariable(key, num.doubleValue());
				}
			}
			return (int)builder.build().calculate();
		}
		catch (Exception e) {
			throw new EvaluatorException(e);
		}
	}
}
