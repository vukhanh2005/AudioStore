package com.nvk.apicrud.Services.Alter;
import com.nvk.apicrud.Entity.Alter.AlterProduct;
import com.nvk.apicrud.Entity.Product;
import io.github.cdimascio.dotenv.Dotenv;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;


public class AlterProductService {
    Connection conn;
    String url;
    String tableName = "products";
    public AlterProductService() throws Exception{
        Dotenv dotenv = Dotenv.load();
        url = "jdbc:mysql://" + dotenv.get("DB_Host") + ":" + dotenv.get("DB_Port") + "/" + dotenv.get("DB_Name");
        conn = DriverManager.getConnection(url, dotenv.get("DB_Username"), dotenv.get("DB_Password"));
    }
    public ArrayList<AlterProduct> getAllProducts() throws Exception{
        ArrayList<AlterProduct> list = new ArrayList<AlterProduct>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from " + tableName);

        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int old_price = rs.getInt("old_price");
            String image = rs.getString("image");
            int status = rs.getInt("status");
            String category = rs.getString("category");
            int soLuong = rs.getInt("soluong");
            Timestamp created_at = rs.getTimestamp("created_at");
            Timestamp updated_at = rs.getTimestamp("updated_at");

            list.add(new AlterProduct(id, name, price, old_price, image, status, category, soLuong, created_at, updated_at));
        }

        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }
    public ArrayList<AlterProduct> getProductsByCategory(String cate) throws Exception{
        ArrayList<AlterProduct> list = new ArrayList<AlterProduct>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from " + tableName);

        while(rs.next()){
            if(rs.getString("category").trim().equals(cate)){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int old_price = rs.getInt("old_price");
                String image = rs.getString("image");
                int status = rs.getInt("status");
                String category = rs.getString("category");
                int soLuong = rs.getInt("soluong");
                Timestamp created_at = rs.getTimestamp("created_at");
                Timestamp updated_at = rs.getTimestamp("updated_at");

                list.add(new AlterProduct(id, name, price, old_price, image, status, category, soLuong, created_at, updated_at));
            }
        }

        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }
    }
    public AlterProduct getProductById(int id_req) throws Exception{
        ResultSet rs = conn.createStatement().executeQuery("Select * from " + tableName + " where id = " + id_req);
        rs.next();
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int price = rs.getInt("price");
        int old_price = rs.getInt("old_price");
        String image = rs.getString("image");
        int status = rs.getInt("status");
        String category = rs.getString("category");
        int soLuong = rs.getInt("soluong");
        Timestamp created_at = rs.getTimestamp("created_at");
        Timestamp updated_at = rs.getTimestamp("updated_at");
        return new AlterProduct(id, name, price, old_price, image, status, category, soLuong, created_at, updated_at);
    }
}
