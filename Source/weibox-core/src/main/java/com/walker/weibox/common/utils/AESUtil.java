package com.walker.weibox.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * author geksong <br/>
 * function aes加解密<br/>
 **/
public class AESUtil {
	private static final String KEY_ALGORITHM = "AES";
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	private static Cipher cipher = null;
	
	/**
	 * Aes加密
	 * @param src
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String src, String key) throws Exception {
		if(StringUtils.isBlank(key)) {
			throw new Exception("加密的key为空");
		}
		if(StringUtils.length(key) != 16) {
			throw new Exception("加密的key不是16位");
		}
		byte[] raw = key.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
		if(null == cipher)
			cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(src.getBytes());
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String encrypSrc = base64Encoder.encode(encrypted);
		return encrypSrc;
	}

	/**
	 * aes解密
	 * @param src
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String src, String key) throws Exception {
		if(StringUtils.isBlank(key)) {
			throw new Exception("解密的key为空");
		}
		if(StringUtils.length(key) != 16) {
			throw new Exception("解密的key不是16位");
		}
		byte[] raw = key.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
		if(null == cipher)
			cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] decrypted = base64Decoder.decodeBuffer(src);
		byte[] original = cipher.doFinal(decrypted);
		String resStr = new String(original);
		return resStr;
	}
}
