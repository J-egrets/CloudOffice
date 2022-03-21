package cn.egret.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * EnableScheduling开启定时任务
 * @author 14489
 */
@SpringBootApplication
@MapperScan("cn.egret.server.mapper")
@EnableScheduling
public class CloudOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOfficeApplication.class,args);
    }
}
