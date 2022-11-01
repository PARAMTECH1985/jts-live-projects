package com.jts.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MailService
{
  public String userName;
  public String message;
  public String emailId;
//  public static final String MAIL_SERVER = "smtp.gmail.com";
//  public static final String USERNAME = "gunamarketmp@gmail.com";
//  public static final String PASSWORD = "gunamarket";
//  public static final String subject = "Thanks for Registeration";
  public String password;
  public String getEmailId()
  {
    return this.emailId;
  }
  
  public void setEmailId(String paramString)
  {
    this.emailId = paramString;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public String sendMail()
  {
    Properties localProperties = System.getProperties();
    localProperties.put("mail.smtp.host", "smtp.gmail.com");
    localProperties.put("mail.smtps.auth", "true");
    localProperties.put("mail.smtp.port", "587");
    localProperties.put("mail.smtp.starttls.enable","true");
    localProperties.put("mail.transport.protocol", "smtp");
    localProperties.put("mail.smtp.auth", "true");
    localProperties.put("mail.smtp.starttls.enable", "true");
    localProperties.put("mail.smtp.starttls.required", "true");
    localProperties.put("mail.debug", "true");
    localProperties.put("mail.smtp.ssl.enable", "false");
    Session localSession = Session.getInstance(localProperties);
    MimeMessage localMimeMessage = new MimeMessage(localSession);
    try
    {
      localMimeMessage.setFrom(new InternetAddress("jtsguna@gmail.com"));
      localMimeMessage.addRecipients(Message.RecipientType.TO, "rinkoobangalore@gmail.com");
      localMimeMessage.setSubject("Thanks for Registeration");
      localMimeMessage.setText("Test Message");
      Transport localTransport = localSession.getTransport("smtp");
      localTransport.connect("pop.gmail.com", "jtsguna@gmail.com", "jtsguna@123");
      localTransport.sendMessage(localMimeMessage, localMimeMessage.getAllRecipients());
      localTransport.close();
      return "Ok";
    }
    catch (Exception localException) 
    {
    	System.out.println(localException.getMessage());
    }
    return "Problem";
  }
  public static void main(String str[])
  {
	  MailService ms=new MailService();
	  ms.sendMail();
	  
  }
}
