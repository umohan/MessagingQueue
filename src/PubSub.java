import java.util.*;
public class PubSub {
	private HashMap<Topic, Emitter> m_map;
	
	PubSub()
	{
		m_map = new HashMap<>();
	}
	
	//Exposed to driver only
	public void addTopic(Topic tp)
	{
		
		Emitter emt = new Emitter();
		m_map.put(tp, emt);
		emt.start();
	}
	
	
	//Exposed Only to Sender
	public void sendMessage(Message msg, Topic tpc)
	{
		m_map.get(tpc).recieveMessage(msg);
	}
	
	
	//Exposed to Consumer
	public void registerConsumer(Consumer cnsmr, Topic tpc)
	{
		m_map.get(tpc).addConsumer(cnsmr);
	}
}
