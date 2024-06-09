
public class producer_b implements Producer {
	
	String Id;
	PubSub m_PubSub;
	producer_b(PubSub pbsb)
	{
		this.m_PubSub = pbsb;
		this.Id = "produce_b";
	}
	
	@Override
	public void sendmessage(Topic tp) {
		
		
		for(int i=100;i<130;i++)
		{
			Message msg = new Message("hello"+i, Id);
			m_PubSub.sendMessage(msg, tp);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("Exception for Consumer "+e.getMessage());
			}
		}
		
	}
}
