package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

}
