package top.ibase4j.core.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

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
    }

    @Test
    public void post() throws Exception {
    }

    @Test
    public void postSSL() throws Exception {
    }

}