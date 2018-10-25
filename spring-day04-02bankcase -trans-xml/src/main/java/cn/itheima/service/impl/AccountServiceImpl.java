package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.po.Account;
import cn.itheima.service.AccountService;

/**
 * 账户service实现类
 */
public class AccountServiceImpl implements AccountService {

    // 定义账户dao
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 根据账户id查询账户
     *
     * @param id
     */
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    /**
     * 转账操作
     * sourceName:转出账户
     * destName：转入账户
     * money：转账金额
     *
     * @param sourceName
     * @param destName
     * @param money
     */
    public void transfer(String sourceName, String destName, Float money) {
        // 1.查询转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);

        // 2.查询转入账户
        Account destAccount = accountDao.findAccountByName(destName);

        // 3.转出账户-money
        sourceAccount.setMoney(sourceAccount.getMoney()-money);

        // 4.转入账户+money
        destAccount.setMoney(destAccount.getMoney()+money);

        // 5.更新转出账户
        accountDao.updateAccount(sourceAccount);

        /**
         * 刚好不巧：不知道是谁把服务器的网线踢断了。发生转账意外。
         */
       int i=1/0;

        // 6.更新转入账户
        accountDao.updateAccount(destAccount);
    }
}
