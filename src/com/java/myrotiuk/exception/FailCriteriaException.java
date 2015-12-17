package com.java.myrotiuk.exception;

/**
 * Class<code> FailCriteriaException</code> that create Exception if 
 * bounds of filtering inappropriate
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 07-11-2015
 */
public class FailCriteriaException  extends Exception{

    /**
     * Default constructor with message that you have input inappropriate criteria
     */
	public FailCriteriaException(){
		super("You have input inappropriate criteria");
	}
	
	/**
	 * Constructor with specific message
	 * @param message is a specific message that you want to pass
	 */
	public FailCriteriaException(String message){
		super(message);
	}
	
}
