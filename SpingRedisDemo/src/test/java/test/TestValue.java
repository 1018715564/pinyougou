package test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class TestValue {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
//	����ֵ
	@Test
	public void setValue() {
		
		redisTemplate.boundValueOps("name").set("itcast");
	}
	
	
//	��ȡ
	@Test
	public void getValue() {
		String string = (String) redisTemplate.boundValueOps("name").get();
		System.out.println(string);
	}
	
//	ɾ��
	@Test
	public void delete() {
//		ʹ��key��ɾ��value
		redisTemplate.delete("name");
	}
	
//	�洢����
	@Test
	public void setListValue() {
		redisTemplate.boundSetOps("setname").add("��Ȩ");
		redisTemplate.boundSetOps("setname").add("�ܲ�");
		redisTemplate.boundSetOps("setname").add("����");
	}
	
//	��ȡ�洢
	@Test
	public void getListValue() {
		
		Set set = redisTemplate.boundSetOps("setname").members();
		System.out.println(set);
	}
	
//	ɾ��
	@Test
	public void deleteList() {
		redisTemplate.boundSetOps("setname");
	}
	
//	ɾ������
	@Test
	public void removeList() {
		redisTemplate.boundSetOps("setname").remove("��Ȩ");
	}
	
	
	
	
	
}
