package com.java.myrotiuk.present;


/**
 * Class<code> SweetWithCream</code> for creating an instance of SweetWithCream
 * that extends class Sweet
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 07-11-2015
 */
public class SweetWithCream extends Sweet{

	private String nameOfCream;
	
	/**
	 * Constructor with specific parameters
	 * @param nameOfSweet is a name of sweet
	 * @param nameOfCream is a name of cream
	 * @param mass is a mass of current sweet
	 * @param sugarMass is a mass of sugar in current sweet
	 * @param type is a type of current sweet in present
	 */
	public SweetWithCream(String nameOfSweet, String nameOfCream, double mass,
			double sugarMass, SweetType type){
		
		super(nameOfSweet, mass, sugarMass, type);
		this.nameOfCream = nameOfCream;
	}
	/**
	 * Method for getting name of cream that is used in sweet
	 * 
	 * @return the name of cream in sweet  
	 */
	public String getNameOfCream() {
		return nameOfCream;
	}
	/**
	 * Method for setting name of cream
	 * 
	 * @param nameOfCream is a specific name of cream to set
	 */
	public void setNameOfCream(String nameOfCream) {
		this.nameOfCream = nameOfCream;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return   super.toString() + " [nameOfCream=" + nameOfCream;
	}

}
