package com.example.Ftp;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.io.File;
import java.util.List;

@MessagingGateway(defaultRequestChannel = "ftp")
public interface FtpGateway {

    @Gateway(requestChannel = "upload")
    void uploadFile(File file);

    @Gateway(replyChannel = "results")
    List list(String directory);
}
