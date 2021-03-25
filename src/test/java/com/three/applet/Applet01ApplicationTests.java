package com.three.applet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

@SpringBootTest
class Applet01ApplicationTests {

	@Test
	void contextLoads() throws InterruptedException {
		Lock lock = new ReentrantLock();
		lock.tryLock();
		BlockingDeque queue = new LinkedBlockingDeque();
		queue.take();
	}

	public static void main(String[] args) {
		try {
			unZipFiles(new File("/Users/wangke/Public/未命名文件夹/axure.zip"),"/Users/wangke/Public/未命名文件夹/axure/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	/**
	 * 解压文件到指定目录
	 */
	@SuppressWarnings("rawtypes")
	public static void unZipFiles(File zipFile,String descDir)throws IOException
	{
		File pathFile = new File(descDir);
		if(!pathFile.exists())
		{
			pathFile.mkdirs();
		}
		//解决zip文件中有中文目录或者中文文件
		ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
		for(Enumeration entries = zip.entries(); entries.hasMoreElements();)
		{
			ZipEntry entry = (ZipEntry)entries.nextElement();
			String zipEntryName = entry.getName();
			InputStream in = zip.getInputStream(entry);
			String outPath = (descDir+zipEntryName).replaceAll("\\*", "/");;
			//判断路径是否存在,不存在则创建文件路径
			File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
			if(!file.exists())
			{
				file.mkdirs();
			}
			//判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
			if(new File(outPath).isDirectory())
			{
				continue;
			}
			//输出文件路径信息
			System.out.println(outPath);
			OutputStream out = new FileOutputStream(outPath);
			byte[] buf1 = new byte[1024];
			int len;
			while((len=in.read(buf1))>0)
			{
				out.write(buf1,0,len);
			}
			in.close();
			out.close();
		}
		System.out.println("******************解压完毕********************");
	}
}
