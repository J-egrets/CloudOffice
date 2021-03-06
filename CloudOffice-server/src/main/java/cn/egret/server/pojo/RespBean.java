package cn.egret.server.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回类
 * @author egret
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    /**
     * 返回状态码
     */
    private long code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回对象
     */
    private Object obj;

    /**
     * 成功返回
     * @param message
     * @return
     */
    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    /**
     * 成功返回
     * @param message
     * @param obj
     * @return
     */
    public static RespBean success(String message,Object obj){
        return new RespBean(200,message,obj);
    }

    /**
     * 失败返回
     * @param message
     * @return
     */
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }

    /**
     * 失败返回
     * @param message
     * @param obj
     * @return
     */
    public static RespBean error(String message,Object obj){
        return new RespBean(500,message,obj);
    }
}