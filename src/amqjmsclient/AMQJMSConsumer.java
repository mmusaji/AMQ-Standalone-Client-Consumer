package amqjmsclient;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class AMQJMSConsumer {
	
	// URL of the JMS server. DEFAULT_BROKER_URL will just mean
    // that JMS server is on localhost
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    // Alternatively provide host and port for a specific broker
    // private static String url = "tcp://10.33.24.105:61616";
    // Name of the queue we will be sending messages to
    private static String subject = "TestQueue";

	public static void main(String[] args) throws JMSException {
		// Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        // set user and password in ../etc/users.properties
        Connection connection = connectionFactory.createConnection("admin", "redhat");

        // JMS messages are sent and received using a Session. We will
        // create here a non-transactional session object. If you want
        // to use transactions you should set the first parameter to 'true'
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        Queue queue = session.createQueue(subject);
        
        MessageConsumer consumer = session.createConsumer(queue);
        
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message msg) {
              try {
                if (! (msg instanceof TextMessage))
                  throw new RuntimeException("no text message");
                TextMessage tm = (TextMessage) msg;
                System.out.println("I got this message: " + tm.getText());                  // print message
              }
              catch (JMSException e) {
                System.err.println("Error reading message");
              }
            }
          });
        
        connection.start();
	} 

}
