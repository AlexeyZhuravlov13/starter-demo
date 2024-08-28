package org.example.starterdemo;

import org.example.NotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@Import(NotifyTestUsersServiceTest.TestConfig.class)
@ExtendWith({SpringExtension.class, OutputCaptureExtension.class})
@ActiveProfiles({"testBeans"})
class NotifyTestUsersServiceTest {
    private static final String MESSAGE = "Test message";

    @Autowired
    private NotifyUsersService testNotifyUsersService;

    @Test
    void notifyUsersShouldUseTestMessage(CapturedOutput output) {
        testNotifyUsersService.notifyUsers();
        assertThat(output).contains(MESSAGE);
    }

    @TestConfiguration
    @Profile("testBeans")
    static class TestConfig {

        @Bean
        public NotificationService testNotificationService(){
         return  new NotificationService(MESSAGE);
        }

        @Bean
        public NotifyUsersService testNotifyUsersService(NotificationService testNotificationService) {
            return new NotifyUsersService(testNotificationService);
        }
    }
}