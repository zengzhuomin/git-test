package cn.itheima.rowmapper;

import cn.itheima.po.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 账户结果集映射类
 */
public class AccountRowMapper implements RowMapper<Account>{

    public Account mapRow(ResultSet rs, int i) throws SQLException {

        // 创建Account对象
        Account account = new Account();

        // 封装数据
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));

        return account;
    }
}
