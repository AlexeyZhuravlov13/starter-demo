package org.example.starterdemo;

import org.example.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotifyUsersService {
    private final NotificationService notificationService;

    public NotifyUsersService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUsers() {
        notificationService.send();
    }

}
