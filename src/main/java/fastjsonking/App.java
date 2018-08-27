package fastjsonking;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        FileInputStream fis = new FileInputStream("D:\\connsql.properties");
        Properties props = new Properties();
        props.load(new InputStreamReader(fis, "utf-8"));// 将文件的全部内容读取到内存中，输入流到达结尾
        fis.close();// 加载完毕，就不再使用输入流，程序未主动关闭，需要手动关闭

        /*byte[] buf = new byte[1024];
        int length = fis.read(buf);
        System.out.println("content=" + new String(buf, 0, length));//抛出StringIndexOutOfBoundsException*/
//
//        System.out.println("serverTimezone=" + props.getProperty("serverTimezone"));
//        System.out.println("url=" + props.getProperty("jdbc.url"));
//        System.out.println("username=" + props.getProperty("jdbc.username"));
//        System.out.println("password=" + props.getProperty("jdbc.password"));
//
//        /**
//         * Properties其他可能用到的方法
//         */
//        props.put("serverTimezone", "UTC");// 底层通过hashtable.put(key,value)
//        props.put("jdbc.password", "456");
//        props.store(new FileOutputStream("D:\\connsql.properties", true), "db配置");
//        FileOutputStream fos = new FileOutputStream("D:\\connsql.properties");// 将Hashtable中的数据写入xml文件中
//        props.storeToXML(fos, "来自属性文件的数据库连接四要素");

        System.out.println();
        System.out.println("遍历属性文件");
        System.out.println("hashtable中键值对数目=" + props.size());
        Enumeration keys = props.propertyNames();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            System.out.println(key + "=" + props.getProperty(key));
        }
        props.put("清算中心", "123321");
        FileOutputStream oFile = new FileOutputStream("D:\\connsql.properties", true);
        props.store(new OutputStreamWriter(oFile, "utf-8"), "lll");
    }

}
