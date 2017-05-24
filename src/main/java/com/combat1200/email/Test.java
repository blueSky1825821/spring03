package com.combat1200.email;

import org.apache.commons.mail.SimpleEmail;

/**
 * Created by sky on 2017/5/23.
 */
public class Test {
    public static void main ( String[] arg ) throws Exception
    {
        SimpleEmail email = new SimpleEmail ( );

        // smtp host
        email.setHostName ( "smtp.qq.com" );
        email.setSmtpPort(587);
        // 登陆邮件服务器的用户名和密码
        email.setAuthentication ( "1664637427", "password" );
        // 接收人
        email.addTo ( "1664637427@qq.com", "wm" );
        // 发送人
        email.setFrom ( "1664637427@qq.com", "Me" );
        // 标题
        email.setSubject ( "Test message" );
        // 邮件内容
        email.setMsg ( "This is a simple test of commons-email" );
        // 发送
        email.send ( );

        System.out.println ( "Send email successful!" );

    }
}
