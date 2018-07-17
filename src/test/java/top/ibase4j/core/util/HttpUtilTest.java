package top.ibase4j.core.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse("2017-11-01");
            System.out.println("退后一天日期为：" + formatter.format(addDateOneDay(date)));
//        System.out.println("前一天日期为：" + formatter.format(addDateOneDay(new Date())));
    }

    public static Date addDateOneDay(Date date) {
        if (null == date) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date); // 设置当前日期
        c.add(Calendar.DATE, -1); // 日期加1天
        date = c.getTime();
        return date;
    }

    @Test
    public void post() throws Exception {
        String token = TokenUtil.createToken("secret","auth0");
        System.out.println(token);
        Boolean jwt = TokenUtil.verifyToken(token);
        System.out.println(jwt);
    }

    @Test
    public void postSSL() throws Exception {
    }

    //创建一个签名的JWT token HS256算法
    private String createToken(){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return null;
    }

    //验证令牌
    private DecodedJWT verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            return  jwt;
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
        }
        return null;
    }

}