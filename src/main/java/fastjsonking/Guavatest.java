package fastjsonking;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by 2018/7/24 on 9:30.
 * Created by 常江 on 2017/5/31.
 */
public class Guavatest {
	public static void main(String[] args) {
		String s = "UNI_BSS_BODY>QRY_COMM_PUBLISH_REQ QRY_COMM_PUBLISH_REQ>REQ_HEAD QRY_COMM_PUBLISH_REQ>REQ_BODY UNI_BSS_HEAD>RESERVED";
		Multimap<String, String> multimap = LinkedHashMultimap.create();
		String[] split = s.split(" ");
		for (String s1 : split) {
//			TODO 毫无疑问的，这里记录的是最原始的键值对，我可以取出所有的元素，如果有重复的元素，我就认为，他是一个平级的map，然后差别处理
			int i = s1.lastIndexOf(">");
			String substring = s1.substring(0, i);
			String substring1 = s1.substring(i+1, s1.length());
			multimap.put(substring, substring1);
		}
		Collection<Map.Entry<String, String>> entries = multimap.entries();
		for (Map.Entry<String, String> entry : entries) {
			String key = entry.getKey();
			int size = multimap.get(key).size();
			System.out.println(key+"============"+entry.getValue());
		}
//		Collection<String> a = multimap.get("a");
//		for (String s : a) {
//			System.out.println(s);
//		}
	}
}
