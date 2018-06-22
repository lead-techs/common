package org.ibase4j;

import org.junit.Test;
import top.ibase4j.core.support.email.Email;
import top.ibase4j.core.util.EmailUtil;
import top.ibase4j.core.util.UploadUtil;

//@WebAppConfiguration
public class FasetDFSTest {
    @Test
    public void main() {
        Email email = new Email("114772777@qq.com", "天福诺", "邮件测试，请查看");
        email.setHost("smtp.163.com");
        email.setPassword("yaoyu123");
        email.setName("tianfunuo");
        email.setFrom("yaoyu03153613@163.com");
//        email.setPort("110");
        EmailUtil.sendEmail(email);
    }
}
