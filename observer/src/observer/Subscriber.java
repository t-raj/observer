package observer;

public interface Subscriber {
    //method to update the subscriber, used by FreeStuff scout
    public void update();
     
    //attach with FreeStuff scout to observe
    public void setScout(FreeStuff f);
}
