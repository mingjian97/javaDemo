package com.itheima.test;

import com.itheima.doamin.Account;
import com.itheima.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-01-04 12:28
 * 使用junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        List<Account>accounts=as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        Account account=as.findAccountById(1);

        System.out.println(account);
    }

    @Test
    public void testSave(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);

        Account account=new Account();
        account.setName("test");
        account.setMoney(10000f);

        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        Account account=as.findAccountById(4);
        account.setMoney(100f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        as.deleteAccount(5);
    }
}
