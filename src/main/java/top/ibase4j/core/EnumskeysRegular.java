package top.ibase4j.core;

/**
 * @author: 姚宇
 * @create: 2018-06-21 13:44
 **/
public interface EnumskeysRegular {

    /* 正则验证签名 */
    static final String REGULAR_IDGPH = "[\\u4e00-\\u9fa5_a-zA-Z0-9\\u3010\\u3011]{0,20}";

    /** 数字正则 **/
    public static final String regexNum = "^[0-9]*$";
}
