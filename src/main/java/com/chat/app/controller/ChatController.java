package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage") //the message that client will send, will be captured here
    @SendTo("/topic/messages") //whoever has subscribed to this will able to see messagees
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    //This would we returned to the thymeleaf template
    @GetMapping
    public String chat(){
        return "chat";
    }

}
