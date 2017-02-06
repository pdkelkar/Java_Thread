package au.com.threads.lab;

public class MsgConsumer implements Runnable {
	
	private Message message;
	
	public MsgConsumer(Message message) {
		this.setMessage(message);
	}

	@Override
	public void run() {
		try{			
			
			System.out.println(Thread.currentThread().getName()+" message is: "+message.getMsg());
			System.out.println(Thread.currentThread().getName()+" waiting");
			synchronized (message) {
				message.wait();
			}
			
			System.out.println(Thread.currentThread().getName()+" wait completed");
			System.out.println(Thread.currentThread().getName()+" message is: "+message.getMsg());

		}catch(InterruptedException ie){
			System.err.println(ie.getMessage());
		}		
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
