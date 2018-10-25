package cn.itheima.dao;

import cn.itheima.po.Account;

/**
 * 账户dao接口
 */
public interface AccountDao {

    /**
     * 根据帐号id查询账户信息
     */
    Account findAccountById(Integer id);

    /**
     * 根据账户名称查询账户
     */
    Account findAccountByName(String name);

    /**
     * 更新账户信息
     */
    void updateAccount(Account account);
}
