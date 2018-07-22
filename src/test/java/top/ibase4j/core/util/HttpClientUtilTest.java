package top.ibase4j.core.util;

import org.junit.Test;
import top.ibase4j.core.support.http.common.HttpConfig;

import java.lang.reflect.Array;
import java.util.*;

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
        String strs = WebServiceUtil.longConvertShortLink("http://cnblogscom/james-lee/p/6847906.html");
        System.out.println(strs);
    }

    @Test
    public void post() throws Exception {
        System.out.println(Arrays.toString(DateUtil.lastWeekDate().toArray()));
    }

    @Test
    public void post1() throws Exception {
    }

}