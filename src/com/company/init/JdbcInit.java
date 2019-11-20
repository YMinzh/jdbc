package com.company.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcInit {
    private static JdbcInit instance = null;
    public Connection conn = null;
    private final String url = "jdbc:mysql://localhost:3306/forjava?useUnicode=yes&characterEncoding=utf8";
    private final String user = "yyyminzh";
    private final String password = "haidesinian";

    public static JdbcInit getInstance(){
        if(instance==null){
            synchronized (JdbcInit.class){
                if(instance==null){
                    instance = new JdbcInit();
                }
            }
        }
        return instance;
    }

    public Connection getConn(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void init(){


    }

    private JdbcInit(){

    }



}
