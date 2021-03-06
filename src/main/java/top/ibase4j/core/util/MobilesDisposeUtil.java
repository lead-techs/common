package top.ibase4j.core.util;

import com.google.common.base.Joiner;
import jodd.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import top.ibase4j.core.exception.IllegalParameterException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理电话号码
 */
public class MobilesDisposeUtil {

    private static final Pattern PATTERN_MOBILE = Pattern.compile("\\d{11}");
    private static final Pattern PATTERN_MOBILESTRING = Pattern.compile("^[0-9,]*$");
    private static final String MOBILE_REGEX = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
    private static final Pattern PAT_MOBILE = Pattern.compile(MOBILE_REGEX);

    /**
     * 检查电话号码是否合法
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (phone.trim().length() != 11) {
            throw new IllegalParameterException("手机号应为11位数");
        } else {
            Matcher m = PAT_MOBILE.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
                throw new IllegalParameterException("请填入正确的手机号");
            }
            return isMatch;
        }
    }
    /**
     * 有效号码
     *
     * @param mobiles
     * @return
     */
    public static List<String> validMobileList(String mobiles) {
        return rMDuplicateMobile(checkoutMobile(stringToList(mobiles)));
    }

    /**
     * 去重
     *
     * @param mobiles
     * @return
     */
    public static String rMDuplicateMobile(String mobiles) {
        return listToString(rMDuplicateMobile(stringToList(mobiles)));
    }

    /**
     * 去错
     *
     * @param mobiles
     * @return
     */
    public static String checkoutMobile(String mobiles) {
        return listToString(checkoutMobile(stringToList(mobiles)));
    }


    /**
     * 统计
     *
     * @param mobiles
     * @return
     */
    public static Map<String, Object> statisticMobile(String mobiles) {
        if (StringUtils.isEmpty(mobiles)) {
            Map map = new HashMap();
            map.put("totcalCount", 0);
            map.put("duplicateCount", 0);
            map.put("errorCount", 0);
            map.put("validCount", 0);
            return map;
        }

        List<String> mobileList = new ArrayList();
        mobileList.addAll(stringToList(mobiles));
        /*总数*/
        int totcalCount = mobileList.size();
        /*有效数*/
        int validCount = 0;
        /*重复数*/
        int duplicateCount = 0;
        /*无效数*/
        int errorCount = 0;

        /*无效数*/
        Iterator<String> it = mobileList.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (!PATTERN_MOBILE.matcher(str).matches()) {
                errorCount++;
            }
        }

        /*重复数*/
        HashSet<String> mobilesSet = new HashSet<>();
        mobilesSet.addAll(mobileList);
        duplicateCount = totcalCount - mobilesSet.size();

        /*有效数*/
        validCount = totcalCount - duplicateCount - errorCount;

        Map map = new HashMap();
        map.put("totcalCount", totcalCount);
        map.put("duplicateCount", duplicateCount);
        map.put("errorCount", errorCount);
        map.put("validCount", validCount);
        return map;
    }

    /**
     * 去重
     *
     * @param mobileList
     * @return
     */
    private static List<String> rMDuplicateMobile(List<String> mobileList) {
        HashSet<String> mobilesSet = new HashSet<>();
        mobilesSet.addAll(mobileList);
        return new ArrayList<>(mobilesSet);
    }


    /**
     * 去错
     *
     * @param mobileList
     * @return
     */
    private static List<String> checkoutMobile(List<String> mobileList) {
        List<String> mobiles = new ArrayList();
        mobiles.addAll(mobileList);
        Iterator<String> it = mobiles.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (!PATTERN_MOBILE.matcher(str).matches()) {
                it.remove();
            }
        }
        return mobiles;
    }


    /**
     * 号码 string 转 list
     *
     * @param mobilesStr
     * @return
     */
    public static List<String> stringToList(String mobilesStr) {
//        mobilesStr = StringUtils.replaceEach(mobilesStr, new String[]{"，", "\n", "\r"}, new String[]{",", ",", ","});
        mobilesStr = StringUtils.replaceChars(mobilesStr, "，\n\r", ",,,");
        mobilesStr = StringUtils.deleteWhitespace(mobilesStr);
        if (!PATTERN_MOBILESTRING.matcher(mobilesStr).matches()) {
            throw new IllegalParameterException("号码格式错误,请检查!");
        }
        return Arrays.asList(mobilesStr.split(","));
    }

    /**
     * 号码 list 转 string
     *
     * @param mobileList
     * @return
     */
    private static String listToString(List<String> mobileList) {
        return Joiner.on(",").join(mobileList);
    }


}
