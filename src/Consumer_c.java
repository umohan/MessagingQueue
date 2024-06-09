import java.util.ArrayList;
import java.util.List;
public class Consumer_c implements Consumer {
	
	List<Topic> m_topicList;
	PubSub psb;
	Consumer_c(PubSub psb)
	{
		m_topicList = new ArrayList<Topic>();
		this.psb = psb;
	}
	
	public boolean register(Topic topic)
	{
		if(m_topicList.contains(topic))
		{
			System.out.println("Topic already registerd");
			return false;
		}
		else
		{
			psb.registerConsumer(this, topic);
			return true;
		}
	}
	public void recieve(Message msg)
	{
		System.out.println("Message recieved "+msg.message+" from "+msg.m_reciever);
	}

}
