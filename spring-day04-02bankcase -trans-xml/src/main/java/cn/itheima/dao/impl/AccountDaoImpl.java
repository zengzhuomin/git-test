package cn.itheima.dao.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.po.Account;
import cn.itheima.rowmapper.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户dao实现类
 */
public class AccountDaoImpl implements AccountDao{

    // 定义JdbcTemplate(查询：query，增删改：update)
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据帐号id查询账户信息
     *
     * @param id
     */
    public Account findAccountById(Integer id) {
        List<Account> list = jdbcTemplate.query("select * from account where id=?", new AccountRowMapper(), id);

        return list.isEmpty()?null:list.get(0);
    }

    /**
     * 根据账户名称查询账户
     *
     * @param name
     */
    public Account findAccountByName(String name) {

        List<Account> list = jdbcTemplate.query("select * from account where name=?", new AccountRowMapper(), name);

        // 判断账户是否为空
        if(list.isEmpty()){
            return null;
        }

        // 判断账户是否唯一
        if(list.size()>1){
            throw new RuntimeException("账户不唯一异常，请检查！");
        }

        return list.get(0);
    }

    /**
     * 更新账户信息
     *
     * @param account
     */
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set money=? where id=?",account.getMoney(),account.getId());
    }
}
