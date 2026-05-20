package com.nvk.apicrud.Services.Alter;
import com.nvk.apicrud.DTO.ContactRequest;
import com.nvk.apicrud.DTO.ContactResponse;
import com.nvk.apicrud.Entity.Alter.AlterContact;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.time.LocalDateTime;

public class AlterContactService {
    Connection conn;
    String url;
    String tableName = "contacts";
    public AlterContactService() throws Exception{
        Dotenv dotenv = Dotenv.load();
        url = "jdbc:mysql://" + dotenv.get("DB_Host") + ":" + dotenv.get("DB_Port") + "/" + dotenv.get("DB_Name");
        conn = DriverManager.getConnection(url, dotenv.get("DB_Username"), dotenv.get("DB_Password"));
    }
    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
    public ContactResponse sendContact(ContactRequest request) throws Exception{
        String query = "insert into " + tableName + " (full_name, email, phone, message, created_at) values (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, request.getFullName());
        pstmt.setString(2, request.getEmail());
        pstmt.setString(3, request.getPhone());
        pstmt.setString(4, request.getMessage());
        pstmt.setString(5, timestamp.toString());

        pstmt.executeUpdate();

        // lấy id vừa insert
        ResultSet rs = pstmt.getGeneratedKeys();
        int generatedId = -1;

        if (rs.next()) {
            generatedId = rs.getInt(1);
        }
        return new ContactResponse(generatedId, "Gửi liên hệ thành công!!");
    }
}
