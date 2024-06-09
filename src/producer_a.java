
public class producer_a implements Producer {
	
	String Id;
	PubSub m_PubSub;
	producer_a(PubSub pbsb)
	{
		this.m_PubSub = pbsb;
		this.Id = "produce_a";
	}
	
	@Override
	public void sendmessage(Topic tp) {
		
		
		for(int i=10;i<20;i++)
		{
			Message msg = new Message("hello"+i, Id);
			m_PubSub.sendMessage(msg, tp);
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				System.out.println("Exception for Consumer "+e.getMessage());
			}
		}
		
		
	}
}
