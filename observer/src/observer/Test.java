package observer;

public class Test {
    public static void main(String[] args) {
        //create FreeStuff scout
        FreeStuff FreeStuffChicago = new FreeStuffImpl();
         
        //create Subscribers
        Subscriber BrokeButNotBroken = new SubscriberImpl("BrokeButNotBroken");
        Subscriber technomad = new SubscriberImpl("technomad");
        Subscriber freeloader = new SubscriberImpl("freeloader");
         
        //register Subscribers to the scout
        FreeStuffChicago.register(BrokeButNotBroken);
        FreeStuffChicago.register(technomad);
        FreeStuffChicago.register(freeloader);
         
        //attach Subscriber to scout
        BrokeButNotBroken.setScout(FreeStuffChicago);
        technomad.setScout(FreeStuffChicago);
        freeloader.setScout(FreeStuffChicago);
         
        //check if any update is available
        BrokeButNotBroken.update();
        technomad.update();
        freeloader.update();
         
        //now send message to subject
        FreeStuffChicago.postMessage("New Message");
    }
}
