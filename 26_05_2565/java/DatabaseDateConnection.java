package com.example.oop;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseDateConnection {
    public Connection dataBaseLink;
    public Connection getDataBaseLink(){
        String dataBaseName = "world";
        String dataBaseUser = "root";
        String dataBasePassword = "71457145";
        String url = "jdbc:mysql://localhost/" + dataBaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataBaseLink = DriverManager.getConnection(url,dataBaseUser,dataBasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return dataBaseLink;
    }

}
