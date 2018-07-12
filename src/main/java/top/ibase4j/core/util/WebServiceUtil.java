package top.ibase4j.core.util;

import java.net.URL;

import org.codehaus.xfire.client.Client;
import top.ibase4j.core.support.http.common.HttpConfig;

/**
 * @author ShenHueJie
 * @version 2016年5月24日 下午5:25:11
 */
public final class WebServiceUtil {
	private WebServiceUtil() {
	}

	/** 调用webService */
	public static final Object invoke(String url, String method, Object... params) {
		try {
			Client client = new Client(new URL(url + "?wsdl"));
			return client.invoke(method, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 长连接转短连接
	 *
	 * @param url
	 * @return
	 */
	public static final String longConvertShortLink(String url){

//		HttpConfig httpConfig = HttpConfig.custom();
//		httpConfig.url("http://api.ft12.com/api.php?url=urlencode(https://blog.csdn.net/yelin042/article/details/67631585)");
		String urls = "http://api.ft12.com/api.php?url=urlencode(https://blog.csdn.net/yelin042/article/details/67631585)";
		String shortLink = HttpUtil.httpClientPost(url);
		return  shortLink;
	}

}
