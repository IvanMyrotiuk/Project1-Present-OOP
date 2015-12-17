package com.java.myrotiuk.filter;

import com.java.myrotiuk.exception.FailCriteriaException;
import com.java.myrotiuk.present.Sweet;

/**
 * Class<code>MyFilter</code> implements interface Filter
 * for filtering Sweets
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 07-11-2015
 */
public class MyFilter implements Filter<Sweet>{

	private double criteriaUpperBound;
	private double criteriaLowerBound;
	
	/**
	 * Method for checking value if it matches with criteria
	 * @param sweet is a value that has to be checked
	 * @return true if value matches otherwise false
	 */
	public boolean apply(Sweet sweet){
		return (sweet.getSugarMass() > criteriaLowerBound 
				&& sweet.getSugarMass() < criteriaUpperBound);
	}
	
	
	/**
	 * Method for setting criteria that value has to match
	 * @param min is a minimum criteria bound 
	 * @param max is a maximum criteria bound
	 * @throws FailCriteriaException if you have input inappropriate criteria bounds
	 */
	public void setCriteria(double min, double max)
			throws FailCriteriaException{
		
		checkRange(min, max);
		
		this.criteriaLowerBound = min;
		this.criteriaUpperBound = max;
		
	}
	
	private void checkRange(double min, 
			double max) throws FailCriteriaException{
		
		if(min < 0 || max < 0 
				|| max < min){
			
			throw new FailCriteriaException();
		}
			
	}
	
}
