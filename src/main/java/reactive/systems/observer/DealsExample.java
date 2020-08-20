package reactive.systems.observer;

public class DealsExample {

    public static void main(String[] args) {
		 DealsPublisher reg = new DealsPublisher();
		 DealsSubscriber sub = new DealsSubscriber();

        Subject limerickCityDeals = new DealsPublisher("Limerick City");
        Subject limerickCountyDeals = new DealsPublisher("Limerick County");
        Subject clareCountyDeals = new DealsPublisher("County Clare");

        //create observers
        Observer firstObserver = new DealsSubscriber("Tommy");

        Observer secondObserver = new DealsSubscriber("Sean");

        Observer thirdObserver = new DealsSubscriber("Mary");

        /**
         * Register Tommy for Limerick City Deals. Register Sean for County Clare
         * Deals. Register Mary for County Limerick and Limerick City Deals
         *
         */
		reg.registerObserver(firstObserver);
		reg.registerObserver(secondObserver);
		reg.registerObserver(thirdObserver);
        
        /**
         * Have limerickCityDeals publish the message "Jetland Dunnes has cheap socks!". 
         * limerickCountyDeals publish the message "Adare Manor has rooms for €20!"
         * and clareCountyDeals publish the message "Fights from Shannon to Spain for €50!"
         *
         */
		//DealsSubscriber sub = new (firstObserver)sub;
		 
		System.out.println("Jetland Dunnes has cheap socks!");
		System.out.println("Adare Manor has rooms for 20 euro");
		System.out.println("Files from Shannon to Spain for 50 euro");
       // sub.update(string update).forEach(System.out:: println);

    }

}
