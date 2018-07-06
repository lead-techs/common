package top.ibase4j.core;

/**
 * Created by yaoyu on 2018/5/7.
 */
public interface TmspConstants {

    /*vo对象参数*/
    static final String ENTITY_VO = "params_entity_VO";

    /*do对象参数*/
    static final String ENTITY_DO = "params_entity_DO";

    /*params对象参数*/
    static final String ENTITY_PARAMS = "params_entity";

    /*当前用户id*/
    static final String CURRENT_CSTMID = "current_cstmId";

    /*查询数据*/
    static final String PARAMS_DATA = "data";

    /*查询信息*/
    static final String PARAMS_MSG = "message";

    /*查询code*/
    static final String PARAMS_CODE = "code";

    /*查询状态*/
    static final String PARAMS_RESULT = "result";

    /*当前页码*/
    static final String PARAMS_CURRENT = "current";

    /*当前页码默认第一页*/
    static final String CURRENT = "1";

    /*总页数*/
    static final String PARAMS_PAGES = "pages";

    /*每页条数*/
    static final String PARAMS_SIZE = "pageSize";

    /*每页默认显示十条*/
    static final String PAGESIZE = "10";

    /*数据总数*/
    static final String PARAMS_TOTAL = "total";

    /*时间毫秒数*/
    static final String PARAMS_TIMESTAMP = "timestamp";

    /* 正则表达式 */
    interface REGULAR {

        /* 正则验证签名 */
        static final String REGULAR_IDGPH = "[\\u4e00-\\u9fa5_a-zA-Z0-9\\u3010\\u3011]{0,20}";

        /* 数字正则 */
        static final String REGEX_NUM = "^[0-9]*$";
    }

    /* 是否提醒 */
    interface IS_REMIND {
        /* 提醒 */
        static final String YES = "0";
        /* 不提醒 */
        static final String NO = "1";
    }

}
