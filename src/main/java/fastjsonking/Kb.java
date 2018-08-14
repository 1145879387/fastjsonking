package fastjsonking;

import jdk.nashorn.internal.ir.Flags;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 2018/7/12 on 15:44.
 * Created by 常江 on 2017/5/31.
 */
public class Kb {
	public static void main(String[] args) throws IOException {
		String str = "2018-05-2611:25:17586";
		String strs = "2018-05-26 11:25:17 586  ";
		timezhuanhuan(str);

	}

	private static String timezhuanhuan(String str) {
		StringBuffer stringBuffer = new StringBuffer();
		int characterPosition = getCharacterPosition(str.toString(),1);
		int k = characterPosition - 2;
		StringBuffer insert = stringBuffer.append(str).insert(k, " ");
		String string = insert.toString();
		int characterPositions = getCharacterPosition(string, 2);
		int j = characterPositions + 2;
		stringBuffer.insert(j+1," ");
		String string1 = stringBuffer.toString();
		string1 += "  ";
		System.out.println(string1);
		return string1;
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
}
