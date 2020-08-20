package reactive.systems.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealsPublisher implements Subject {

	List<Observer> subscribers = new ArrayList<>();
	String name;
	Scanner in;

	public DealsPublisher(String name) {
		this.name = name;
		in = new Scanner(System.in);
	}

	@Override
	public void registerObserver(Observer observer) {
		subscribers.add(observer);
	}

	@Override
	public void unRegisterObserver(Observer o) {
		subscribers.remove(o);
	}

	@Override
	public void notifyObservers(String update) {
		System.out.println("Subject " + name + " published an offer: " + update);
		for (Observer sub : subscribers) {
			sub.update(update);
		}
	}

}
