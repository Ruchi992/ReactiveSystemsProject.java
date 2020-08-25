package reactive.systems.observer;

public class DealsExample {

	public static void main(String[] args) {
		Subject limerickCityDeals = new DealsPublisher("Limerick City");
		Subject limerickCountyDeals = new DealsPublisher("Limerick County");
		Subject clareCountyDeals = new DealsPublisher("County Clare");

		Observer tommyObserver = new DealsSubscriber("Tommy");
		Observer seanObserver = new DealsSubscriber("Sean");
		Observer maryObserver = new DealsSubscriber("Mary");

		//
		//	setup
		//
		        /**
         * Register Tommy for Limerick City Deals. Register Sean for County Clare
         * Deals. Register Mary for County Limerick and Limerick City Deals
         *
         */
       
		limerickCityDeals.registerObserver(tommyObserver);
		clareCountyDeals.registerObserver(seanObserver);
		limerickCountyDeals.registerObserver(maryObserver);
		limerickCityDeals.registerObserver(maryObserver);	
		//	run
		//
        /**
         * Have limerickCityDeals publish the message "Jetland Dunnes has cheap socks!". 
         * limerickCountyDeals publish the message "Adare Manor has rooms for €20!"
         * and clareCountyDeals publish the message "Fights from Shannon to Spain for €50!"
         *
         */
		limerickCityDeals.notifyObservers("Jetland Dunnes has cheap socks!");
		limerickCountyDeals.notifyObservers("Adare Manor has rooms for 20 euro");
		clareCountyDeals.notifyObservers("Files from Shannon to Spain for 50 euro");
	}
}