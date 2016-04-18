package observer;
import java.util.ArrayList;
import java.util.List;
public class FreeStuffImpl implements FreeStuff {
    private List<Subscriber> subscribers;
    private String message;
    private boolean changed;
    private final Object MUTEX= new Object();
     
    public FreeStuffImpl(){
        this.subscribers=new ArrayList<>();
    }
    @Override
    public void register(Subscriber sub) {
        if(sub == null) throw new NullPointerException("Null Subscriber");
        synchronized (MUTEX) {
        if(!subscribers.contains(sub)) subscribers.add(sub);
        }
    }
 
    @Override
    public void unregister(Subscriber sub) {
        synchronized (MUTEX) {
        subscribers.remove(sub);
        }
    }
 
    @Override
    public void notifySubscribers() {
        List<Subscriber> SubscribersLocal = null;
        //synchronization is used to make sure any Subscriber registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            SubscribersLocal = new ArrayList<>(this.subscribers);
            this.changed=false;
        }
        for (Subscriber sub : SubscribersLocal) {
            sub.update();
        }
 
    }
 
    @Override
    public Object getUpdate(Subscriber subs) {
        return this.message;
    }
     
    @Override
    public void postMessage(String msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.message=msg;
        this.changed=true;
        notifySubscribers();
    }

}
