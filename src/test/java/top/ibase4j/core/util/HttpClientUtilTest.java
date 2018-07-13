package top.ibase4j.core.util;

import org.junit.Test;
import top.ibase4j.core.support.http.common.HttpConfig;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by HH on 2018-06-07.
 */
public class HttpClientUtilTest {
    @Test
    public void get() throws Exception {
        String url = "http://tool.oschina.net/";
        HttpConfig config = HttpConfig.custom();
        String s = HttpClientUtil.get(config.url(url));
        System.out.println(s);
    }

    @Test
    public void get1() throws Exception {
//        MobilesDisposeUtil.isPhone("15965471234");
//        System.out.println(WebServiceUtil.longConvertShortLink("http://api.ft12.com/api.php","format=jsonp&url=http%3A%2F%2Fwww.baidu.com%2F&callback=callbackname"));
        String[] strs = WebServiceUtil.shortUrl("https://blog.csdn.net/yushouling/article/details/55096992");
        System.out.println(strs);
    }

    @Test
    public void post() throws Exception {
    }

    @Test
    public void post1() throws Exception {
    }

}