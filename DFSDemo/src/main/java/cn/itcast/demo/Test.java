package cn.itcast.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
//		1�����������ļ��������ļ������ݾ�����racket����
		ClientGlobal.init("E:\\SSH\\workspace_pingyougou\\DFSDemo\\src\\main\\resources\\fdfs_client.conf");
//		2������client����
		TrackerClient trackerClient = new TrackerClient();
//		����track Clinetservice����
		TrackerServer trackerServer  = trackerClient.getConnection();
//		// 4������һ�� StorageServer �����ã�ֵΪ null
		StorageServer storageServer = null;
		
//		��������storangeClient������Ҫ��������trackerClient��trackerServer
		StorageClient client = new StorageClient(trackerServer, storageServer);
		
//		�ϴ�ͼƬ
		String[] strings = client.upload_file("D:/upload/image\\01.gif", "gif", null);
		
//		��������
		for(String str : strings) {
			System.out.println(str);
		}
	}
}
