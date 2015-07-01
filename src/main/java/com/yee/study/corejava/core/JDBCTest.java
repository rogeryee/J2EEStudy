package com.yee.study.corejava.core;

import java.sql.*;

/**
 * 采用JDBC的方式完成从一张表查询数据，并插入另一张表的操作
 */
public class JDBCTest
{
    public void importData()
    {
        Connection conn = null;
        PreparedStatement stmt = null, stmt2 = null;
        ResultSet rs = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.13.144.14:1521:maxqa2", "rjf", "rjf");

            stmt = conn.prepareStatement("select IFCE_TXN_ID from svi_trd where rownum<10000");
            stmt2 = conn.prepareStatement("insert into test_temp(ID) values (?)");

            rs = stmt.executeQuery();
            int id;
            while (rs.next())
            {
                id = rs.getInt(1);
                stmt2.setInt(1, id);
                stmt2.executeQuery(); // 理论上会遇到游标超出上限的问题
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

            if (stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

            if (stmt2 != null)
            {
                try
                {
                    stmt2.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String [] args)
    {
        JDBCTest test = new JDBCTest();
        test.importData();
    }
}
