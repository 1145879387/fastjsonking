package fastjsonking;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by 2018/7/17 on 16:47.
 * Created by 常江 on 2017/5/31.
 */
public class kula {
	static StringBuffer stringBufferd = new StringBuffer();
	static StringBuffer fanhuijieguo = new StringBuffer();
	public static void main(String[] args) throws IOException {
//		chushihuafangfa();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入文件夹名称");
		String s1 = scanner.nextLine();
		StringBuffer wenjianjia = new StringBuffer(s1);
		wenjianjia.insert(0, "(常江)");
//		TODO https://blog.csdn.net/weixin_40335368/article/details/78628371
		System.out.println(wenjianjia);
		String kb = "D:\\" + wenjianjia.toString();
		File file1 = new File(kb);
		if (!file1.exists()) {
			System.out.println("不存在该目录！");
			boolean mkdir = file1.mkdir();
			System.out.println(mkdir+file1.getAbsolutePath());
		}
		File nextFile = new File(file1,"终端返销");
		if(!nextFile.exists()){
			nextFile.mkdirs();
			//mkdirs可以建立多级文件夹， 而mkdir()只能建立一级的文件夹，如果输入多级路径，则会返回false；
		}
		if (nextFile.isDirectory()) {
			File file = new File(nextFile, "消息报文.txt");
			file.createNewFile();
			System.out.println("文件创建成功");
		} else {
			System.out.println("创建失败");
		}
		if (nextFile.isDirectory()) {
			File file = new File(nextFile, "接口2.txt");
			file.createNewFile();
			System.out.println("文件创建成功");
		} else {
			System.out.println("创建失败");
		}

	}

	private static void chushihuafangfa() {
		Scanner scanner = new Scanner(System.in);
		Scanner scanners = new Scanner(System.in);
		System.out.println("请输入url地址");
		String s = scanner.nextLine();
		System.out.println("请输入json串");
		while (!scanner.hasNext("0")) {
			stringBufferd.append(scanner.next());
		}
		System.out.println("请输入返回结果的json串");
		while (!scanners.hasNext("0")) {
			fanhuijieguo.append(scanners.next());
		}
		int i = s.lastIndexOf("/");
		String split = s.substring(0, i);
		int i1 = split.lastIndexOf("/");
		String substring1 = split.substring(i1+1, split.length());
		System.out.println();
		String substring = s.substring(i, s.length());
		System.out.println(split);
		System.out.println("文件名是" + substring1+"interface.py");
		System.out.println("后续参数是"+substring);
		System.out.println(stringBufferd);
		System.out.println("返回结果"+fanhuijieguo);
		//		方法名+interface.py
	}
}
