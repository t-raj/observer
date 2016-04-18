package observer;

public interface FreeStuff {
    //methods to register and unregister subscribers
    public void register(Subscriber sub);
    public void unregister(Subscriber sub);
     
    //method to notify subscribers of change
    public void notifySubscribers();
     
    //method to get updates from FreeStuff scout
    public Object getUpdate(Subscriber sub);
    
  //method to post message to the scout's feed
    public void postMessage(String msg);
}
