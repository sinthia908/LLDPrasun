package com.interview.practice.domain;

import java.time.LocalDateTime;

public class Notification {
    private final int notificationId;
    private final String message;
    private final LocalDateTime timestamp;
    private final User recipient;


    Notification(int notificationId,String message,LocalDateTime timestamp,User recipient){
    this.notificationId = notificationId;
    this.message = message;
    this.timestamp = timestamp;

    }
}
