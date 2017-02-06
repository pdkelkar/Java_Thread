package au.com.threads.lab;

public class MsgProducer implements Runnable {

	private Message message;
	
	public MsgProducer(Message message) {
		this.setMessage(message);
	}
	
	@Override
	public void run() {
		try{
			System.out.println(Thread.currentThread().getName()+" notifying");
			synchronized (message) {
				Thread.sleep(5000);
				message.setMsg(message.getMsg() + " What a nice day");
				message.notify();				
			}
			System.out.println(Thread.currentThread().getName()+" waiting thread notified");
		}catch (InterruptedException ie){
			System.err.println(ie.getMessage());
		}
		//System.out.println(Thread.currentThread().getName()+" message is: "+message.getMsg());
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
