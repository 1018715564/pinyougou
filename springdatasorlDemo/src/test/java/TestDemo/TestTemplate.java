package TestDemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.demo.TbItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-solr.xml")
public class TestTemplate {
	
	@Autowired
	private SolrTemplate solrTemplate;

	@Test
	public void addTest() {
		TbItem item = new TbItem();
		item.setId(1l);
		item.setTitle("��Ϊnavo2plus");
		item.setBrand("��Ϊ");
		item.setCategory("�ֻ�");
		item.setGoodsId(1l);
		item.setPrice(new BigDecimal(3000.02));
		item.setSeller("��Ϊ�콢��");
		
		solrTemplate.saveBean(item);
		solrTemplate.commit();
	}
	
	@Test
	public void findById() {
		
		TbItem item = solrTemplate.getById(1l, TbItem.class);
		System.out.println(item.getTitle());
	}
	
	@Test
	public void deleteById() {
		solrTemplate.deleteById("1");
		solrTemplate.commit();
	}
	
	
	//������������
	@Test
	public void addTestList() {
		List list = new  ArrayList<Object>();
		
		for(int i=0;i<100;i++) {
			TbItem item = new TbItem();
			item.setId(i+1l);
			item.setTitle("��Ϊnavo"+i+"plus");
			item.setBrand("��Ϊ");
			item.setCategory("�ֻ�");
			item.setGoodsId(1l);
			item.setPrice(new BigDecimal(3000.02+i));
			item.setSeller("��Ϊ�콢��");
			list.add(item);
		}
		solrTemplate.saveBeans(list);
		solrTemplate.commit();
	}
	
//	��ҳ
	@Test
	public void pageTest() {
		
		Query query = new SimpleQuery("*:*");
		query.setOffset(0);//��ʼ��ҳ��
		query.setRows(10);//�����ʾ������
		
		ScoredPage<TbItem> page = solrTemplate.queryForPage(query , TbItem.class);
//		����
		for (TbItem tbItem : page) {
			System.out.println(tbItem.getTitle()+"\t"+tbItem.getPrice()+"\t"+tbItem.getBrand());
		}
		
		System.out.println("�ܼ�¼��"+page.getTotalElements());
		System.out.println("��ҳ��"+page.getTotalPages());
	}
	
	
	@Test
	public void pageTestMunit() {
		
		Query query = new SimpleQuery("*:*");
		
		Criteria criteria=new Criteria("item_category").contains("�ֻ�");
		criteria=criteria.and("item_title").contains("5");		
		query.addCriteria(criteria);

		
		
//		query.setOffset(0);//��ʼ��ҳ��
//		query.setRows(10);//�����ʾ������
		
		ScoredPage<TbItem> page = solrTemplate.queryForPage(query , TbItem.class);
//		����
		for (TbItem tbItem : page) {
			System.out.println(tbItem.getTitle()+"\t"+tbItem.getPrice()+"\t"+tbItem.getBrand());
		}
		
		System.out.println("�ܼ�¼��"+page.getTotalElements());
		System.out.println("��ҳ��"+page.getTotalPages());
	}
	
	
//	ɾ��
	@Test
	public void deleteAll() {
		Query query = new SimpleQuery("*:*");//ɾ������
		solrTemplate.delete(query);
		solrTemplate.commit();//�ύ
	}
	
	

}
