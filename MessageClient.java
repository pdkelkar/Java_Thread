package au.com.threads.lab;

public class MessageClient {

	public static void main(String[] args) {
		Message message = new Message("Hello World");
		
		MsgConsumer msgConsumer = new MsgConsumer(message);
		Thread msgConsume = new Thread(msgConsumer, "THREAD_CONSUMER");
		msgConsume.start();

		
		MsgProducer msgProducer = new MsgProducer(message);
		Thread msgProduce = new Thread(msgProducer, "THREAD_PRODUCER");
		msgProduce.start();

		

	}

}
