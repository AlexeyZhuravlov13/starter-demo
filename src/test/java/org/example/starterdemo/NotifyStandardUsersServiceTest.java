package org.example.starterdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class NotifyStandardUsersServiceTest {

    @Autowired
    private NotifyUsersService notifyUsersService;

    @Test
    void notifyUsersShouldUseMessageFromProperties(CapturedOutput output) {
        notifyUsersService.notifyUsers();
        assertThat(output).contains("Welcome to Spring Boot!");
    }
}