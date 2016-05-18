package com.test.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class FileHelper {
	/**
	 * 判断文件是否存在
	 * 
	 * @param filename
	 *            配置文件的路径名
	 * 
	 * @author songnan
	 * @Date 2009-05-19
	 * @return
	 */
	public static boolean exists(String filename) {
		// 测试此抽象路径名表示的文件或目录是否存在
		return new File(filename).exists();
	}

	/**
	 * 读取配置文件中的信息 放入 Properties 持久的属性集中
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 * @author songnan
	 * @Date 2009-05-19
	 */
	public static Properties readPropertiesFile(String filename)
			throws IOException {
		// 实例化一个 持久的属性集
		Properties properties = new Properties();
		// 通过打开一个到实际文件的连接来创建一个 FileInputStream
		FileInputStream fis = new FileInputStream(filename);
		// 从输入流中读取属性列表（键和元素对）
		properties.load(fis);
		return properties;
	}

	/**
	 * 读取stringName 指定的文件内容
	 * 
	 * @param stringName
	 * @return
	 * @throws IOException
	 */
	public static String readFile(String stringName) throws IOException {
		try {
			StringBuffer sb = new StringBuffer();
			// 通过打开一个到实际文件的连接来创建一个 FileInputStream
			// 创建使用给定字符集的 InputStreamReader
			// 创建一个使用默认大小输入缓冲区的缓冲字符输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(stringName), "8859_1"));
			// 读取一个文本行
			String strReadLine = br.readLine();
			while (strReadLine != null) {
				sb.append(strReadLine + "\r\n");
				System.out.println(strReadLine + "\r\n");
			}
			br.close();
			return sb.toString();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return "";
	}

	/**
	 * 把内容输入到相应的文件中
	 * 
	 * @param fileName
	 * @param paramString2
	 * @throws IOException
	 */
	public static void writeFile(String fileName, String content)
			throws IOException {
		new File(fileName).delete();// 删除此抽象路径名表示的文件或目录
		// 创建一个向具有指定名称的文件中写入数据的输出文件流
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		// 将 b.length 个字节从指定 byte 数组写入此文件输出流中
		fileOutputStream.write(content.getBytes());
		// 关闭此文件输出流并释放与此流有关的所有系统资源
		fileOutputStream.close();
	}

	public static void copyFile(String paramString1, String paramString2)
			throws IOException {
		byte[] arrayOfByte = new byte[100000];
		BufferedInputStream localBufferedInputStream = new BufferedInputStream(
				new FileInputStream(paramString1));
		FileOutputStream localFileOutputStream = new FileOutputStream(
				paramString2);
		int i;
		while ((i = localBufferedInputStream.read(arrayOfByte, 0, 100000)) > 0) {
			localFileOutputStream.write(arrayOfByte, 0, i);
			localFileOutputStream.flush();
		}
		localBufferedInputStream.close();
		localFileOutputStream.close();
	}
}