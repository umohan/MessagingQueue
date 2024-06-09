import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Emitter extends Thread {
	
	Queue<Message> m_Queue;
	private boolean m_exit;
	List<Consumer> m_counsumers;
	Thread t1;
	Lock m_lock;
	Emitter()
	{
		m_Queue = new LinkedList<>();
		m_exit = false;
		m_counsumers = new ArrayList<>();
		m_lock = new ReentrantLock();
	}
	
	public void run()
	{
		while(!m_exit)
		{
			while(m_Queue.size() >0)
			{
				m_lock.lock();
				Message m1 = m_Queue.poll();
				m_lock.unlock();
				for(Consumer c:m_counsumers)
					c.recieve(m1);
			}
			try {
			Thread.sleep(10000);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public void start()
	{
	   t1 = new Thread(this);
	  
	   t1.start();
	   System.out.println("I am called1111");
	}
	
	public void exit() throws Exception
	{
		m_exit = true;
		t1.join();
	}
	
	public void recieveMessage(Message msg)
	{
		m_lock.lock();
		m_Queue.add(msg);
		m_lock.unlock();
		System.out.println(m_Queue.size());
		//Unlock
	}
	
	public void addConsumer(Consumer cnsmr)
	{
		m_counsumers.add(cnsmr);
	}
}
