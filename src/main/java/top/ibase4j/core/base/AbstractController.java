/**
 *
 */
package top.ibase4j.core.base;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;

import top.ibase4j.core.TmspConstants;
import top.ibase4j.core.support.HttpCode;
import top.ibase4j.core.support.Pagination;
import top.ibase4j.core.util.InstanceUtil;
import top.ibase4j.core.util.ShiroUtil;
import top.ibase4j.core.util.WebUtil;

/**
 * 控制器基类
 *
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:47:58
 */
public abstract class AbstractController {
    protected Logger logger = LogManager.getLogger();

    /** 获取当前用户Id(shiro) */
    protected Long getCurrUser() {
        return ShiroUtil.getCurrentUser();
    }

    /** 获取当前用户Id */
    protected Long getCurrUser(HttpServletRequest request) {
        Object id = WebUtil.getCurrentUser(request);
        if (id == null) {
            return null;
        } else {
            return Long.parseLong(id.toString());
        }
    }

    /** 设置成功响应代码 */
    protected ResponseEntity<ModelMap> setSuccessModelMap() {
        return setSuccessModelMap(new ModelMap(), null);
    }

    /** 设置成功响应代码 */
    protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap) {
        return setSuccessModelMap(modelMap, null);
    }

    /** 设置成功响应代码 */
    protected ResponseEntity<ModelMap> setSuccessModelMap(Object data) {
        return setModelMap(new ModelMap(), HttpCode.OK, data);
    }

    /** 设置成功响应代码 */
    protected ResponseEntity<ModelMap> setSuccessModelMap(ModelMap modelMap, Object data) {
        return setModelMap(modelMap, HttpCode.OK, data);
    }

    /** 设置响应代码 */
    protected ResponseEntity<ModelMap> setModelMap(HttpCode code) {
        return setModelMap(new ModelMap(), code, null);
    }

    /** 设置响应代码 */
    protected ResponseEntity<ModelMap> setModelMap(Integer code, String msg) {
        return setModelMap(new ModelMap(), code, msg, null);
    }

    /** 设置响应代码 */
    protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, HttpCode code) {
        return setModelMap(modelMap, code, null);
    }

    /** 设置响应代码 */
    protected ResponseEntity<ModelMap> setModelMap(HttpCode code, Object data) {
        return setModelMap(new ModelMap(), code, data);
    }

    /** 设置响应代码 */
    protected ResponseEntity<ModelMap> setModelMap(Integer code, String msg, Object data) {
        return setModelMap(new ModelMap(), code, msg, data);
    }

    /** 设置响应代码 */
    protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, HttpCode code, Object data) {
        return setModelMap(modelMap, code.value(), code.msg(), data);
    }

    /** 设置响应代码 */
    protected ResponseEntity<ModelMap> setModelMap(ModelMap modelMap, Integer code, String msg, Object data) {
        if (!modelMap.isEmpty()) {
            Map<String, Object> map = InstanceUtil.newLinkedHashMap();
            map.putAll(modelMap);
            modelMap.clear();
            for (String key : map.keySet()) {
                if (!key.startsWith("org.springframework.validation.BindingResult") && !key.equals("void")) {
                    modelMap.put(key, map.get(key));
                }
            }
        }

        if(code.equals(200)){
            modelMap.put(TmspConstants.PARAMS_RESULT,true);
        }else{
            modelMap.put(TmspConstants.PARAMS_RESULT,false);
        }

        if (data != null) {
            if (data instanceof Pagination<?>) {
                Pagination<?> page = (Pagination<?>)data;
                modelMap.put(TmspConstants.PARAMS_DATA, page.getRecords());
                modelMap.put(TmspConstants.PARAMS_CURRENT, page.getCurrent());
                modelMap.put(TmspConstants.PARAMS_SIZE, page.getSize());
                modelMap.put(TmspConstants.PARAMS_PAGES, page.getPages());
                modelMap.put(TmspConstants.PARAMS_TOTAL, page.getTotal());
            } else if (data instanceof List<?>) {
                modelMap.put(TmspConstants.PARAMS_DATA, data);
                modelMap.put(TmspConstants.PARAMS_TOTAL, ((List<?>)data).size());
            } else {
                modelMap.put(TmspConstants.PARAMS_DATA, data);
            }

        }
        modelMap.put(TmspConstants.PARAMS_CODE, code);
        modelMap.put(TmspConstants.PARAMS_MSG, msg);
        modelMap.put(TmspConstants.PARAMS_TIMESTAMP, System.currentTimeMillis());
        logger.info("response===>{}", JSON.toJSONString(modelMap));
        return ResponseEntity.ok(modelMap);
    }
}
