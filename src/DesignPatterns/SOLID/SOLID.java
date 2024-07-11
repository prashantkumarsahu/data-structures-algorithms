package DesignPatterns.SOLID;

public class SOLID {

}
// ****************************************************************************************
// WRONG
class NotificationService {
  public void sendNotification(String message) {
    // Format the message
    // Send the notification
  }
}

// RIGHT
class MessageFormatter {
  public String formatMessage(String message) {
    // Format the message
    return message;
  }
}

class NotificationSender {
  public void sendNotification(String formattedMessage) {
    // Send the notification
  }
}

// ************************************************************************************

// OPEN/CLOSE Principle
class EmailNotificationSender extends NotificationSender {
  public void sendEmail(String message) {
    // Send an email
  }
}

class SmsNotificationSender extends NotificationSender {
  public void sendSms(String message) {
    // Send an SMS
  }
}


// ************************************************************************************

// Interface Segregation Principle

// WRONG
interface NotificationProvider {
  void sendEmail();
  void sendSMS();
}

// RIGHT
interface EmailNotificationProvider {
  void sendEmail();
}

interface SMSNotificationProvider {
  void sendSMS();
}



// ************************************************************************************

// Dependency Inversion Principle

// WRONG
class NotificationService1 {
  private NotificationProvider provider;

  public NotificationService1(NotificationProvider provider) {
    this.provider = provider;
  }

  public void sendNotification() {
    // Use the provider to send the notification
  }
}

// RIGHT
interface NotificationProvider1 {
  void sendNotification();
}

class EmailNotificationProvider1 implements NotificationProvider1 {
  public void sendNotification() {
    // Send an email
  }
}

class SMSNotificationProvider1 implements NotificationProvider1 {
  public void sendNotification() {
    // Send an SMS
  }
}

class NotificationService2 {
  private NotificationProvider1 provider;

  public NotificationService2(NotificationProvider1 provider) {
    this.provider = provider;
  }

  public void sendNotification() {
    provider.sendNotification();
  }
}





