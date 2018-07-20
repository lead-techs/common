package top.ibase4j.core.util;

import org.codehaus.xfire.client.Client;
import top.ibase4j.core.exception.DataParseException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
	 * @param inUrl
	 * @return
	 */
	public static final String longConvertShortLink(String inUrl){

		//URL合法性检查
		if(!isValidUrl(inUrl)){
			throw new DataParseException("URL不合法");
		}

		String url = "http://api.ft12.com/api.php";
		String par = "url=" + inUrl;
		String shortLink = HttpUtil.httpClientGet(url,par);
		return  shortLink;
	}

	/**
	 * URL是否合法
	 *
	 * @param urlString
	 * @return false:不合法 true：合法
	 */
	public static boolean isValidUrl(String urlString) {
		URI uri = null;
		try {
			uri = new URI(urlString);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}

		if (uri.getHost() == null) {
			return false;
		}
		if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https")) {
			return true;
		}
		return false;
	}
}
