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
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        Transferable trandata = new StringSelection("4654654");
        clipboard.setContents(trandata, null);

    }

}
