/**
 * 
 */
package top.ibase4j.core.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jodd.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.ibase4j.core.exception.IllegalParameterException;

/**
 * 
 * @author ShenHuaJie
 * @version 2017年12月12日 下午4:42:52
 */
public class FileUtil {
    private static Logger logger = LogManager.getLogger();

    public static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<String>();
        BufferedReader reader = null;
        FileInputStream fis = null;
        try {
            File f = new File(fileName);
            if (f.isFile() && f.exists()) {
                fis = new FileInputStream(f);
                reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!"".equals(line)) {
                        list.add(line);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("readFile", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.error("InputStream关闭异常", e);
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                logger.error("FileInputStream关闭异常", e);
            }
        }
        return list;
    }

    /**
     * 读取文件中的电话号码
     * Excel2007以下版本和文本格式
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String readFileToMobiles(String fileName) throws Exception {

        if(StringUtils.isEmpty(fileName)){
            throw new IllegalParameterException("文件不能为空");
        }
        String postFix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();

        String mobiles = "";
        //是否excel文件
        if(postFix.equals(".xlsx")||postFix.equals(".xls")){
            StringBuffer strBuffer = new StringBuffer();
            List<String[]> strs = ExcelReaderUtil.excelToArrayList(fileName, 0);
            for(String[] str:strs){
                String row = "";
                strBuffer = strBuffer.append(str[0]).append(",");
            }
            mobiles = strBuffer.toString();
        }else{
            mobiles = readToString(fileName);
        }
        return mobiles;
    }


    /**
     * 读取一般的文本文件
     * 将文件内容转成String
     * @param filename
     * @return
     * @throws IOException
     */
    public static String readToString(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine())!= null)
            sb.append(s + ",");
        in.close();

        Pattern pattern = Pattern.compile("(?<=,)\\d{1,10}(?=,)");
        Matcher matcher = pattern.matcher(sb);
        //处理不符合要求的电话号码
        while(matcher.find()){
            //去掉多余的逗号
            sb.replace(matcher.end(),matcher.end()+1,"");
            matcher = pattern.matcher(sb);
        }
        return sb.toString();
    }
}
