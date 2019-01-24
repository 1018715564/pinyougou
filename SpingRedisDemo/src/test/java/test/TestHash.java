package test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class TestHash {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public void setHash() {
		/**
		 * �����key ��key�а���Сkey
		 */
		redisTemplate.boundHashOps("name").put("a", "��ɮ");
		redisTemplate.boundHashOps("name").put("b", "�����");
		redisTemplate.boundHashOps("name").put("c", "�˽�");
		redisTemplate.boundHashOps("name").put("d", "ɳ��");
	}
	
	//��ȡ���е�key 
	public void getHash() {
		redisTemplate.boundHashOps("name").keys();
	}
	
	
//	��ȡ���е�value
	public void getValue() {
		redisTemplate.boundHashOps("name").values();
	}
	
//	����KEY��ȡֵ
	public void getKey() {
		redisTemplate.boundHashOps("name").get("a");
	}
	
//	����keyɾ��value
	public void delteKey() {
		redisTemplate.boundHashOps("name").delete("c");
	}
	

}
