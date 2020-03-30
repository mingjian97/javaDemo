package com.itheima.dao;

import com.itheima.doamin.Account;

import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-01-04 12:06
 * 账户的持久层接口
 */
public interface IAccountDao {
    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
