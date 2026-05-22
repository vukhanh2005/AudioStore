package com.nvk.apicrud.Services.Alter;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
public class AlterOrderService {
    Connection conn;
    String url;
    String tableName = "orders";
    public AlterOrderService() throws Exception{
        Dotenv dotenv = Dotenv.load();
        url = "jdbc:mysql://" + dotenv.get("DB_Host") + ":" + dotenv.get("DB_Port") + "/" + dotenv.get("DB_Name");
        conn = DriverManager.getConnection(url, dotenv.get("DB_Username"), dotenv.get("DB_Password"));
    }

}
