
public class Driver {

	public static void main(String[]args)throws Exception
	{
		
		PubSub pb = new PubSub();
		Topic t1 = new Topic("first", 1);
		Topic t2 = new Topic("sec", 1);
		Topic t3 = new Topic("thr", 1);
		Topic t4 = new Topic("fr", 1);
		
		pb.addTopic(t1);
		pb.addTopic(t2);
		pb.addTopic(t3);
		pb.addTopic(t4);
		
		Producer p1 = new producer_a(pb);
		Producer p2 = new producer_b(pb);
		
		Consumer c1 = new Consumer_a(pb);
		Consumer c2 = new Consumer_b(pb);
		Consumer c3 = new Consumer_c(pb);
		
		
		
		c1.register(t1);
		c1.register(t2);
		c1.register(t3);
		
		c2.register(t2);
		c2.register(t3);
		
		
		c3.register(t4);
		
		
		p1.sendmessage(t1);
		
		p1.sendmessage(t2);
		
		p2.sendmessage(t3);
		
		p2.sendmessage(t4);
	
		
	}
}
