package com.java.myrotiuk.present;

import java.util.LinkedList;
import java.util.List;

import com.java.myrotiuk.present.Sweet.SweetType;

/**
 * Class<code> Present</code> for creating an instance of Present
 * that contains different sweets
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 07-11-2015
 */

public class Present {

	private String nameOfPresent;
	private List<Sweet> sweets = new LinkedList<>();
	private double totalMassOfPresent;
	private double totalMassOfSugar;
	private boolean presentWasChanged = true;
	
	/**
	 * Constructor with specific parameters
	 * @param nameOfPresent is a name of present
	 * @param sweets are list of specific sweets
	 */
	public Present(String nameOfPresent, List<? extends Sweet> sweets){
		this.nameOfPresent = nameOfPresent;
		this.sweets.addAll(sweets);//can be class cast if we pass List<SweetWithCream> as it is not List<Sweet>
	}
	
	/**
	 * Constructor with specific parameters 
	 * where you can create present with your own sweets
	 * @param nameOfPresent is a name of present
	 */
	public Present(String nameOfPresent){
		this.nameOfPresent = nameOfPresent;
		this.sweets = new LinkedList<>();
	}
	
	/**
	 * Method for adding sweet
	 * after adding sweet mass of present and sugar mass will grow
	 * @param sweet is a specific sweet to add
	 */
	public void addSweet(Sweet sweet){
		sweets.add(sweet);
		totalMassOfPresent += sweet.getMass();
		totalMassOfSugar += sweet.getSugarMass();
		//countTotalMassAndSugarOfPresent();
		//presentWasChanged = true;
	}
	
	/**
	 * Method for adding list of sweets
	 * after adding sweet mass of present and sugar mass will grow
	 * @param newSweets are a specific sweets to add
	 */
	public void addSweets(List<? extends Sweet> newSweets){
		this.sweets.addAll(newSweets);
		for(Sweet sweet : newSweets){
			totalMassOfPresent += sweet.getMass();
			totalMassOfSugar += sweet.getSugarMass();
		}
	}
	
	/**
	 * Method for getting list of sweets
	 * @return list of sweets in present
	 */
	public List<Sweet> getSweets(){
		return this.sweets;
	}
	
	private boolean isChangedPresent(){
		return presentWasChanged;
	}
	
	/**
	 * Method for getting mass of present if this method will be called 
	 * at first mass will be count and then returned
	 * @return mass of present
	 */
	public double getTotalMassOfPresent(){
		if(isChangedPresent()){
			countTotalMassAndSugarOfPresent();
		}
		return totalMassOfPresent;
	}
	
	/**
	 * Method for getting sugar mass of present if this method will be called 
	 * at first sugar mass will be count and then returned
	 * @return sugar mass of present
	 */
	public double getTotalMassOfSugar(){
		if(isChangedPresent()){
			countTotalMassAndSugarOfPresent();
		}
		return totalMassOfSugar;
	}
	
	/**
	 * Method for counting mass of present and sugar mass of all sweets
	 */
	public void countTotalMassAndSugarOfPresent(){
		for(Sweet sweet : sweets){
			totalMassOfPresent += sweet.getMass();
			totalMassOfSugar += sweet.getSugarMass();
		}
		presentWasChanged = false;
	}

	/**
	 * Method for getting name of present
	 * @return the name of present
	 */
	public String getNameOfPresent() {
		return nameOfPresent;
	}

	/**
	 * Method for setting name of present 
	 * @param nameOfPresent is a specific name of present
	 */
	public void setNameOfPresent(String nameOfPresent) {
		this.nameOfPresent = nameOfPresent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Present [nameOfPresent=" + nameOfPresent + ", totalMassOfPresent=" + totalMassOfPresent
				+ ", totalMassOfSugar=" + totalMassOfSugar + "]";
	}
}
