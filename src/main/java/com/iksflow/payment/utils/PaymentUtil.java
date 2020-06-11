package com.iksflow.payment.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class PaymentUtil {
    @Autowired
    StringEncryptor encryptor;

    public String createUniqueId() {
        int random = Double.valueOf(Math.random() * 30).intValue();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String smallUuid = uuid.substring(random, random + 3);
        String timeId = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String uniqueId = timeId + smallUuid;

        return uniqueId;
    }

    public String encrypt(String plainText) {
        return encryptor.encrypt(plainText);
    }
}
