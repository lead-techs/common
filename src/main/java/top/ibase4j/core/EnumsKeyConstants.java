package top.ibase4j.core;

/**
 * Created by yaoyu on 2018/4/28.
 */
public interface EnumsKeyConstants {

    /*客户状态*/
    static final String CSTM_STATE = "CSTM_STATE";

    interface CSTMSTATE {

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

        /*可用*/
        static final String ENABLE = "01";

        /*禁用*/
        static final String DISABLE = "02";
    }

    /*短信发送状态*/
    static final String SMSSEND_STATE = "SMSSEND_STATE";

    interface SMSSENDSTATE{

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

        /*收到*/
        static final String DELIV = "01";

        /*未收到*/
        static final String UNDELIV = "02";
    }

    /*批次单状态*/
    static final String BATCH_STATE = "BATCH_STATE";

    interface BATCHSTATE{

        /*等待发送*/
        static final String INIT = "01";

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
        /*通用*/
        static final String PUB = "01";

        /*个人*/
        static final String PRI = "02";
    }

    /*是否发送*/
    static final String SMSSEND_CODE = "SMSSEND_CODE";

    interface SMSSENDCODE{

        /*发送*/
        static final String SEND = "01";

        /*不发送*/
        static final String DESEND = "02";
    }

    /*短信数量增减类型*/
    static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";

    interface ACCNTTYPE{
        /*增加数量*/
        static final String ADDITION = "01";

        /*减少数量*/
        static final String SUBTRACTION = "02";

    }

    /*充值单审核状态*/
    static final String RECHARGE_STATE = "RECHARGE_STATE";

    interface RECHARGESTATE{

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

        /*不在黑名单中*/
        static final String NOTINT = "01";

        /*在黑名单中*/
        static final String INT = "02";


    }

}
