package com.how2java.tmall.test;

import java.sql.*;

/**
 * @author: mingjian
 * @create: 2020-03-11 18:59
 */
public class TestTmall {
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement pstm;
        ResultSet rs;
        String sql="insert into category(name) values(?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm?" +
                    "useUnicode=true&characterEncoding=utf8","root","123");
            pstm=conn.prepareStatement(sql);
            for(int i=11;i<=20;i++){
                String s="测试分类"+i;
                pstm.setString(1,s);
                System.out.println(pstm);
                pstm.execute();
            }
            System.out.println("插入10条数据成功");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
