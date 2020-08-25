/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactive.systems.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import reactive.systems.observer.Observer;
import reactive.systems.observer.Subject;

/**
 *
 * @author James
 */
public class DealsPublisher implements Subject{

    List<Observer> subscribers = new ArrayList<Observer>();
    String name;
	Scanner in;
	

    public DealsPublisher(String name) {
        this.name = name;
		in = new Scanner(System.in);
    }

	public DealsPublisher() {
	}
    
    @Override
    public void registerObserver(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void unRegisterObserver(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObservers(String update) {
        System.out.println("Subject "+name+" published an offer: "+update); 
       for (Observer sub:subscribers){
           sub.update(update);
       }
    }
    
}
