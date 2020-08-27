package com.example.Ftp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.remote.gateway.AbstractRemoteFileOutboundGateway;
import org.springframework.integration.ftp.gateway.FtpOutboundGateway;
import org.springframework.integration.ftp.outbound.FtpMessageHandler;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;

@Configuration
@EnableIntegration
public class FtpConfiguration {

    @Value("${ftp.username}")
    private String username;

    @Value("${ftp.password}")
    private String password;

    @Value("${ftp.host}")
    private String host;

    @Value("${ftp.port}")
    private int port;

    @Value("${ftp.port}")
    private String channel;

    @ServiceActivator(inputChannel = "ftp")
    @Bean
    public FtpOutboundGateway getGW() {
        FtpOutboundGateway gateway = new FtpOutboundGateway(sf(), "ls", "payload");
        gateway.setOption(AbstractRemoteFileOutboundGateway.Option.NAME_ONLY);
        gateway.setOutputChannelName("results");
        return gateway;
    }

    @Bean
    public MessageChannel results() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "upload")
    public MessageHandler messageHandler(){
        FtpMessageHandler messageHandler = new FtpMessageHandler(sf());
        messageHandler.setRemoteDirectoryExpression(new LiteralExpression(""));
        return messageHandler;
    }

    @Bean
    public DefaultFtpSessionFactory sf() {
        DefaultFtpSessionFactory sf = new DefaultFtpSessionFactory();
        sf.setHost(host);
        sf.setPort(port);
        sf.setUsername(username);
        sf.setPassword(password);
        return sf;
    }
}