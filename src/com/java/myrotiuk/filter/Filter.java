package com.java.myrotiuk.filter;

import com.java.myrotiuk.exception.FailCriteriaException;

/**
 * Interface<code>Filter</code> contains two methods that you have to implements
 * if you want to use Filter
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 07-11-2015
 * @param <T> filtering will be by specific type
 */
public interface Filter<T> {

	/**
	 * Method for checking value if it matches with criteria
	 * @param value is a value of type T that has to be checked
	 * @return true if value matches otherwise false
	 */
	boolean apply(T value);

	/**
	 * Method for setting criteria that value has to match
	 * @param min is a minimum criteria bound 
	 * @param max is a maximum criteria bound
	 * @throws FailCriteriaException if you have input inappropriate criteria bounds
	 */
	void setCriteria(double min, double max) throws FailCriteriaException;

}
