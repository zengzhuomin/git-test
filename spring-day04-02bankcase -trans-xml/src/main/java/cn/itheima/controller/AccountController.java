package cn.itheima.controller;

import cn.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 账户表现层
 */
public class AccountController {

    public static void main(String[] args) {
        // 1.加载spring的配置文件，创建spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 2.获取账户service
        AccountService accountService =(AccountService) context.getBean("accountService");

        // 3.执行转账操作
        /**
         * 需求：小明给小花转账200块
         */
        accountService.transfer("小明","小花",200f);

    }
}
