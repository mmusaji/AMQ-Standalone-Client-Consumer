package amqjmsclient;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;	
import org.apache.activemq.ActiveMQConnectionFactory;

public class AMQJMSClient {

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

        connection.start();

        // JMS messages are sent and received using a Session. We will
        // create here a non-transactional session object. If you want
        // to use transactions you should set the first parameter to 'true'
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Destination represents here our queue 'TestQueue' on the
        // JMS server. You don't have to do anything special on the
        // server to create it, it will be created automatically.
        Destination destination = session.createQueue(subject);

        // MessageProducer is used for sending messages (as opposed
        // to MessageConsumer which is used for receiving them)
        MessageProducer producer = session.createProducer(destination);

        // We will send a small text message
        TextMessage message = session.createTextMessage("Hi Guys");

        // Here we are sending the message!
        int i;
        for (i = 0; i <= 10; i++) {
            producer.send(message);
            System.out.println("Sent message '" + message.getText() + "'");
        }

        connection.close();
    }
}