/**
 * 2011-01-11
 */
package top.ibase4j.core.support.security.coder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import top.ibase4j.core.support.security.Hex;
import top.ibase4j.core.support.security.SecurityCoder;

/**
 * MD加密组件
 * 
 * @author ShenHuaJie
 * @version 1.0
 * @since 1.0
 */
public abstract class MDCoder extends SecurityCoder {

	/**
	 * MD2加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD2(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD2");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * MD4加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD4(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD4");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * MD5加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD5(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * Tiger加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeTiger(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("Tiger");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * TigerHex加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static String encodeTigerHex(byte[] data) throws Exception {
		// 执行消息摘要
		byte[] b = encodeTiger(data);
		// 做十六进制编码处理
		return new String(Hex.encode(b));
	}

	/**
	 * Whirlpool加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeWhirlpool(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("Whirlpool");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * WhirlpoolHex加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static String encodeWhirlpoolHex(byte[] data) throws Exception {
		// 执行消息摘要
		byte[] b = encodeWhirlpool(data);
		// 做十六进制编码处理
		return new String(Hex.encode(b));
	}

	/**
	 * GOST3411加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeGOST3411(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("GOST3411");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * GOST3411Hex加密
	 * 
	 * @param data 待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static String encodeGOST3411Hex(byte[] data) throws Exception {
		// 执行消息摘要
		byte[] b = encodeGOST3411(data);
		// 做十六进制编码处理
		return new String(Hex.encode(b));
	}

	/**
	 * 进行MD5加密
	 * @param source 需要加密的字符串
	 * @return
	 */
	public static String getMD5(byte[] source) {
		String s = null;
		char hexDigits[] = {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			s = new String(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

}
