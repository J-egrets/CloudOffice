package cn.egret.server.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;

/**
 * 消息
 * @author egret
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ChatMsg {

    /**
     * 从何处发来
     */
    private String from;

    /**
     * 发往何地
     */
    private String to;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 发送时间
     */
    private LocalDateTime date;

    /**
     * 发送者昵称
     */
    private String fromNickName;
}
