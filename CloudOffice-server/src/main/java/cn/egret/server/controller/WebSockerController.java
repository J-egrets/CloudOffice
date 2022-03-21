package cn.egret.server.controller;

import cn.egret.server.pojo.Admin;
import cn.egret.server.pojo.ChatMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * @author egret
 */
@Controller
public class WebSockerController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg){
        Admin admin = (Admin) authentication.getPrincipal();
        chatMsg.setFrom(admin.getUsername());
        chatMsg.setFromNickName(admin.getName());
        chatMsg.setDate(LocalDateTime.now());
        /**
         * 发送消息
         * 1.消息接收者
         * 2.消息队列
         * 3.消息对象
         */
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(),"/queue/chat",chatMsg);
    }
}
