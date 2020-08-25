/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactive.systems.streams;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author James
 */
public class CountryStreams {

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

		List<Country> loopSelectedCountries = new ArrayList<>();
		for (Country country : countries) {
			if (country.getName().startsWith("S")) {
				loopSelectedCountries.add(country);
			}
		}

		List<Country> streamSelectedCountries
				= countries.stream().filter(country -> country.getPopulation() > 20).collect(Collectors.toList());

		System.out.println("loopSelectedCountry" + loopSelectedCountries.toString());
		System.out.println("streamSelectedCountry" + streamSelectedCountries.toString());

		List<String> streamSelectedCapitalNames
				= countries.stream().filter(country -> country.getPopulation() > 20).map(country -> country.getCapital()).collect(Collectors.toList());

		System.out.println("streamSelectedCapitalNames" + streamSelectedCapitalNames.toString());

		//************************************************************************
		//************************************************************************
		//Using the streams functions build perform the following tasks:
		//************************************************************************
		//************************************************************************
		//************************************************************************
		//Create a list of country objects that 
		//are in the EU and whose capitals begin with L
		//************************************************************************
		List<Country> euCountriesWithCapitalCitiesBeginingWithL;

		euCountriesWithCapitalCitiesBeginingWithL = countries.stream()
				.filter(country -> country.isEuMember() && country.getCapital().startsWith("L"))
				.collect(Collectors.toList());
		System.out.println("euCountriesWithCapitalCitiesBeginingWithL" + euCountriesWithCapitalCitiesBeginingWithL.toString());

		//************************************************************************
		//Create a list of names of countries that 
		//are in the EU and whose capitals begin with L
		List<String> euCountryNamesWithCapitalCitiesBeginingWithL;
		euCountryNamesWithCapitalCitiesBeginingWithL = countries.stream()
				.filter(country -> country.isEuMember() && country.getCapital().startsWith("L"))
				.map(country -> country.getName())
				.collect(Collectors.toList());

		System.out.println("euCountryNamesWithCapitalCitiesBeginingWithL" + euCountryNamesWithCapitalCitiesBeginingWithL.toString());

		//************************************************************************
		//Convert the stream of countries to a map with key of country name and value of poulation 
		//See tutorial; on conmverting streams to maps here https://www.amitph.com/convert-list-to-map-using-streams/
		var countryNamePopulationMap = countries.stream()
				.collect(Collectors.toMap(Country::getName, Country::getPopulation));
		System.out.println("countryNamePopulationMap" + countryNamePopulationMap.toString());

		//************************************************************************
		//Convert the stream of countries to a map with key of country name and value of poulation density (people per 1km^2) 
		//Check your sums here https://www.worldometers.info/world-population/austria-population/
		//See tutorial; on conmverting streams to maps here https://www.amitph.com/convert-list-to-map-using-streams/
		var countryNamePopulationDensityMap = countries.stream()
				.collect(Collectors.toMap(Country::getName, Country::getPopulationDensity));
		System.out.println("countryNamePopulationDensityMap" + countryNamePopulationDensityMap.toString());

	}
}
