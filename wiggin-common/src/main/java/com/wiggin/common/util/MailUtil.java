/**
 *
 * copyright 2015-2020
 * @date 2017年1月28日 上午12:22:54
 * @author wiggin
 * @Description: 邮件发送工具
 * 
 */
package com.wiggin.common.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiggin.common.util.bean.SendMailBean;

/**
 *
 * @date 2017年1月28日 上午12:22:54
 * @author wiggin
 * @Description: 邮件发送工具
 * 
 */
public class MailUtil {

	private static Logger logger = LoggerFactory.getLogger(MailUtil.class);
	
	/**
	 * 
	 * @date 2017年1月28日 上午12:25:54
	 * @author wiggin
	 * @Description: 构造私有化
	 *
	 */
	private MailUtil() {

	}

	/**
	 * 
	 * @date 2017年1月30日 上午2:56:55
	 * @author wiggin
	 * @Description: 获得发送邮件所需的session
	 * @return
	 *
	 */
	private static Session init() {

		Properties properties = PropertiesUtils.loadProperties("config/properties/mail.properties");

		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(properties.getProperty("mail.from.addr"),
						properties.getProperty("mail.from.password"));
			}
		};

		Session session = Session.getDefaultInstance(properties, authenticator);

		return session;
	}

	/**
	 * 
	 * @date 2017年1月30日 上午3:04:41
	 * @author wiggin
	 * @Description: 发送邮件
	 * @param sendMailBean
	 *
	 */
	public static void sendMail(SendMailBean sendMailBean) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("sendMail sendMailBean :{}",JsonUtil.toJsonString(sendMailBean));
		}
		
		String from = PropertiesUtils.loadProperties("config/properties/mail.properties").getProperty("mail.from.addr");
		
		Session session = init();
		Message msg = new MimeMessage(session);
		
		try {
			
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, sendMailBean.getToAddress());
			msg.setSubject(sendMailBean.getSubject());
			msg.setSentDate(DateUtils.now());
			
			//添加邮件附件
			if ( !StringUtils.isEmpty(sendMailBean.getAttachment()) ) {
		         
				//主体消息
				BodyPart msgBodyPart = new MimeBodyPart();
				msgBodyPart.setContent(sendMailBean.getContent(),"text/html;charset=utf-8");
		        Multipart multipart = new MimeMultipart();
		        multipart.addBodyPart(msgBodyPart);

		        //附件
				BodyPart fileBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(sendMailBean.getAttachment());
				fileBodyPart.setDataHandler(new DataHandler(source));
				String fileName = sendMailBean.getAttachment().substring(sendMailBean.getAttachment().lastIndexOf("/")+1);
				fileBodyPart.setFileName(MimeUtility.encodeText(fileName));//MimeUtility.encodeText防止中文乱码
		        multipart.addBodyPart(fileBodyPart);
		        msg.setContent(multipart);
			} else {
				msg.setContent(sendMailBean.getContent(),"text/html;charset=utf-8");
			}
			
			//发送邮件
	       Transport.send(msg);

		} catch (Exception e) {
			logger.error("send mail fail... :{}",JsonUtil.toJsonString(e));
		} 
	}
}
