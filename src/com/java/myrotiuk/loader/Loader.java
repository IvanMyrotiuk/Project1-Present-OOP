package com.java.myrotiuk.loader;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.java.myrotiuk.exception.FailCriteriaException;
import com.java.myrotiuk.filter.Filter;
import com.java.myrotiuk.filter.MyFilter;
import com.java.myrotiuk.present.Present;
import com.java.myrotiuk.present.Presenter;
import com.java.myrotiuk.present.Sweet;
import com.java.myrotiuk.present.SweetWithCream;

/**
 * Class<code> Loader</code> for loading our program of making Present
 * this class contains one static method for loading logic and this class
 * actually is utility class we can not extend it  
 * 
 * @version 1.0
 * @author Ivan Myrotiuk
 * @since 07-11-2015
 */
public class Loader {

	private Loader(){
		
	}

    /**
     * Method that load our logic of making Present
     */
	public static void load(){
		
		List<Sweet> sweets = new LinkedList<>();
		sweets.add(new Sweet("Korivka", 0.020, 0.010, Sweet.SweetType.CANDY));
		sweets.add(new SweetWithCream("Kievskiy","LaCream", 1.0, 0.7, Sweet.SweetType.CAKE));
		sweets.add(new Sweet("MilkChocolate", 0.100, 0.035, Sweet.SweetType.MILK_CHOCOLATE));
		sweets.add(new Sweet("Snikers", 0.057, 0.037, Sweet.SweetType.SWEET_BAR));
		sweets.add(new Sweet("DoveChocolade", 0.100, 0.050, Sweet.SweetType.CHOCOLATE));
		sweets.add(new SweetWithCream("CandyCreama","LoliCream", 0.023, 0.02, Sweet.SweetType.CANDY));
		sweets.add(new Sweet("Twix ", 0.070, 0.047, Sweet.SweetType.SWEET_BAR));
		//sweets.add();
		
		Presenter presenter = new Presenter("Huan");
		Present present = presenter.makePresent("NewYearPresent", sweets);
		
		for(Sweet sweet : present.getSweets()){
			System.out.println(sweet);
		}
		presenter.addSweetToTheLastPresent(new Sweet("Lolipop ", 0.077, 0.054, Sweet.SweetType.CANDY));
		System.out.println("--- After Adding ---");
		for(Sweet sweet : present.getSweets()){
			System.out.println(sweet);
		}
		
		presenter.sortByMassOfSweet();//.sortByType();//.sortByMassOfSweet();//.sortByName();
		
		System.out.println("--- After Sorting ---");
		for(Sweet sweet : present.getSweets()){
			System.out.println(sweet);
		}
	
		System.out.println("Filtering sweets by criteria");
		Filter<Sweet> filter = new MyFilter();

		double minCriteria = 0.02;
		double maxCriteria = 0.07;
		boolean bounds = false;
		//Scanner in = new Scanner(System.in);
		
		do{
//			minCriteria = in.nextDouble();
//			maxCriteria =in.nextDouble();
			try {
				filter.setCriteria(minCriteria, maxCriteria);
				bounds = true;
			} catch (FailCriteriaException e) {
				System.err.println("You have input inappropriate bounds criteria");
				e.printStackTrace();
			}
		}while(!bounds);
		
		List<Sweet> filteredSweets = presenter.getFilteredSweets(filter);
		for(Sweet sweet: filteredSweets){
			System.out.println(sweet);
		}
	}
}
