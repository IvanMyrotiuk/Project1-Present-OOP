package com.java.myrotiuk.present;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.java.myrotiuk.filter.Filter;

/**
 * Class<code> Presenter</code> for creating an instance of Presenter
 * that will create a present, count mass of present and sugar mass of all sweets,
 * sort sweets by name, by mass and by type of sweets and also filter sweets by mass
 *
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 07-11-2015
 */
public class Presenter {

	private String nameOfPresenter;
	private List<Present> presents = new LinkedList<>();

	/**
	 * Constructor with a specific parameters 
	 * @param name is a name of person that create a present
	 */
	public Presenter(String name) {
		this.nameOfPresenter = name;
	}

	/**
	 * Method for creating present of specific sweets
	 * @param nameOfPresent is a specific name of present
	 * @param sweets is a list of sweets that will be in present
	 * @return present 
	 */
	public Present makePresent(String nameOfPresent, List<? extends Sweet> sweets) {
		Present present = new Present(nameOfPresent, sweets);
		present.countTotalMassAndSugarOfPresent();
		presents.add(present);
		return present;
	}

	/**
	 * Method for adding sweet to the last present
	 * @param sweet is a specific sweet to add
	 */
	public void addSweetToTheLastPresent(Sweet sweet) {
		int lastPresent = presents.size() - 1;
		this.presents.get(lastPresent).addSweet(sweet);
	}

	/**
	 * Method for adding sweets to the last present
	 * @param sweets is a specific sweets to add
	 */
	public void addSweetsToTheLastPresent(List<? extends Sweet> sweets) {
		this.presents.get(presents.size() - 1).addSweets(sweets);
	}

	/**
	 * Method for getting presents that made person
	 * @return list of presents
	 */
	public List<Present> getPresents() {
		return this.presents;
	}

	/**
	 * Method for removing present from list of person so after that presenter will
	 * not sort, filter sweets therefore present will be just possessed by person 
	 * for whom that present was done
	 */
	public void removePresentFromList() {
		int lastPresent = presents.size() - 1;
		presents.remove(lastPresent);
	}

	/**
	 * Method for sorting sweets by mass
	 */
	public void sortByMassOfSweet() {
//		Comparator<Sweet> comp = (sweet1, sweet2) -> {
//			double mass = sweet1.getMass() - sweet2.getMass();
//			if (mass < 0) {
//				return -1;
//			} else if (mass > 0) {
//				return 1;
//			}
//			return 0;
//		};// (int)Math.signum()
		Collections.sort(getSweetsFromLastPresent(), new Comparator<Sweet>(){
			public int compare(Sweet sweet1, Sweet sweet2){
				double mass = sweet1.getMass() - sweet2.getMass();
				if (mass < 0) {
					return -1;
				} else if (mass > 0) {
					return 1;
				}
				return 0;
			}
		});
	}

	/**
	 * Method for sorting sweets by name
	 */
	public void sortByName() {
		Collections.sort(getSweetsFromLastPresent(), new Comparator<Sweet>() {
			public int compare(Sweet sweet1, Sweet sweet2) {
				return sweet1.getName().compareTo(sweet2.getName());
			}
		});
	}

	/**
	 * Method for getting list of sweets from present
	 * @return list of sweets
	 */
	public List<Sweet> getSweetsFromLastPresent() {
		int lastPresent = presents.size() - 1;
		return presents.get(lastPresent).getSweets();
	}

	/**
	 * Method for sorting sweets by type
	 */
	public void sortByType() {
		Collections.sort(getSweetsFromLastPresent(), Sweet.SORT_BY_TYPE);
	}
	
	/**
	 * Method for getting filtered sweets by mass that is set to the filter
	 * @param filter is a specific filter with specific range of criteria
	 * @return list of sweets that match to criteria
	 */
	public List<Sweet> getFilteredSweets(Filter<Sweet> filter){
		List<Sweet> filteredSweets = new LinkedList<>();
		//getSweetsFromLastPresent().stream().filter(sweet->sweet.getSugarMass()>0.02 && sweet.getSugarMass() < 0.07).forEach(sweet->filteredSweets.add(sweet));
		for(Sweet sweet : getSweetsFromLastPresent()){
			if(filter.apply(sweet)){
				filteredSweets.add(sweet);
			}
		}
		return filteredSweets;
	}

	/**
	 * Method for getting name of presenter
	 * @return the name of person who made present
	 */
	public String getNameOfPresenter() {
		return nameOfPresenter;
	}

	/**
	 * Method for setting name of presenter
	 * 
	 * @param name is a name of presenter to set
	 */
	public void setNameOfPresenter(String nameOfPresenter) {
		this.nameOfPresenter = nameOfPresenter;
	}

}
