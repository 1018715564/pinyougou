package cn.itcast.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQXAConnectionFactory;
/**
 * Topic���ڹ㲥��
 * @author ����
 *
 */
public class TopicProducer {
	public static void main(String[] args) throws Exception{
		//1���������ӹ���
		ConnectionFactory connectionFactory = new ActiveMQXAConnectionFactory("tcp://192.168.25.132:61616");
		//2����������
		Connection connection = connectionFactory.createConnection();
		//3����������
		connection.start();
		//4������session  org1 �Ƿ������� org2 �ύ��ʽ���Զ��ύ
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5����������/������ж���
//		Queue queue = session.createQueue("test-queue");
		Topic topic = session.createTopic("test-topic");
		//6��������Ϣ������
		MessageProducer producer = session.createProducer(topic);
		//7��������Ϣ
		TextMessage textMessage = session.createTextMessage("��ӭ����Ʒ�Ź�����");
		//8������
		producer.send(textMessage);
		//9���ر���Դ
		producer.close();
		session.close();
		connection.close();
		
	}
}
