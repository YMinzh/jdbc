package com.company.dao;

import com.company.init.JdbcInit;
import com.company.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
    private String sql;
    private static Connection conn;

    static{
        conn = JdbcInit.getInstance().getConn();
    }

    public String add(Person per){
        sql = "insert into Person (name,phone) values (?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,per.getName());
            pre.setString(2,per.getPhone());

            if(pre.executeUpdate()>0){
                return "add success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "fail";
    }

    public String change(Person per){
        sql = "UPDATE Person SET phone=? where name = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,per.getPhone());
            pre.setString(2,per.getName());
            if(pre.executeUpdate()>0) {
                return "change success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "fail";
    }

    public String delete(Person per){
        sql = "delete from Person where name = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,per.getName());

            if(pre.executeUpdate()>0) {
                return "delete success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "fail";
    }

    public String select(Person per){

        if (per.getName().equals("all")){
            sql = "select * from Person";
        }else {
            sql = "select  *from Person where name = ?";
        }

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            if(!per.getName().equals("all")){
                pre.setString(1,per.getName());
            }
            ResultSet set = pre.executeQuery();
            String str = "";
            while (set.next()){
                str = str + "name:"+set.getString("name")+";phone:"+set.getString("phone")+"\n\r";
            }
            if(str.length()==0){
                str = "查无此人或还没有添加人员";
            }
            return str;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "null";
    }
}
