
public interface Consumer {
	public boolean register(Topic topic);
	public void recieve(Message msg);
}
