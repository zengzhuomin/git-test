package cn.itheima.service;

import cn.itheima.po.Account;

/**
 * 账户service接口
 */
public interface AccountService {

    /**
     * 根据账户id查询账户
     */
    Account findAccountById(Integer id);

    /**
     * 转账操作
     *  sourceName:转出账户
     *  destName：转入账户
     *  money：转账金额
     */
    void transfer(String sourceName,String destName,Float money);
}
