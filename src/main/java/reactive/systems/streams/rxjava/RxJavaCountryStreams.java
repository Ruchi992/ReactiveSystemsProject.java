/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactive.systems.streams.rxjava;

import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import java.util.ArrayList;
import java.util.List;
import reactive.systems.streams.Country;

/**
 *
 * @author James
 */
public class RxJavaCountryStreams {

	public static void main(String[] args) {
		//populate eurozone
		System.out.println("...........................");
		System.out.println("Creating eurozone with 17 countries");

		List<Country> countries = new ArrayList<>();

		//country name, capital, area in thousands Km^2, population in millions
		countries.add(new Country("Austria", "Vienna", 83, 8.3, true));
		countries.add(new Country("Belgium", "Brussels", 30, 10, true));
		countries.add(new Country("Cyprus", "Nicosia", 9, 0.8, true));
		countries.add(new Country("Estonia", "Tallinn", 45, 1.3, true));
		countries.add(new Country("Finland", "Helsinki", 338, 5.3, true));
		countries.add(new Country("France", "Paris", 550, 64, true));
		countries.add(new Country("Germany", "Berlin", 356, 82, true));
		countries.add(new Country("Greece", "Athens", 131, 11, true));
		countries.add(new Country("Ireland", "Dublin", 70, 4.5, true));
		countries.add(new Country("Italy", "Rome", 301, 60, true));
		countries.add(new Country("Luxembourg", "Luxembourg", 2, 0.5, true));
		countries.add(new Country("Netherlands", "Amsterdam", 41, 16, true));
		countries.add(new Country("Portugal", "Lisbon", 92, 10.6, true));
		countries.add(new Country("Slovakia", "Bratislava", 48, 5.4, true));
		countries.add(new Country("Slovenia", "Ljubljiana", 20, 2, true));
		countries.add(new Country("Spain", "Madrid", 504, 45, true));

		System.out.println("Creating non-eurozone countries");

		countries.add(new Country("South Korea", "Seoul", 97, 51, false));
		countries.add(new Country("Namibia", "Windhoek", 823, 2.49, false));
		countries.add(new Country("Mexico", "Mexico", 127, 1943, false));
		countries.add(new Country("Australia", "Canberra", 7682, 25.2, false));
		countries.add(new Country("Argentina", "Beunos Aires", 2736, 45, false));
		countries.add(new Country("Pakistan", "Islamabad", 770, 216, false));

		//************************************************************************
		//************************************************************************
		//Using the streams functions build perform the following tasks:
		//************************************************************************
		//************************************************************************
		//************************************************************************
		//Create a cold observable that emits the list of country objects above 
		//************************************************************************
		System.out.println("	Create a cold observable that emits the list of country objects above ");
		var observableCountries = Observable.fromIterable(countries);
		observableCountries.subscribe(country -> System.out.println(country));
		//************************************************************************
		//Create an observable chain where the end Observer receives coutries objects 
		//that are in the EU and whose capitals begin with L
		//************************************************************************
		System.out.println("Create an observable chain where the end Observer receives coutries objects \n"
				+ "that are in the EU and whose capitals begin with L");
		var observableEuCountriesWithCapitalCitiesBeginingWithL = Observable.fromIterable(countries);
		observableEuCountriesWithCapitalCitiesBeginingWithL
				.filter(country -> country.isEuMember() && country.getCapitalCity().startsWith("L"))
				.subscribe(country -> System.out.println(country));

		//************************************************************************
		//Create an observable chain where the end Observer receives the names of 
		//coutries are in the EU and whose capitals begin with L
		//************************************************************************
		System.out.println("Create an observable chain where the end Observer receives the names of \n"
				+ "		//coutries are in the EU and whose capitals begin with L");
		var observableEuCountryNamesWithCapitalCitiesBeginingWithL = Observable.fromIterable(countries);
		observableEuCountryNamesWithCapitalCitiesBeginingWithL
				.filter(country -> country.isEuMember() && country.getCapitalCity().startsWith("L"))
				.map(Country::getName)
				.subscribe(countryName -> System.out.println(countryName));

		//Create an observable chain where the end Observer receives a MapEntry Object 
		//with key of country name and value of poulation 
		//Populate a HashMap with each entry in the end subscriber
		//************************************************************************
		//Create an observable chain where the end Observer receives a MapEntry Object 
		//with a key of country name and value of poulation density (people per 1km^2) 
		//Populate a HashMap with each entry in the end subscriber
// public List<Double> isAllCountriesPopulationMoreThanOneMillion(List<Country> countries) {
//        return Observable.fromIterable(countries).all(ctry -> ctry.population>1000000);
//    }
//    
//    //************************************************************************
//    //Create an observable chain where the end Observer receives a MapEntry Object 
//    //with key of country name and value of poulation 
//    //Populate a HashMap with each entry in the end subscriber
// public Observable<Long> listPopulationOfEachCountry(List<Country> countries) {
//        return Observable.fromIterable(countries).map(ctry -> ctry.getPopulation());
//    
//    
//    }
	}
}
