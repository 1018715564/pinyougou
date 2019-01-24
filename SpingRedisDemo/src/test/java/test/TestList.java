package test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class TestList {
	
	@Autowired 
	private RedisTemplate redisTemplate;
	
	/**
	 * ��ѹջ
	 * ����ӵ��ź���
	 */
	@Test
	public void setList() {
		redisTemplate.boundListOps("namelist1").rightPush("����");
		redisTemplate.boundListOps("namelist1").rightPush("��Ȩ");
		redisTemplate.boundListOps("namelist1").rightPush("�ŷ�");
	}
	
	/**
	 * ��ȡ
	 */
	@Test
	public void getList() {
		
		List list = redisTemplate.boundListOps("namelist1").range(0, 10);
		System.out.println(list);
	}
	
	
	/**
	 * ��ѹջ
	 */
	@Test
	public void setListLeft() {
		redisTemplate.boundListOps("namelist2").leftPush("�ܲ�");
		redisTemplate.boundListOps("namelist2").leftPush("����");
		redisTemplate.boundListOps("namelist2").leftPush("���");
	}
	
	@Test
	public void getListLeft() {
		List  list = redisTemplate.boundListOps("nameList2").range(0, 10);
		System.out.println(list);
	}
	
	/**
	 * �Ƴ�ĳ��Ԫ��
	 */
	@Test
	public void removeList() {
		
		redisTemplate.boundListOps("nameList2").rename("����");
	}
	
	/**
	 * ɾ��
	 */
	public void delete() {
		redisTemplate.delete("nameList2");
	}
}
