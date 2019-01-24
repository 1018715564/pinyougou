package cn.itcast.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestDemo02 {
	
	public static void main(String[] args) throws Exception{
		
	
	 //1.����������
	Configuration configuration=new Configuration(Configuration.getVersion());
	//2.����ģ�����ڵ�Ŀ¼ 
	configuration.setDirectoryForTemplateLoading(new File("E:\\SSH\\workspace_pingyougou\\freemarkerDemo\\src\\main\\resources\\"));
	//3.�����ַ���
	configuration.setDefaultEncoding("utf-8");
	//4.����ģ��
	Template template = configuration.getTemplate("test.ftl");
	//5.��������ģ��
	Map map=new HashMap();
	map.put("name", "���� ");
	map.put("message", "��ӭ���������Ʒ�Ź����磡");
	//6.����Writer����
	Writer out =new FileWriter(new File("d:\\test.html"));
	//7.���
	template.process(map, out);
	//8.�ر�Writer����
	out.close();
	}
}
