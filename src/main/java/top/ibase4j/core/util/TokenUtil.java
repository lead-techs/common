package top.ibase4j.core.util;

import com.alibaba.fastjson.JSON;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;
import top.ibase4j.core.Constants;
import top.ibase4j.core.support.Token;

import java.io.UnsupportedEncodingException;

public class TokenUtil {

	//秘钥
	private static String secret ;
	//所用者
	private static String auth ;

	public static String getSecret() {
		return secret;
	}

	public static void setSecret(String secret) {
		TokenUtil.secret = secret;
	}

	public static String getAuth() {
		return auth;
	}

	public static void setAuth(String auth) {
		TokenUtil.auth = auth;
	}

	public static void setTokenInfo(String token, String value) {
		try {
			Token tokenInfo = new Token();
			tokenInfo.setTime(System.currentTimeMillis());
			tokenInfo.setValue(value);
			CacheUtil.getLockManager().hset(Constants.TOKEN_KEY, token, JSON.toJSONString(tokenInfo));
		} catch (Exception e) {
			throw new RuntimeException("保存token失败，错误信息：", e);
		}
	}

	public static void delToken(String token) {
		try {
			CacheUtil.getLockManager().hdel(Constants.TOKEN_KEY, token);
		} catch (Exception e) {
			throw new RuntimeException("删除token失败，错误信息：", e);
		}
	}

	public static Token getTokenInfo(String token) {
		String value = (String) CacheUtil.getLockManager().hget(Constants.TOKEN_KEY, token);
		Token tokenInfo = JSON.parseObject(value, Token.class);
		return tokenInfo;
	}

	//创建一个签名的JWT token HS256算法
	public static String createToken(String secret,String auth){
		try {
			setSecret(secret);
			setAuth(auth);
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer(auth)
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
	public static Boolean verifyToken(String token){
		if(StringUtils.isEmpty(getSecret())||StringUtils.isEmpty(getAuth())){
			return false;
		}
		try {
			Algorithm algorithm = Algorithm.HMAC256(getSecret());
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer(getAuth())
					.build(); //Reusable verifier instance
			DecodedJWT jwt = verifier.verify(token);
			return true;
		} catch (UnsupportedEncodingException exception){
			//UTF-8 encoding not supported
		} catch (JWTVerificationException exception){
			//Invalid signature/claims
		}
		return false;
	}
}
