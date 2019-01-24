package cn.itcast.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		��һ��������һ�� Configuration ����ֱ�� new һ�����󡣹��췽���Ĳ������� freemarker�İ汾�š�
		Configuration configuration = new Configuration(Configuration.getVersion());
//		�ڶ���������ģ���ļ����ڵ�·����
		configuration.setDirectoryForTemplateLoading( new File("E:/SSH/workspace_pingyougou/freemarkerDemo/src/main/resources/"));
//		������������ģ���ļ�ʹ�õ��ַ�����һ����� utf-8.
		configuration.setDefaultEncoding("GBK");
//		���Ĳ�������һ��ģ�壬����һ��ģ�����
		Template template = configuration.getTemplate("test.ftl");
//		���岽������һ��ģ��ʹ�õ����ݼ��������� pojo Ҳ������ map��һ���� Map��
		Map map = new HashMap();
		map.put("name", "tom");
		map.put("message", "is my pinyougou");
		map.put("success", true);
		map.put("tody", new Date());
		map.put("point", 155251365);
		
		
		
		List goodList = new ArrayList();
		Map map1 = new HashMap();
		map1.put("name", "ƻ��");
		map1.put("price", "500");
		Map map2 = new HashMap();
		map2.put("name", "����");
		map2.put("price", "300");
		Map map3 = new HashMap();
		map3.put("name", "�㽶");
		map3.put("price", "200");
		
		goodList.add(map1);
		goodList.add(map2);
		goodList.add(map3);
		
		map.put("goodList", goodList);
		
		
//		������������һ�� Writer ����һ�㴴��һ FileWriter ����ָ�����ɵ��ļ�����
		Writer out = new FileWriter(new File("d:\\test.html"));
//		���߲�������ģ������ process ��������ļ���
		template.process(map, out);
//		�ڰ˲����ر���
		out.close();

	}

}
