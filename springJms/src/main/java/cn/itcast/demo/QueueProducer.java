package cn.itcast.demo;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {
	/**
	 * ʹ��spring����Jms���ǰѴ����������������ӡ�������ֱ�ӽ���spring�������ֱ��ע�뿪��
	 * 
	 * ʹ��JmsTemplatģ�� ���ṩ�ķ�������
	 * 
	 * ʹ��������ķ�ʽ���ýӿ�ֱ�Ӵ���ʵ����
	 * 
	 */
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination queueTextDestination;
	
	public void sendMessage(final String text) {
		jmsTemplate.send(queueTextDestination, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(text);
			}
		});
		
		
	}
	
}
