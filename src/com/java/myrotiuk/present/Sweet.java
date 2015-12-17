package com.java.myrotiuk.present;

import java.util.Comparator;

/**
 * Class<code> Sweet</code> for creating an instance of Sweet
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 07-11-2015
 */
public class Sweet {

	private String nameOfSweet;
	private double mass;
	private double sugarMass;
	private SweetType type;

	/**
	 * SORT_BY_TYPE is a constant variable comparator that is sorting Sweets by
	 * type
	 */
	public static final Comparator<Sweet> SORT_BY_TYPE = new SortByType();

	/**
	 * 
	 * Class<code> SortByType</code> for creating an instance of SortByType that
	 * will be used at sorting Sweets by type
	 * 
	 * @version 1.0
	 * @author Ivan Myrotiuk
	 * @since 07-11-2015
	 */
	private static class SortByType implements Comparator<Sweet> {
		public int compare(Sweet type1, Sweet type2) {
			return type1.type.compareTo(type2.type);
		}
	}

	/**
	 * 
	 * Class<code> SweetType</code> for enumeration types of sweets  
	 * 
	 * @version 1.0
	 * @author Ivan Myrotiuk
	 * @since 07-11-2015
	 */
	public enum SweetType {
		CANDY, SWEET_BAR, CHOCOLATE, MILK_CHOCOLATE, CAKE;
	}

	/**
	 * Constructor with specific parameters
	 * 
	 * @param name is a name of sweet
     * @param mass is a mass of current sweet
	 * @param sugarMass is a mass of sugar in current sweet
	 * @param type is a type of current sweet in present
	 */
	public Sweet(String nameOfSweet, double mass, double sugarMass, SweetType type) {
		this.nameOfSweet = nameOfSweet;
		this.mass = mass;
		this.sugarMass = sugarMass;
		this.type = type;
	}

	/**
	 * Method for getting name of sweet
     *
     * @return name of current sweet
	 */
	public String getName() {
		return nameOfSweet;
	}

	/**
	 * Method for setting name of sweet
	 * 
	 * @param name is a specific name of current sweet
	 */
	public void setName(String name) {
		this.nameOfSweet = name;
	}

	/**
	 * Method for getting mass of sweet
     *
     * @return mass of current sweet
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * Method for setting mass of sweet
     *
     * @param mass is a specific mass of current sweet
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}

	/**
	 * Method for getting sugar mass of sweet
	 * 
	 * @return the sugarMass of specific sweet
	 */
	public double getSugarMass() {
		return sugarMass;
	}

	/**
	 * Method for setting sugar mass of sweet
	 * @param sugarMass is a specific sugar mass of current sweet
	 */
	public void setSugarMass(double sugarMass) {
		this.sugarMass = sugarMass;
	}

	/**
	 * Method for getting type of sweet
     * @return current type of sweet
	 */
	public SweetType getType() {
		return type;
	}

	/**
	 * Method for setting type of sweet
	 * 
	 * @param type is a specific type of sweet to set
	 */
	public void setType(SweetType type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sweet [nameOfSweet=" + nameOfSweet + ", mass=" + mass + ", sugarMass=" + sugarMass + ", type=" + type
				+ "]";
	}

}
