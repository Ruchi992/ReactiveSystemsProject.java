package reactive.systems.observer;

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