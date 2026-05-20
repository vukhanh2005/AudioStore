package com.nvk.apicrud.Services.Alter;

import com.nvk.apicrud.Entity.Alter.AlterProduct;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.ArrayList;

public class AlterProductService {

    private final String tableName = "products";

    private final String url;
    private final String username;
    private final String password;

    public AlterProductService() {

        Dotenv dotenv = Dotenv.load();

        this.url = "jdbc:mysql://" +
                dotenv.get("DB_Host") + ":" +
                dotenv.get("DB_Port") + "/" +
                dotenv.get("DB_Name");

        this.username = dotenv.get("DB_Username");
        this.password = dotenv.get("DB_Password");
    }

    // Lấy tất cả sản phẩm
    public ArrayList<AlterProduct> getAllProducts() throws Exception {

        ArrayList<AlterProduct> list = new ArrayList<>();

        String query = "SELECT * FROM " + tableName;

        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {

            while (rs.next()) {

                list.add(new AlterProduct(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("old_price"),
                        rs.getString("image"),
                        rs.getInt("status"),
                        rs.getString("category"),
                        rs.getInt("soluong"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                ));
            }
        }

        return list.isEmpty() ? null : list;
    }

    // Lấy sản phẩm theo category
    public ArrayList<AlterProduct> getProductsByCategory(String cate) throws Exception {

        ArrayList<AlterProduct> list = new ArrayList<>();

        String query = "SELECT * FROM " + tableName + " WHERE category = ?";

        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {

            pstmt.setString(1, cate);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    list.add(new AlterProduct(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getInt("old_price"),
                            rs.getString("image"),
                            rs.getInt("status"),
                            rs.getString("category"),
                            rs.getInt("soluong"),
                            rs.getTimestamp("created_at"),
                            rs.getTimestamp("updated_at")
                    ));
                }
            }
        }

        return list.isEmpty() ? null : list;
    }

    // Lấy sản phẩm theo id
    public AlterProduct getProductById(int idReq) throws Exception {

        String query = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {

            pstmt.setInt(1, idReq);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {

                    return new AlterProduct(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getInt("old_price"),
                            rs.getString("image"),
                            rs.getInt("status"),
                            rs.getString("category"),
                            rs.getInt("soluong"),
                            rs.getTimestamp("created_at"),
                            rs.getTimestamp("updated_at")
                    );
                }
            }
        }

        return null;
    }
}