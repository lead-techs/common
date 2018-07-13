package top.ibase4j.core.util;

import java.net.URL;

import org.apache.commons.codec.digest.DigestUtils;
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
	public static final String longConvertShortLink(String url,String par){

//		HttpConfig httpConfig = HttpConfig.custom();
//		httpConfig.url("http://api.ft12.com/api.php?url=urlencode(https://blog.csdn.net/yelin042/article/details/67631585)");
		String urls = "http://api.ft12.com/api.php";
		String pars = "url=urlencode(https://blog.csdn.net/yelin042/article/details/67631585)";
		String shortLink = HttpUtil.httpClientGet(url,par);
		return  shortLink;
	}

	/**
	 * 加密成短连接
	 * TODO:需要数据库给出对应关系
	 * @param url
	 * @return
	 */
	public static String[] shortUrl(String url) {
		// 可以自定义生成 MD5 加密字符传前的混合 KEY
		String key = "";
		// 要使用生成 URL 的字符
		String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };

		// 对传入网址进行 MD5 加密
		String sMD5EncryptResult = DigestUtils.md5Hex(key + url);
		String hex = sMD5EncryptResult;
		String[] resUrl = new String[4];
		for (int i = 0; i < 4; i++) {
			// 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
			String sTempSubString = hex.substring(i * 8, i * 8 + 8);
			// 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用
			// long ，则会越界
			long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
			String outChars = "";
			for (int j = 0; j < 6; j++) {
				// 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
				long index = 0x0000003D & lHexLong;
				// 把取得的字符相加
				outChars += chars[(int) index];
				// 每次循环按位右移 5 位
				lHexLong = lHexLong >> 5;
			}

			// 把字符串存入对应索引的输出数组
			resUrl[i] = outChars;
		}
		return resUrl;
	}

}
