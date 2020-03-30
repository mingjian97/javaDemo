package com.itheima.service;

import com.itheima.doamin.Account;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-01-04 11:59
 * 账户的业务层接口
 */
public interface IAccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
