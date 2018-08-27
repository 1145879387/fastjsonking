package fastjsonking;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.LinkedHashMultimap;
import jdk.nashorn.internal.ir.Flags;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class twoforjson {
	//	这里表明的是json嵌套的数值，始终表明最外围的变量
	static StringBuffer stringBuffer = new StringBuffer();
	//	这里的目的是生成一个嵌套数，表明谁嵌套谁，说明嵌套关系
	static StringBuffer stringBuffer2 = new StringBuffer();
	static StringBuffer stringBuffer3 = new StringBuffer();
	//	这里记录了最外围的头节点信息
	static StringBuffer stringBuffer4 = new StringBuffer();
	//	这里记录了头结点的信息，方便以后的操作
	static ArrayList<String> arrayLists = new ArrayList();
	////    这里记录了多层map平级关系下父节点的值
//	static StringBuffer mapjiedian = new StringBuffer();3
//    这里记录了最终的结果，结果可以输出到文件中
	static StringBuffer jieguo = new StringBuffer();
	//	这里记录了结果信息，方便打印
	private static ArrayList<String> arrayList = new ArrayList<>();
	//	这里用stringbuffer格式化结果
	static StringBuffer km = new StringBuffer();
	static StringBuffer archer = new StringBuffer();
	//	TODO 这里记录了平级父节点的信息
	static StringBuffer fujiedian = new StringBuffer();
	//	这里记录了平级子节点下是否有其他的子节点，如果没有，平级解析即可
	static StringBuffer zijiedian = new StringBuffer();
	static LinkedHashMultimap<String,String> zijiediantofuqin = LinkedHashMultimap.create();
	//	TODO 这里是json返回结果的成员变量
//	由于要改装成py文件读取格式的程序，所以我们需要一个map
	static LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
	//	这里记录了取出json的robot代码，也是结果，方便打印
	private static ArrayList<String> jieguoarrayList = new ArrayList<>();
	//	这里记录了最外围的头节点信息
	static StringBuffer jieguostringBuffer4 = new StringBuffer();
	//	这里表明的是json嵌套的数值，始终表明最外围的变量
	static StringBuffer jieguostringBuffer = new StringBuffer();
	//	这里的目的是生成一个嵌套数，表明谁嵌套谁，说明嵌套关系
	static StringBuffer jieguostringBuffer2 = new StringBuffer();
	//这里记录了那个节点是数组
	static StringBuffer jieguostringBuffer3 = new StringBuffer();
	//	这里记录了头结点的信息，方便以后的操作
	static ArrayList<String> jieguoarrayLists = new ArrayList();

	public static void main(String[] args) throws IOException {
//		这里主要对json进行详细的处理
//		这里首先判断是否是json,如果是json里面又是否嵌套json
		Scanner scanner = new Scanner(System.in);
		System.out.println("Robotjson脚本转换器");
		System.out.println("此脚本用于把postman报文里的json转换成可执行的robot脚本语言，产品通过输入规定内容，可自动生成部分robot脚本。");
		System.out.println("源码已发放在git上，将根据大家的意见进行不定期更新");
		System.out.println("https://github.com/1145879387/fastjsonking.git");
		System.out.println("需要输入4个内容，1,Postman中的发送报文，2，Postman中的接受报文，3，生成测试脚本的目录名，4，报文的url。");
		System.out.println("此外，可以动态配置数据库，需要粘贴数据库的URL,如果该URL存在，则选定指定的序号，如果URL不存在，则添加URL到配置文件中");
		System.out.println("请输入Postman中发送报文的jsons数据，回车后按0回车即可结束输入！");
		System.out.println("回车后按0是的原因是按0告诉程序我输入完了，应该有更好的技巧，见谅");
		StringBuffer stringBufferd = new StringBuffer();
		while (!scanner.hasNext("0")) {
			stringBufferd.append(scanner.next());
		}
		String string = stringBufferd.toString();
//		TODO 这里要修改输入参数的逻辑
//		Scanner scanner = new Scanner(System.in);
		Scanner scanners = new Scanner(System.in);
//		System.out.println("请输入url地址");
//		String s = scanner.nextLine();
		StringBuffer fanhuijieguo = new StringBuffer();
		System.out.println("请输入Postman中返回结果的json报文，回车后按0回车即可结束输入！");
		while (!scanners.hasNext("0")) {
			fanhuijieguo.append(scanners.next());
		}
		String string1 = fanhuijieguo.toString();
//		这里输入URL和文件名
		Scanner scannerwenjianjia = new Scanner(System.in);
		System.out.println("请输入文件夹名称,例：订单中心_查询接口");
		String swen = scannerwenjianjia.nextLine();
		StringBuffer wenjianjia = new StringBuffer(swen);
		wenjianjia.insert(swen.length(), "_V1");
//		TODO https://blog.csdn.net/weixin_40335368/article/details/78628371
		System.out.println(wenjianjia);
		String kb = "D:\\RobotForJson";
		File file1 = new File(kb);
//		boolean mkdir = file1.mkdir();
		if (!file1.exists()) {
			System.out.println("不存在该目录！");
			boolean mkdir = file1.mkdir();
			System.out.println(mkdir+file1.getAbsolutePath());
		}
		File nextFile = new File(file1,wenjianjia.toString());
		if(!nextFile.exists()){
			nextFile.mkdirs();
			//mkdirs可以建立多级文件夹， 而mkdir()只能建立一级的文件夹，如果输入多级路径，则会返回false；
		}
		System.out.println("请输入Postman中url名称！");
		Scanner url = new Scanner(System.in);
		String surl = url.nextLine();
		int iurl = surl.lastIndexOf("/");
		String spliturl = surl.substring(0, iurl);
		int i1 = spliturl.lastIndexOf("/");
		String substring1url = spliturl.substring(i1+1, spliturl.length());
		String substringurl = surl.substring(iurl, surl.length());
		String wenjianming = substring1url+"interface.py";
//		String wenjiantxt = substring1url + ".txt";
		String wenjiantxt = swen+"正常用例.txt";
		String wenjiantxts = swen+"异常用例.txt";
		System.out.println("url是"+spliturl);
		System.out.println("文件名是" + wenjianming);
		System.out.println("后续参数是"+substringurl);
		linkedHashMap.put("requestaddress", spliturl);
//		这里对url进行了额外的处理
		Scanner shujuku = new Scanner(System.in);
		System.out.println("这里采取配置文件的方式对数据库进行了处理，请配置指定的配置文件到D盘根目录下！文件名为connsql.txt");
		System.out.println("如果没有配置文件也可以手动输入数据库的URL链接地址！");
		File file=new File("D:\\connsql.properties");
		if (!file.exists()) {
//			如果没有文件，那么就动态创建一个文件
			file.createNewFile();
//			}
		} else {
			System.out.println("文件存储在D:\\connsql.properties目录下！");
		}
		test01();
//		TODO 这里只处理json嵌套Json的情况，如果是对jsonarray进行处理则需要加一个分支
		System.out.println(string);
//		TODO 这里无论是json还是jsonarray这么转换都不会出错，不过jsonarray转换成json的时候还需要用jsonarray特殊的方法
		JSONObject jsonObject = JSON.parseObject(string);
		JSONObject jieguojsonObject = JSON.parseObject(string1);
		jsonzh(jsonObject);
		jieguojsonzh(jieguojsonObject);
//		这里记录了键值对
// 		TODO 这里concat方法失效了，debug也没啥效果，字符串不想等，有点奇怪了，不过要注意的是，按空格截取会导致时间出现偏差，所以要换一个标志位
		System.out.println(stringBuffer);
		System.out.println("json返回的结果是"+jieguostringBuffer);
//		这里需要对键值对进行解析
		String[] split1 = stringBuffer.toString().split("&");
		String[] split2 = jieguostringBuffer.toString().split("&");
//		这里记录了映射关系
//		TODO 最难的一步来了，我需要根据stringbuffer2的内容，来判断嵌套关系并进行拼接操作
		System.out.println("json的嵌套关系是");
		LinkedHashMultimap<String,String> paixu = paixu(stringBuffer2.toString());
		System.out.println("返回结果json的嵌套关系是");
		System.out.println(paixu);
		System.out.println("其中是数组的值如下");
		//		这里记录了所有的数组
		System.out.println(stringBuffer3);
		System.out.println(jieguostringBuffer3);
//		TODO 这里我已经知道了头结点的信息，那么我可以操作json了
		System.out.println("头结点"+stringBuffer4);
		System.out.println("json返回结果头结点"+jieguostringBuffer4);
		String[] split = stringBuffer4.toString().split(" ");
		String[] jieguosplit = jieguostringBuffer4.toString().split(" ");
//		TODO 这里做了一些操作，我成功的取到了嵌套数里的值，并且知道了嵌套关系是什么，那么还剩下一点，就是拼接了
//		TODO 这里先拼接开头和结尾，然后写入到文件中
		arrayList.add("*** Settings ***");
		arrayList.add("Library           DatabaseLibrary");
		arrayList.add("Library           Selenium2Library");
		arrayList.add("Library           requests");
		arrayList.add("Library           RequestsLibrary");
		arrayList.add("Library           Collections");
//		TODO 这里的文件名应该是动态生成的，需要特殊处理
		arrayList.add("Variables         "+wenjianming);
		arrayList.add("");
		arrayList.add("*** Keywords ***");
		arrayList.add("message_001");
//		这里问题很大，由于Linkedhashmap是在pinjie方法之后运行的，而array也在这个方法里运行，所以会冲突，这里lnked的大小是空值，这样是没有效果的
//		arrayList.add(kula);
		arrayList.add("    ${header}    create dictionary    Accept-Encoding=");
//		TODO 这里还是需要修改的
		arrayList.add("    create session    url    ${requestaddress}    ${header}");
		arrayList.add("    ${time}    get time");
//		TODO 这里需要特殊的处理
		pinjie(paixu,split1,split);
		System.out.println(jieguo);
//		TODO 这里应该先判断头结点，然后再行操作,不过arr先写死，日后在做操作
		String message = "    ${message}    Create Dictionary    ";
		for (String s : split) {
			message += s + "=${" + s + "}    ";
		}
		String trim = message.trim();
//		arrayList.add("    ${message}    Create Dictionary    UNI_BSS_HEAD=${UNI_BSS_HEAD}    UNI_BSS_ATTACHED=${UNI_BSS_ATTACHED}    UNI_BSS_BODY=${UNI_BSS_BODY}");
		arrayList.add("    "+trim);
		arrayList.add("    ${req}    to json    ${message}    pretty_print=True");
		arrayList.add("    ${resp}    post request    url    "+substringurl+"    ${req}");
		arrayList.add("    ${respdata}    to json    ${resp.text}");
		arrayList.add("    log    ${req}");
		arrayList.add("    log    ${respdata}");
		String kula = "    [Arguments]    ";
		for (Map.Entry<String, String> stringStringEntry : linkedHashMap.entrySet()) {
			String s = stringStringEntry.getKey().trim();
			kula += "${" + s + "}    ";
		}
		try {
			int i = 0;
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(nextFile, "消息报文.txt")), "UTF-8"));
			String line = null;
			for (String s : arrayList) {
				i++;
				if (i == 11) {
					bufferedWriter.write(kula);
					bufferedWriter.newLine();
					bufferedWriter.write(s);
					bufferedWriter.newLine();
				} else {
					bufferedWriter.write(s);
					bufferedWriter.newLine();
				}
			}
			//		TODO 这是截取字符串的业务逻辑，把数据从json串里提出来的业务逻辑
			//		TODO 这里容易造成一个错误,主节点在排序的时候确实是没有错误,但是下面的关键性判断确是依靠fujiedian是否为空来进行排序的,如果在这个时候对结果进行分析,毫无疑问的,这会污染主节点的数据,然后造成错误的判断,导致一系列的BUG
//			这里在之前已经判断过了,这么做的原因是为了避免重复污染,如果父节点有嵌套解析,子节点又嵌套解析,会有不小的问题
			fujiedian.setLength(0);
			zijiedian.setLength(0);
			zijiediantofuqin.clear();
			LinkedHashMultimap<String,String> jieguopaixu = jeiguopaixu(jieguostringBuffer2.toString());
			shuchumappinjie(jieguopaixu,split2,jieguosplit);
			for (String s : jieguoarrayList) {
				bufferedWriter.write(s);
				bufferedWriter.newLine();
			}
//			由于不同的中心返回的结果是不一样的，所以这里不可以直接写死，不然会导致无法通用
			StringBuffer fanhuizhi = new StringBuffer();
			for (Map.Entry<String, String> stringStringEntry : linkedHashMap.entrySet()) {
				String s = stringStringEntry.getKey().trim();
				if (s.contains("DESC")&&!s.equals("RESP_DESC")) {
//					这说明body体里是存在返回值的，但是标志位是不一样的
					String[] fenge = s.split("Cj_");
					if (fenge.length > 1) {
						s = fenge[1];
						s += "&";
						fanhuizhi.append(s);
					}
				}
				if (s.contains("CODE")&&!s.equals("RESP_CODE")) {
					String[] fenge = s.split("Cj_");
					if (fenge.length > 1) {
						s = fenge[1];
						s += "&";
						fanhuizhi.append(s);
					}
				}
			}
			String[] split3 = fanhuizhi.toString().split("&");
			for (String s : split3) {
				bufferedWriter.write("    Should Be Equal As Strings    ${"+s+"}    ${Cj_"+s+"}");
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			System.out.println("文件已经保存到D:\\RobotforJson之下！");
			BufferedWriter bufferedWriterpy = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File((nextFile), wenjianming)), "UTF-8"));
			bufferedWriterpy.write("#-*- coding:utf-8 -*-");
			bufferedWriterpy.newLine();
			for (Map.Entry<String, String> stringStringEntry : linkedHashMap.entrySet()) {
				String s = stringStringEntry.getKey().trim();
				String s1 = stringStringEntry.getValue().trim();
				if (s.equals("sql_url")) {
					bufferedWriterpy.write("#数据库");
					bufferedWriterpy.newLine();
					bufferedWriterpy.write(s + "=" + s1);
					bufferedWriterpy.newLine();
				} else {
					if (s.equals("requestaddress")) {
						bufferedWriterpy.write("#查询接口地址");
						bufferedWriterpy.newLine();
					} else {
						if (s.contains("Cj_")) {
							bufferedWriterpy.write("#报文体返回参数");
							bufferedWriterpy.newLine();
						} else {
							bufferedWriterpy.write("#公共参数");
							bufferedWriterpy.newLine();
						}
					}
					bufferedWriterpy.write(s + "=u'" + s1+"'");
					bufferedWriterpy.newLine();
				}
				System.out.println(stringStringEntry.getKey()+"值是"+stringStringEntry.getValue());
			}
			bufferedWriterpy.close();
//			这里对测试用例的test里面的用例脚本进行操作swen
			BufferedWriter textwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(nextFile, wenjiantxt)), "UTF-8"));
			textwriter.write("*** Settings ***");
			textwriter.newLine();
			textwriter.write("Library           Selenium2Library");
			textwriter.newLine();
			textwriter.write("Library           requests");
			textwriter.newLine();
			textwriter.write("Resource          消息报文.txt");
			textwriter.newLine();
			textwriter.write("Resource          预置条件.txt");
			textwriter.newLine();
			textwriter.newLine();
			textwriter.write("*** Test Cases ***");
			textwriter.newLine();
			textwriter.write(swen+"-正常查询");
			textwriter.newLine();
			String biaozhiwei = "";
			for (Map.Entry<String, String> stringStringEntry : linkedHashMap.entrySet()) {
				String s = stringStringEntry.getKey().trim();
				if (!s.contains("Cj_")) {
					biaozhiwei += "${" + s + "}    ";
				}
			}
			textwriter.write("    prepare_case001    ${sql_url}");
			textwriter.newLine();
			textwriter.write("    message_002    "+biaozhiwei);
			textwriter.close();
			BufferedWriter textwriteryichang = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(nextFile, wenjiantxts)), "UTF-8"));
			textwriteryichang.write("*** Settings ***");
			textwriteryichang.newLine();
			textwriteryichang.write("Library           Selenium2Library");
			textwriteryichang.newLine();
			textwriteryichang.write("Library           requests");
			textwriteryichang.newLine();
			textwriteryichang.write("Resource          消息报文.txt");
			textwriteryichang.newLine();
			textwriteryichang.write("Resource          预置条件.txt");
			textwriteryichang.newLine();
			textwriteryichang.newLine();
			textwriteryichang.write("*** Test Cases ***");
			textwriteryichang.newLine();
			textwriteryichang.write(swen+"-异常用例");
			textwriteryichang.newLine();
			textwriteryichang.write("    message_001    "+biaozhiwei);
			textwriteryichang.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter yuzhitiaojian = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(nextFile, "预置条件.txt")), "UTF-8"));
		yuzhitiaojian.write("*** Settings ***");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("Library           DatabaseLibrary");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("Library           Selenium2Library");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("Library           requests");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("Library           RequestsLibrary");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("Library           Collections");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("*** Keywords ***");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("prepare_case001");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("    [Arguments]    ${sql_url}");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("    Connect To Database Using Custom Params    pymysql    ${sql_url}");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("    ${count}    query    ?");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("    log    ${count}");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("    Disconnect From Database");
		yuzhitiaojian.newLine();
		yuzhitiaojian.write("    [Return]    ${count}");
		yuzhitiaojian.newLine();
		yuzhitiaojian.close();
		BufferedWriter luodishuju = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(nextFile, "落地数据.txt")), "UTF-8"));
		luodishuju.write("*** Settings ***");
		luodishuju.newLine();
		luodishuju.write("Library           DatabaseLibrary");
		luodishuju.newLine();
		luodishuju.write("Library           Selenium2Library");
		luodishuju.newLine();
		luodishuju.write("Library           requests");
		luodishuju.newLine();
		luodishuju.write("Library           RequestsLibrary");
		luodishuju.newLine();
		luodishuju.write("Library           Collections");
		luodishuju.newLine();
		luodishuju.write("*** Keywords ***");
		luodishuju.newLine();
		luodishuju.write("prepare_case002");
		luodishuju.newLine();
		luodishuju.write("    [Arguments]    ${sql_url}");
		luodishuju.newLine();
		luodishuju.write("    Connect To Database Using Custom Params    pymysql    ${sql_url}");
		luodishuju.newLine();
		luodishuju.write("    ${count}    query    ?");
		luodishuju.newLine();
		luodishuju.write("    log    ${count}");
		luodishuju.newLine();
		luodishuju.write("    Disconnect From Database");
		luodishuju.newLine();
		luodishuju.write("    [Return]    ${count}");
		luodishuju.newLine();
		luodishuju.close();
	}


	private static void shuchumappinjie(LinkedHashMultimap<String, String> qiantao, String[] split2, String[] jieguosplit) {
//		其中qiantao代表具体的嵌套关系，split2代表具体的值&，jieguosplit代表头结点信息
		Set<Map.Entry<String, String>> entries = qiantao.entries();
		StringBuffer toujiedian = new StringBuffer();
		String key = "";
		for (Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + "---------------" + entry.getValue());
			if (key.equals("")) {
				key = entry.getValue();
			}
//			首先，判断当前节点是否是头结点
			boolean flag = false;
			for (String s : jieguosplit) {
				if (entry.getKey().trim().equals(s.trim())) {
					flag = true;
				}
			}
			boolean shuzu = false;
			if (flag) {
//				由于有的节点不包含嵌套关系，所以这里需要记录下已经获取到的头结点信息，否则会造成消息丢失
				String tou = "    ${" + entry.getKey().trim() + "}    Get From Dictionary    ${respdata}    " + entry.getKey().trim();
				jieguoarrayList.add(tou);
				toujiedian.append(entry.getKey()+"&");
//				判断完头结点之后，要对value进行处理
				String wei ="    ${" + entry.getValue().trim() + "}    Get From Dictionary    ${"+entry.getKey().trim()+"}    " + entry.getValue().trim();
				jieguoarrayList.add(wei);
			} else {
				if (entry.getKey().trim().equals(key.trim())) {
//					这么做的目的在于，判断当前的节点，是否归属于上一个节点的子节点，如果是，那么当前节点肯定被上一个节点嵌套
					// 实际上，key代表的是前一个节点，所以前一个节点的value，要等于当前节点的key才可以认为是嵌套
					String wei ="    ${" + entry.getValue().trim() + "}    Get From Dictionary    ${"+entry.getKey().trim()+"}    " + entry.getValue().trim();
					jieguoarrayList.add(wei);
//					这里有必要判断一下当前节点是否是一个数组，如果当前节点的key是一个数组的话，我就可以根据数组来进行进一步的分析
					String[] array = jieguostringBuffer3.toString().split("数组是");
					for (String str : array) {
						if (entry.getValue().trim().equals(str.trim())) {
//					TODO 这是一个数组
//					这里对数组单独进行操作
							shuzu = true;
						}
					}
					if (shuzu) {
						String kb = "    ${L_" + entry.getValue().trim() + "}    Get From List    ${" + entry.getValue().trim() + "}    0";
						jieguoarrayList.add(kb);
					}
				}
			}
			for (String s1 : split2) {
				if (s1.contains(entry.getValue().trim())) {
//					TODO 这里较为的纠结了，从结果里取值，如果没有，那么这个值很有可能是节点嵌套，这里虽然通过父亲是赋值，但是不能忽略节点嵌套节点的情况
					int i1 = s1.lastIndexOf("父");
					String substring = s1.substring(0, i1);
					String[] split10 = substring.split("=");
					if (split10.length < 2) {
//						如果长度小于2，说明等号那边没有值，正常输出即可
					} else {
						if (shuzu) {
//							如果包含，说明这是数组下的一个值，不包含说明在map下
							String fk = "    ${" + split10[0].trim() + "}    Get From Dictionary    ${L_" + entry.getValue().trim() + "}    " + split10[0].trim();
							jieguoarrayList.add(fk);
						} else {
							String fks="    ${" + split10[0].trim() + "}    Get From Dictionary    ${" + entry.getValue() + "}    " + split10[0].trim();
							jieguoarrayList.add(fks);
						}
						linkedHashMap.put("Cj_"+split10[0], split10[1]);
					}
				}
			}
			key = entry.getValue();
		}
		String[] split = toujiedian.toString().split("&");
		boolean tou = false;
		for (String s : jieguosplit) {
			for (String s5 : split) {
				if (s.trim().equals(s5.trim())) {
					tou = true;
				}
			}
			if (tou) {
				System.out.println("该节点已经被包含，不用做特殊处理！");
			} else {
				System.out.println("该节点没有被包含，需要做特殊处理的头结点！");
				String tous = "    ${" + s.trim() + "}    Get From Dictionary    ${respdata}    " + s.trim();
				jieguoarrayList.add(tous);
//				判断完头结点之后，要对该节点进行处理
				for (String s1 : split2) {
					if (s1.contains(s.trim())) {
//					TODO 这里较为的纠结了，从结果里取值，如果没有，那么这个值很有可能是节点嵌套，这里虽然通过父亲是赋值，但是不能忽略节点嵌套节点的情况
						int i1 = s1.lastIndexOf("父");
						String substring = s1.substring(0, i1);
						String[] split10 = substring.split("=");
						if (split10.length < 2) {
//						如果长度小于2，说明等号那边没有值，正常输出即可
						} else {
							boolean shuzu = false;
							String[] array = jieguostringBuffer3.toString().split("数组是");
							for (String str : array) {
								if (s.equals(str.trim())) {
//					TODO 这是一个数组
//					这里对数组单独进行操作
									shuzu = true;
								}
							}
							if (shuzu) {
//							如果包含，说明这是数组下的一个值，不包含说明在map下
								String fk = "    ${" + split10[0].trim() + "}    Get From Dictionary    ${L_" + s.trim() + "}    " + split10[0].trim();
								jieguoarrayList.add(fk);
							} else {
								String fks="    ${" + split10[0].trim() + "}    Get From Dictionary    ${" + s.trim() + "}    " + split10[0].trim();
								jieguoarrayList.add(fks);
							}
							linkedHashMap.put("Cj_"+split10[0], split10[1]);
						}
					}
				}
			}
			tou = false;
		}
	}
	private static void pinjie(LinkedHashMultimap<String, String> paixu, String[] split1, String[] split) {
//		TODO 正片开始,paixu是嵌套数，里面存储的是嵌套节点，而split1是值，split存储的则是头结点的信息
//		TODO 这里是较为尴尬的，如果是头结点，那么在循环遍历完成之后比对下就可以了，空的就一定是没遍历到的节点
		StringBuffer toujiedianyinyong=new StringBuffer();
		Collection<Map.Entry<String, String>> entries = paixu.entries();
		String key = "";
		StringBuffer pinjie = new StringBuffer();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + "============" + entry.getValue());
			if (key.equals("")) {
				key = entry.getKey();
			}
				boolean equals = key.trim().equals(entry.getKey().trim());
				if (equals) {
//					如果这个值等于当前的key,说明这个key下面有多个元素，是一个平级的节点
					pinjie.append("    ${" + entry.getValue().trim() + "}    Create Dictionary    ");
					bianli(split1, pinjie, entry);
				} else {
//					这里为了保险起见，对其进行了判断,如果key是后一个节点的value,那么说明这个key嵌套这个value,是嵌套关系，否则这个节点跟上一个节点毫无关系
//					TODO 这里需要注意的是，一切都是围绕key来进行判断的，如果程序能走到这里，那么一定遍历到后一个节点，而不是当前节点
					if (key.trim().equals(entry.getValue().trim())) {
//						如果当前的key是下一个节点的value,那么则说明当前节点是被下一个节点嵌套的，既然是嵌套的，就必然包含下一个节点的值，而且还需要判断是否是数组，下午再写，不过值还是需要遍历一下的，不过这里需要注意的是，要遍历子节点下所有的值，并查看当前节点是否被嵌套
						pinjie.append("    ${" + entry.getValue().trim() + "}    Create Dictionary    ");
						Collection<String> a = paixu.get(key);
						boolean shuzu = false;
						for (String s : a) {
							System.out.println(s);
//							实际上，这里并不需要拼接，还需要判断是否是数组
							String[] array = stringBuffer3.toString().split("数组是");
							for (String s1 : array) {
								if (s1.trim().equals(s.trim())) {
//									如果是这样则说明当前值是数组
									shuzu = true;
								}
							}
							if (shuzu) {
//								如果是数组，那么直接拼接数组就好了
//								${UNI_BSS_HEAD}    Create Dictionary    RESERVED=@{RESERVED}
								pinjie.append(s.trim() + "=" + "@{" + s.trim() + "}" + "    ");
							} else {
								pinjie.append(s.trim() + "=" + "${" + s.trim() + "}" + "    ");
							}
							shuzu = false;
						}
//						这里需要考虑节点嵌套节点的情况，不过我想节点嵌套解决了，那么这个值该会是什么呢
						bianli(split1, pinjie, entry);
						boolean toujiedian = false;
						for (String s : split) {
							if (entry.getKey().trim().equals(s.trim())) {
								toujiedian = true;
							}
						}
						if (toujiedian) {
							toujiedianyinyong.append(entry.getKey() + "&");
							toujiedianchuli(paixu, split1, entry.getKey(), pinjie);
						}
					} else {
//						如果不是嵌套关系，判断是否是头结点，如果不是头结点，则打印这个值
						boolean toujiedian = false;
						for (String s : split) {
							if (key.trim().equals(s.trim())) {
								toujiedian = true;
							}
						}
						if (toujiedian) {
							toujiedianyinyong.append(key + "&");
							toujiedianchuli(paixu, split1, key, pinjie);
						} else {
							System.out.println("key" + key + entry.getKey() + "??????" + entry.getValue());
						}
						//实际上，你遍历了上一个节点，而这个节点确实不等于上一个节点，但是当前节点并没有被处理，导致了数据的丢失，这是需要注意的事情
//							那么这个节点也是需要遍历的，遍历了这个节点才有可能继续向下进行下去
						pinjie.append("    ${" + entry.getValue().trim() + "}    Create Dictionary    ");
						bianli(split1, pinjie, entry);
					}
				}
//			TODO 这里记录了key的值，因为循环是向前移动的，所以key的值也在不断的更新，实际上，key始终代表前一个节点的key
			key = entry.getKey();
		}
//		遍历完成之后判断是否有漏掉的头结点
		String[] split2 = toujiedianyinyong.toString().split("&");
		boolean flag = false;
		for (String s : split) {
			for (String s1 : split2) {
				if (s1.trim().equals(s.trim())) {
					flag = true;
				}
			}
			if (flag) {
				System.out.println("元素被包含，无需处理");
			} else {
//					如果不想等，则说明当前节点不等于头结点，也就是有缺省的头结点没有被录入，由于s1一定是子集，所以要获取s的值
					System.out.println("头结点" + s + "没有嵌套关系，是最外层的元素，需要单独处理");
//				TODO 这里单独处理就好了，先搁浅
					jieguo.append("    ${" + s + "}    Create Dictionary    ");
					String king = "    ${" + s + "}    Create Dictionary    ";
					String full = "    ${" + s + "}    Create Dictionary    ";
				//					TODO 这里涉及到一个棘手的问题，能进入到这里的节点肯定是漏掉的，应该先判断是否有子元素
				int size = paixu.get(s).size();
				Set<String> strings = paixu.get(s);
				if (size >= 1) {
//					说明这是有子节点的
					for (String string : strings) {
						king += string.trim() + "=" + "${" + string + "}    ";
					}
				}
//				arrayList.add("    ${" + s + "}    Create Dictionary    ");
//				这里根据头结点来查询结果就好了
//				TODO不过这里为了防止空值，还需要额外的处理，不过需要在写入文件里处理就好了
					for (String s1 : split1) {
						if (s1.contains(s.trim())) {
							int i1 = s1.lastIndexOf("父");
							String substring = s1.substring(0, i1);
							substring = substring.trim();
//						这里开始对值进行一个特殊的处理
							String[] split10 = substring.split("=");
							if (split10.length < 2) {
//						如果长度小于2，说明等号那边没有值，正常输出即可
							} else {
								substring = split10[0];
								if (split10[1].contains(":")) {
									//					TODO 这里由于时间类型，所以需要对时间进行强化，不然时间会无法解析
									substring += "=" + timezhuanhuan(split10[1]);
									String[] split5 = substring.split("=");
									substring = split5[0];
									substring += "=${" + split5[0] + "}";
									linkedHashMap.put(split5[0], split5[1]);
								} else {
									substring += "=${" + split10[0] + "}";
									linkedHashMap.put(split10[0], split10[1]);
								}
							}
//					TODO 这里由于原先就是错误的类型，所以要灵活判断，split1存储的是值
							substring = substring.trim();
							jieguo.append(substring + "    ");
							king += substring + "    ";
						}
					}
					if (!full.equals(king)) {
						arrayList.add(king);
					}
			}
			flag = false;
		}
	}

	private static void toujiedianchuli(LinkedHashMultimap<String, String> paixu, String[] split1, String key, StringBuffer pinjie) {
		pinjie.append("    ${" + key.trim() + "}    Create Dictionary    ");
		Collection<String> a = paixu.get(key);
		boolean shuzu = false;
		for (String s : a) {
			System.out.println(s);
//							实际上，这里并不需要拼接，还需要判断是否是数组
			String[] array = stringBuffer3.toString().split("数组是");
			for (String s1 : array) {
				if (s1.trim().equals(s.trim())) {
//									如果是这样则说明当前值是数组
					shuzu = true;
				}
			}
			if (shuzu) {
//								如果是数组，那么直接拼接数组就好了
//								${UNI_BSS_HEAD}    Create Dictionary    RESERVED=@{RESERVED}
				pinjie.append(s.trim() + "=" + "@{" + s.trim() + "}" + "    ");
			} else {
				pinjie.append(s.trim() + "=" + "${" + s.trim() + "}" + "    ");
			}
			shuzu = false;
		}
		for (String s1 : split1) {
			if (s1.contains(key.trim())) {
//					TODO 这里较为的纠结了，从结果里取值，如果没有，那么这个值很有可能是节点嵌套，这里虽然通过父亲是赋值，但是不能忽略节点嵌套节点的情况
				int i1 = s1.lastIndexOf("父");
				String substring = s1.substring(0, i1);
				String[] split10 = substring.split("=");
				if (split10.length < 2) {
//						如果长度小于2，说明等号那边没有值，正常输出即可
				} else {
					substring = split10[0];
					if (split10[1].contains(":")) {
						//					TODO 这里由于时间类型，所以需要对时间进行强化，不然时间会无法解析
						substring += "=" + timezhuanhuan(split10[1]);
						String[] split5 = substring.split("=");
						substring = split5[0];
						substring += "=${" + split5[0] + "}";
						linkedHashMap.put(split5[0], split5[1]);
					} else {
						substring += "=${" + split10[0] + "}";
						linkedHashMap.put(split10[0], split10[1]);
					}
				}
				jieguo.append(substring + "    ");
				pinjie.append(substring + "    ");
			}
		}
		arrayList.add(pinjie.toString());
		pinjie.setLength(0);
	}

	private static void bianli(String[] split1, StringBuffer pinjie, Map.Entry<String, String> entry) {
		for (String s1 : split1) {
			boolean shuzu = false;
			if (s1.contains(entry.getValue().trim())) {
//					TODO 这里较为的纠结了，从结果里取值，如果没有，那么这个值很有可能是节点嵌套，这里虽然通过父亲是赋值，但是不能忽略节点嵌套节点的情况
				int i1 = s1.lastIndexOf("父");
				String substring = s1.substring(0, i1);
				String[] split10 = substring.split("=");
				if (split10.length < 2) {
//						如果长度小于2，说明等号那边没有值，正常输出即可
				} else {
					substring = split10[0];
					if (split10[1].contains(":")) {
						//					TODO 这里由于时间类型，所以需要对时间进行强化，不然时间会无法解析
						substring += "=" + timezhuanhuan(split10[1]);
						String[] split5 = substring.split("=");
						substring = split5[0];
						substring += "=${" + split5[0] + "}";
						linkedHashMap.put(split5[0], split5[1]);
					} else {
						substring += "=${" + split10[0] + "}";
						linkedHashMap.put(split10[0], split10[1]);
					}
				}
				jieguo.append(substring + "    ");
				pinjie.append(substring + "    ");
			}
		}
		arrayList.add(pinjie.toString());
		boolean dangqianjiedianshuzu = false;
		String[] array = stringBuffer3.toString().split("数组是");
		for (String s1 : array) {
			if (s1.trim().equals(entry.getValue().trim())) {
//									如果是这样则说明当前值是数组
				dangqianjiedianshuzu = true;
			}
		}
		if (dangqianjiedianshuzu) {
			arrayList.add("    @{" + entry.getValue().trim() + "}    Create List    " + "${" + entry.getValue().trim() + "}");
		}
//		TODO 这里需要考虑特殊情况
		pinjie.setLength(0);
	}
	private static void jsonzh(JSONObject jsonObject) {
		for (Map.Entry<String, Object> stringObjectEntry : jsonObject.entrySet()) {
			String key = stringObjectEntry.getKey();
			String value =  stringObjectEntry.getValue().toString();
			try {
				if (stringObjectEntry.getValue().toString().contains("{")) {
					stringBuffer4.append(key+" ");
//					System.out.println(stringObjectEntry.getValue() + "的父亲是" + stringObjectEntry.getKey());
//					TODO 实际上，这里就较为的复杂了，取出值并不难，但是逻辑却难得离谱啊。。。。
//					这里在解析的时候，最外层元素应该是没有问题的，但是在处理结果的时候，容易有问题，因为一个map可以嵌套多个map<代表平级，>代表嵌套
					if (stringObjectEntry.getValue().toString().startsWith("[{")) {
//						TODO 这里不能强转成jsonobject,因为这是一个jsonarry数组
//						虽然成功的解析出了数组里的值，但是这里仍然需要注意，因为在变成代码的时候，还是需要修改的
						JSONArray jsonArray = jsonObject.getJSONArray(key);
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject jsonObject1 = jsonArray.getJSONObject(i);
							qiantao(jsonObject1,key);
						}
					}
					qiantao(jsonObject.getJSONObject((String) stringObjectEntry.getKey()), (String) stringObjectEntry.getKey());
				} else {
					//					TODO 这个json没有父亲，是最外围的变量
//					实际上，这里记录的都是最外围的变量，从外往里解析，所以这里不需要考虑嵌套的问题，直接拼接即可
//					TODO 这里记录一个BUG,有的值可以解析，有的值却无法解析，有的json值能取到，有的json值却取不到，较为复杂
					stringBuffer.append(key + "=" + value+"&");
//					System.out.println("这个json没有父亲，是最外围的变量");
//					TODO 实际上这里如果没有被解析就很有可能是数组格式的了，还需要进一步的判断
//					jsonzh(jsonObject.getJSONObject((String) stringObjectEntry.getKey()));
				}
			} catch (Exception e) {
			}
		}
	}
	private static void jieguojsonzh(JSONObject jsonObject) {
		for (Map.Entry<String, Object> stringObjectEntry : jsonObject.entrySet()) {
			String key = stringObjectEntry.getKey();
			String value =  stringObjectEntry.getValue().toString();
			try {
				if (stringObjectEntry.getValue().toString().contains("{")) {
//					TODO 这里存储了头结点的信息
					jieguostringBuffer4.append(key+" ");
//					System.out.println(stringObjectEntry.getValue() + "的父亲是" + stringObjectEntry.getKey());
//					TODO 实际上，这里就较为的复杂了，取出值并不难，但是逻辑却难得离谱啊。。。。
					if (stringObjectEntry.getValue().toString().startsWith("[{")) {
//						TODO 这里不能强转成jsonobject,因为这是一个jsonarry数组
//						虽然成功的解析出了数组里的值，但是这里仍然需要注意，因为在变成代码的时候，还是需要修改的
						JSONArray jsonArray = jsonObject.getJSONArray(key);
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject jsonObject1 = jsonArray.getJSONObject(i);
							jieguoqiantao(jsonObject1,key);
						}
					}
					jieguoqiantao(jsonObject.getJSONObject((String) stringObjectEntry.getKey()), (String) stringObjectEntry.getKey());
				} else {
					//					TODO 这个json没有父亲，是最外围的变量
//					实际上，这里记录的都是最外围的变量，从外往里解析，所以这里不需要考虑嵌套的问题，直接拼接即可
//					TODO 这里记录一个BUG,有的值可以解析，有的值却无法解析，有的json值能取到，有的json值却取不到，较为复杂
					jieguostringBuffer.append(key + "=" + value+"&");
//					System.out.println("这个json没有父亲，是最外围的变量");
//					TODO 实际上这里如果没有被解析就很有可能是数组格式的了，还需要进一步的判断
//					jsonzh(jsonObject.getJSONObject((String) stringObjectEntry.getKey()));
				}
			} catch (Exception e) {
			}
		}
	}
	private static void jieguoqiantao(JSONObject jsonObject,String ming) {
		for (Map.Entry<String, Object> stringObjectEntry : jsonObject.entrySet()) {
			String key = stringObjectEntry.getKey();
			String value =  stringObjectEntry.getValue().toString();
			try {
				if (stringObjectEntry.getValue().toString().contains("{")) {
					//			TODO 这么做的目的在于表明嵌套关系，谁是谁的父亲
					jieguostringBuffer2.append(ming+">"+key+" ");
					//TODO 在这里我处理代码，并对结果进行一个封装
//					TODO 实际上，这里就较为的复杂了，这是为了处理多层嵌套的情况
					if (stringObjectEntry.getValue().toString().startsWith("[{")) {
//						TODO 这里不能强转成jsonobject,因为这是一个jsonarry数组
						jieguostringBuffer3.append("数组是"+key);
						JSONArray jsonArray = jsonObject.getJSONArray(key);
//						虽然已经被表示成嵌套object
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject jsonObject1 = jsonArray.getJSONObject(i);
							jieguoqiantao(jsonObject1,key);
						}
					}
//					TODO 这里是比较让我困惑的，本来应该重复调用的方法居然会走到这里，不过BUG不做处理，数据正常解析就好
					jieguoqiantao(jsonObject.getJSONObject((String) stringObjectEntry.getKey()), (String) stringObjectEntry.getKey());
				} else {
//					TODO 这里应该进行array转换，如果不能转换就一定是MAP，谨记
//					TODO 这里的用意在于，这里表示的是json嵌套里的键值对，也是需要记录的，而嵌套的键值对，通过ming标志位来进行区分，并表明嵌套关系
					//					TODO 同样的，这里我仍然用stringbuffer来装值
					jieguostringBuffer.append(key + "=" + value+"父亲是"+ming+"&");
				}
			} catch (Exception e) {
			}
		}
	}
	private static void qiantao(JSONObject jsonObject,String ming) {
		for (Map.Entry<String, Object> stringObjectEntry : jsonObject.entrySet()) {
			String key = stringObjectEntry.getKey();
			String value =  stringObjectEntry.getValue().toString();
			try {
				if (stringObjectEntry.getValue().toString().contains("{")) {
					//			TODO 这么做的目的在于表明嵌套关系，谁是谁的父亲
					stringBuffer2.append(ming.trim()+">"+key.trim()+" ");
					//TODO 在这里我处理代码，并对结果进行一个封装
					// 然而麻烦的事情是一个map可以嵌套多个map,一个list下面也可以嵌套多个MAP，这里应该先处理map嵌套多个map的奇葩情况，mmp了
//					TODO 实际上，这里就较为的复杂了，这是为了处理多层嵌套的情况
					if (stringObjectEntry.getValue().toString().startsWith("[{")) {
//						TODO 这里不能强转成jsonobject,因为这是一个jsonarry数组
						stringBuffer3.append("数组是"+key);
						JSONArray jsonArray = jsonObject.getJSONArray(key);
//						虽然已经被表示成嵌套object
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject jsonObject1 = jsonArray.getJSONObject(i);
							qiantao(jsonObject1,key);
						}
					}
//					TODO 这里是if循环里的数据，要重复解析
					qiantao(jsonObject.getJSONObject((String) stringObjectEntry.getKey()), (String) stringObjectEntry.getKey());
				} else {
//					TODO 这里应该进行array转换，如果不能转换就一定是MAP，谨记
//					TODO 这里的用意在于，这里表示的是json嵌套里的键值对，也是需要记录的，而嵌套的键值对，通过ming标志位来进行区分，并表明嵌套关系
					//					TODO 同样的，这里我仍然用stringbuffer来装值
					stringBuffer.append(key + "=" + value+"父亲是"+ming+"&");
				}
			} catch (Exception e) {
			}
		}
	}
	private static LinkedHashMultimap paixu(String s) {
//		TODO 这里一个Map可以映射到多个值，所以这里不能用linkedhashmap,要利用guava类库
//		LinkedHashMap<String,String> strings = new LinkedHashMap<>();
		LinkedHashMultimap<String,String> paixustrings = LinkedHashMultimap.create();
		String[] split = s.split(" ");
		for (int i = split.length - 1; i >= 0; i--) {
			int j = split[i].lastIndexOf(">");
			String substring = split[i].substring(0, j);
			String substring1 = split[i].substring(j + 1, split[i].length());
			paixustrings.put(substring, substring1);
		}
		return paixustrings;
	}
	private static LinkedHashMultimap jeiguopaixu(String s) {
//		TODO 这里一个Map可以映射到多个值，所以这里不能用linkedhashmap,要利用guava类库
//		LinkedHashMap<String,String> strings = new LinkedHashMap<>();
		LinkedHashMultimap<String,String> paixustrings = LinkedHashMultimap.create();
		String[] split = s.split(" ");
		for (int i = 0; i <split.length; i++) {
			int j = split[i].lastIndexOf(">");
			String substring = split[i].substring(0, j);
			String substring1 = split[i].substring(j + 1, split[i].length());
			paixustrings.put(substring, substring1);
		}
		return paixustrings;
	}
	private static String timezhuanhuan(String str) {
		StringBuffer stringBuffer = new StringBuffer();
		if (!str.contains(".")) {
//			"TIMESTAMP": "2018-05-26 11:25:17 586", 这里对这种类型进行了操作，因为去掉了空格，所以要补上
			int characterPosition = getCharacterPosition(str.toString(), 1);
			int k = characterPosition - 2;
			StringBuffer insert = stringBuffer.append(str).insert(k, " ");
			String string = insert.toString();
			int characterPositions = getCharacterPosition(string, 2);
			int j = characterPositions + 2;
			stringBuffer.insert(j + 1, " ");
			String string1 = stringBuffer.toString();
			string1 += "  ";
			System.out.println(string1);
			return string1;
		} else {
//			"TIMESTAMP": "2018-07-12 16:19:27.666",这里对时间类型进行了特殊的解析操作，如果包含.就进行这个操作
			int characterPosition = getCharacterPosition(str.toString(), 1);
			int k = characterPosition - 2;
			StringBuffer insert = stringBuffer.append(str).insert(k, " ");
			String string = insert.toString();
			return string;
		}
	}
	public static int getCharacterPosition(String string,int i){
//		判断一个字符第几次出现
		//这里是获取":"符号的位置
		Matcher slashMatcher = Pattern.compile(":").matcher(string);
		int mIdx = 0;
		while(slashMatcher.find()) {
			mIdx++;
			//当"/"符号第三次出现的位置
			if(mIdx == i){
				break;
			}
		}
		return slashMatcher.start();
	}
//	读取指定配置文件
	/**
	 * 基于输入流读取属性文件：Properties继承了Hashtable，底层将key/value键值对存储在集合中，
	 * 通过put方法可以向集合中添加键值对或者修改key对应的value
	 *
	 * @throws IOException
	 */
	public static void test01() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\connsql.properties");
		Properties props = new Properties();
		props.load(new InputStreamReader(fis, "utf-8"));// 将文件的全部内容读取到内存中，输入流到达结尾
		fis.close();// 加载完毕，就不再使用输入流，程序未主动关闭，需要手动关闭
		System.out.println("配置文件中一共有" + props.size() + "条！");
		int size = props.size();
		Scanner shuru = new Scanner(System.in);
		FileOutputStream oFile = new FileOutputStream("D:\\connsql.properties", true);
		if (size == 0) {
//			如果是0则说明配置文件里没有数据，需要手动输入数据
			System.out.println("该配置文件里没有数据，需要手动输入数据！");
			System.out.println("请输入要链接数据库的名字！以及具体归属于那个中心！数据库名建议不要输入相同的！例:清算中心_查询接口");
			String s = shuru.nextLine();
			System.out.println("请输入要链接数据库对应的URL！建议从别的PY文件中直接拖过来，双引号全部拖过来，避免出错");
			Scanner king = new Scanner(System.in);
			System.out.println("该url将被记录到connsql.properties文件中！");
			String url = king.nextLine();
			props.put(s, url);
			System.out.println(s + "=" + url);
			props.store(new OutputStreamWriter(oFile, "utf-8"), "db配置");
			linkedHashMap.put("sql_url", url);
		} else {
//			如果配置文件中有数据，则遍历之前的数据，如果数据不存在，在重新输入记录即可
			System.out.println("遍历属性文件");
			Enumeration keys = props.propertyNames();
			LinkedHashMultimap<Integer, String> linkedHashMultimap = LinkedHashMultimap.create();
			int xuhao = 0;
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				System.out.println(xuhao + "    " + key + "           " + props.getProperty(key));
				linkedHashMultimap.put(xuhao, props.getProperty(key));
				xuhao++;
			}
			System.out.println("请选择一个序号，这个序号对应的url将被写入到Py文件中！如果没有对应的URL，则输入一个不存在的序号！");
			System.out.println("如果不小心输入了错误的数据，请到D:\\connsql.properties下手动进行更改！如果打开文件乱码，请务必切换到UTF-8编码！");
			int i = shuru.nextInt();
			Set<Map.Entry<Integer, String>> entries = linkedHashMultimap.entries();
			boolean flag = true;
			for (Map.Entry<Integer, String> entry : entries) {
				if (entry.getKey().intValue() == i) {
//					如果相等，则把该序号对应的URL写入
					linkedHashMap.put("sql_url", entry.getValue());
					flag = false;
				}
			}
			if (flag) {
//			如果到这里则说明没有符合要求的序号，那么需要重新输入！
				System.out.println("请输入要链接数据库的名字！以及具体归属于那个中心！数据库名建议不要输入相同的！例:清算中心_查询接口");
				Scanner kula = new Scanner(System.in);
				String s = kula.nextLine();
				System.out.println("请输入要链接数据库对应的URL！建议从别的PY文件中直接拖过来，双引号也要全部拖过来，避免出错");
				Scanner king = new Scanner(System.in);
				System.out.println("该url将被记录到connsql.properties文件中！");
				String url = king.nextLine();
				props.put(s, url);
				System.out.println(s + "=" + url);
				props.store(new OutputStreamWriter(oFile, "utf-8"), "db配置");
				linkedHashMap.put("sql_url", url);
			}
		}
		oFile.close();
	}
	}

