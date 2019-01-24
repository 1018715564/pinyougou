package cn.itcast.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQXAConnectionFactory;

public class TopicConsumer {

	public static void main(String[] args) throws Exception {
		//1���������ӹ���
		ConnectionFactory connectionFactory = new ActiveMQXAConnectionFactory("tcp://192.168.25.132:61616");
		//2����������
		Connection connection = connectionFactory.createConnection();
		//3����������
		connection.start();
		//4������session  org1 �Ƿ������� org2 �ύ��ʽ���Զ��ύ
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5���������ж���
		Topic topic = session.createTopic("test-topic");
		//6��������Ϣ������
		MessageConsumer consumer = session.createConsumer(topic);
		//7����������
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message massage) {
				TextMessage textMessage = (TextMessage) massage;
				try {
					System.out.println("�յ�����Ϣ:"+textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		//8���ȴ���������
		System.in.read();
		//9���ر���Դ
		consumer.close();
		session.close();
		connection.close();
	}
}
