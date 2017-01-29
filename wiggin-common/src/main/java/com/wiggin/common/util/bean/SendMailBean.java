/**
 *
 * copyright 2015-2020
 * @date 2017年1月30日 上午3:06:46
 * @author wiggin
 * @Description: 发送邮件所需要的bean
 * 
 */
package com.wiggin.common.util.bean;

import javax.mail.internet.InternetAddress;

/**
 *
 * @date 2017年1月30日 上午3:06:46
 * @author wiggin
 * @Description: 发送邮件所需要的bean
 * 
 */
public class SendMailBean {

	private String subject;//邮件主题
	
	private String content;//邮件正文
	
	private String attachment;//附件

	private InternetAddress[] toAddress;//目标邮件地址
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public InternetAddress[] getToAddress() {
		return toAddress;
	}

	public void setToAddress(InternetAddress[] toAddress) {
		this.toAddress = toAddress;
	}
	
	
}
