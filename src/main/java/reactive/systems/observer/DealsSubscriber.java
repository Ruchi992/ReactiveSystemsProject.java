/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactive.systems.observer;

import reactive.systems.observer.Observer;


/**
 *
 * @author James
 */
public class DealsSubscriber implements Observer {

    String name;
    
    public DealsSubscriber(String name){
        this.name =name;
    }
    
    @Override
    public void update(String update) {
        System.out.println(name +" received a message: "+update);
    }
    
}
