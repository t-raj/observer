package observer;

public class SubscriberImpl implements Subscriber {
    private String name;
    private FreeStuff scout;
     
    public SubscriberImpl(String nm){
        this.name=nm;
    }
    @Override
    public void update() {
        String msg = (String) scout.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
        System.out.println(name+":: Consuming message::"+msg);
    }
 
    @Override
    public void setScout(FreeStuff scout) {
        this.scout=scout;
    }
}
