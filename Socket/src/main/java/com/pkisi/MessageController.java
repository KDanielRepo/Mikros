package com.pkisi;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequestMapping("/rest")
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/message")
    public Message greeting(Message message){
        return new Message("Hello, " + HtmlUtils.htmlEscape(message.getText()) + "!");
    }
}
