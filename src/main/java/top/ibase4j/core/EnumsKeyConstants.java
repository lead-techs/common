package top.ibase4j.core;

/**
 * Created by yaoyu on 2018/4/28.
 */
public interface EnumsKeyConstants {

    /*客户状态*/
    static final String CSTM_STATE = "CSTM_STATE";

    interface CSTMSTATE {

        /*初始化状态*/
        static final String INIT = "00";

        /*正常*/
        static final String NORMAL = "01";

        /*停用*/
        static final String BLOCKUP = "02";

        /*冻结*/
        static final String FROZEN = "03";
    }

    /*短信类型*/
    static final String SMS_TYPE = "SMS_TYPE";

    interface SMSTYPE {

        /*初始化状态*/
        static final String INIT = "00";

        /*验证码*/
        static final String VERCODE = "01";

        /*通知*/
        static final String NOTICE = "02";

        /*营销*/
        static final String MARKETING = "03";

        /*未知*/
        static final String UNKNOWN = "04";
    }

    /*审核状态*/
    static final String AUDIT_STATE = "AUDIT_STATE";

    interface AUDITSTATE{

        /*初始化状态*/
        static final String INIT = "00";

        /*审核中*/
        static final String ING = "01";

        /*审核通过*/
        static final String ED = "02";

        /*审核驳回*/
        static final String DF = "03";

    }

    /*运营商类型*/
    static final String OPERATOR_TYPE = "OPERATOR_TYPE";

    interface OPERATORTYPE{

        /*初始化状态*/
        static final String INIT = "00";

        /*移动*/
        static final String MOBILE = "01";

        /*电信*/
        static final String TELECOM = "02";

        /*联通*/
        static final String UNICOM = "03";
    }

    /*通道状态*/
    static final String CHANNEL_STATE = "CHANNEL_STATE";

    interface CHANNELSTATE{

        /*初始化状态*/
        static final String INIT = "00";

        /*可用*/
        static final String ENABLE = "01";

        /*禁用*/
        static final String DISABLE = "02";
    }

    /*短信发送状态*/
    static final String SMSSEND_STATE = "SMSSEND_STATE";

    interface SMSSENDSTATE{

        /*初始化状态*/
        static final String INIT = "00";

        /*成功*/
        static final String SUCCESS = "01";

        /*失败*/
        static final String FAILURE = "02";

        /*未知*/
        static final String UNKNOWN = "03";

        /*无效*/
        static final String INVALID = "04";

        /*其他*/
        static final String OTHER = "05";
    }

    /*短息接收状态*/
    static final String SMSDELIV_STATE = "SMSDELIV_STATE";

    interface SMSDELIVSTATE{

        /*初始化状态*/
        static final String INIT = "00";

        /*收到*/
        static final String DELIV = "01";

        /*未收到*/
        static final String UNDELIV = "02";
    }

    /*批次单状态*/
    static final String BATCH_STATE = "BATCH_STATE";

    interface BATCHSTATE{

        /*初始化状态*/
        static final String INIT = "00";

        /*等待发送*/
        static final String WAIT = "01";

        /*发送中*/
        static final String ING = "02";

        /*完成*/
        static final String FINISH = "03";

        /*已撤回*/
        static final String REVOKE = "04";

        /*已驳回*/
        static final String REJECT = "05";
    }

    /*适用范围类型*/
    static final String USEAGE_TYPE = "USEAGE_TYPE";

    interface USEAGETYPE{

        /*初始化状态*/
        static final String INIT = "00";

        /*通用*/
        static final String PUB = "01";

        /*个人*/
        static final String PRI = "02";
    }

    /*是否发送*/
    static final String SMSSEND_CODE = "SMSSEND_CODE";

    interface SMSSENDCODE{

        /*初始化状态*/
        static final String INIT = "00";

        /*发送*/
        static final String SEND = "01";

        /*不发送*/
        static final String DESEND = "02";
    }

    /*短信数量增减类型*/
    static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";

    interface ACCNTTYPE{

        /*初始化状态*/
        static final String INIT = "00";

        /*充值*/
        static final String ADDITION = "01";

        /*消费*/
        static final String SUBTRACTION = "02";

    }

    /*充值单审核状态*/
    static final String RECHARGE_STATE = "RECHARGE_STATE";

    interface RECHARGESTATE{

        /*初始化状态*/
        static final String INIT = "00";

        /*成功*/
        static final String SUCCESS = "01";

        /*失败*/
        static final String FAILURE = "02";

        /*确认中*/
        static final String COMFIRM = "03";

        /*已取消*/
        static final String CANCEL = "04";

    }

    /*手机号是否在黑名单中*/
    static final String REPLY_BLACK = "REPLY_BLACK";

    interface REPLYBLACK{

        /*初始化状态*/
        static final String INIT = "00";

        /*不在黑名单中*/
        static final String NOTINT = "01";

        /*在黑名单中*/
        static final String INT = "02";


    }
    /*逻辑删除enable*/
    static final String DELETE_ENABLE = "DELETE_ENABLE";

    interface DELETEENABLE{

        /*已删除*/
        static final Integer DELETE = 0;

        /*未删除*/
        static final Integer UNDELE = 1;


    }
    /*适用范围 模板 通用，个人*/
    static final String SUIT_RANGE = "SUIT_RANGE";

    interface SUITRANGE{

        /*初始化状态*/
        static final String INIT = "00";

        /*通用*/
        static final String COMMON = "01";

        /*个人*/
        static final String PERSONAL = "02";


    }

    /*使用場景 01 平台 ， 02 接口*/
    static final String USE_TYPE = "USE_TYPE";

    interface USETYPE{

        /*平台*/
        static final String PLTFC = "01";

        /*接口*/
        static final String INTFC = "02";
    }

    /* 提醒类型 */
    static final String REMIND_TYPE = "REMIND_TYPE";

    interface REMINDTYPE{
        /* 未知 */
        static final String UNKNOWN = "00";
        /* 短信数量 */
        static final String SMS_NUM = "01";
        /* 发送频率*/
        static final String SEND_RATE = "02";
    }

    /* 阈值类型 */
    static final String THRESHOLD_TYPE = "THRESHOLD_TYPE";

    interface THRESHOLDTYPE {
        /* 未知 */
        static final String UNKNOWN = "00";
        /* 小于 */
        static final String  LESS_THAN = "01";
        /* 等于*/
        static final String EQUAL = "02";
        /* 大于*/
        static final String GREATER_THAN = "03";
    }

    /* 客户类型 */
    static final String CSTM_TYPE = "CSTM_TYPE";

    interface CSTMTYPE{
        /* 未知 */
        static final String UNKNOWN = "00";
        /* 个人 */
        static final String PERSON = "01";
        /* 企业*/
        static final String COMPANY = "02";
    }

    /* 支付状态 */
    static final String PAY_TYPE = "PAY_TYPE";

    interface PAYTYPE{
        /* 审核中 */
        static final String UNPAY = "01";
        /* 通过 */
        static final String PAY = "02";
        /* 驳回 */
        static final String REJECT = "03";
        /* 已取消 */
        static final String CANCEL = "04";
    }

    /* 任务状态 */
    static final String TASK_STATE = "TASK_STATE";

    interface TASKSTATE{
        /* 待发送 */
        static final String WAIT_SEND = "01";
        /* 已发送 */
        static final String SEND = "02";
        /* 成功 */
        static final String SUCCESS = "03";
        /* 失败 */
        static final String FAIL = "04";
    }

}
