package top.ibase4j.core.util;

import org.junit.Test;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Created by HH on 2018-06-11.
 */
public class HttpUtilTest {
    @Test
    public void httpClientPost() throws Exception {
        Map params = new HashMap();
        params.put("accesskey","sOZx33BSF7UW5GdI");
        params.put("sign","29912");
        params.put("mobile","17765198634");
        params.put("secret","A1OaB4u1tTADrRYngYodqSzMVAaN84GX");
        params.put("content","123");
        System.out.println(HttpUtil.post("http://api.1cloudsp.com/api/v2/send",params.toString()));

    }

    @Test
    public void httpClientPost1() throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            System.out.println("请输入日期。如2017-11-01");
//            Scanner scan = new Scanner(System.in);
//            String read = scan.nextLine();
            Date date = formatter.parse("2017-11-30");
            System.out.println("退后一天日期为：" + formatter.format(addDateOneDay(date)));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("录入错误，程序结束！");
        }


    }

    public static Date addDateOneDay(Date date) {
        if (null == date) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date); // 设置当前日期
        c.add(Calendar.DATE, 1); // 日期加1天
        date = c.getTime();
        return date;
    }

    @Test
    public void post() throws Exception {
    }

    @Test
    public void postSSL() throws Exception {
    }

}