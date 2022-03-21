package cn.egret.server.exception;

import cn.egret.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理类
 * @author egret
 */
@RestControllerAdvice
public class GlobalException {

//    @ExceptionHandler(SQLException.class)
//    public RespBean mySQLException(SQLException e){
//        if (e instanceof SQLIntegrityConstraintViolationException){
//            return RespBean.error("该数据有关联数据，操作失败！");
//        }
//        return RespBean.error("数据库异常，操作失败！");
//    }
}