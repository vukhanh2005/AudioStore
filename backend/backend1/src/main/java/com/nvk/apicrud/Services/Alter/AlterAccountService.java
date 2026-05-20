package com.nvk.apicrud.Services.Alter;

import com.nvk.apicrud.DTO.AccountRequest;
import com.nvk.apicrud.DTO.AccountResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

@Service
public class AlterAccountService  {
    private static final Logger log = LoggerFactory.getLogger(AlterAccountService.class);
    Connection conn;
    String url;
    String tableName = "accounts";
    public AlterAccountService() throws Exception{
        Dotenv dotenv = Dotenv.load();
        url = "jdbc:mysql://" + dotenv.get("DB_Host") + ":" + dotenv.get("DB_Port") + "/" + dotenv.get("DB_Name");
        conn = DriverManager.getConnection(url, dotenv.get("DB_Username"), dotenv.get("DB_Password"));
    }

    public AccountResponse login(AccountRequest request, HttpSession session) throws Exception{
        String username_request = request.getUsername().trim();
        String password_request = request.getPassword().trim();
        AccountResponse response = null;

        String query = "Select * from " + tableName;

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(query);

        boolean isExist = false;
        while(rs.next()){
            String user_Temp = rs.getString("username");
            String pass_Temp = rs.getString("password");

            if(username_request.equals(user_Temp) && password_request.equals(pass_Temp)){
                isExist = true;
                response = new AccountResponse(
                        rs.getInt("account_id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("email"),
                        "Đăng nhập thành công"
                );
                session.setAttribute("currentAccount", response);
            }
        }

        return response;
    }
    public AccountResponse register(AccountRequest request, HttpSession session) throws Exception{
        String username_request = request.getUsername();

        String query1 = "Select * from " + tableName;
        String query2 = "Insert into " + tableName + " (name, username, email, phone, address, password)" +
                " values (?, ?, ?, ?, ?, ?)";
        Statement stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement(query2);

        ResultSet rs = stmt.executeQuery(query1);

        boolean isHaveAlreadyAccount = false;
        AccountResponse response = null;
        while(rs.next()){
            System.out.println("Called");
            if(username_request.equals(rs.getString("username"))){
                isHaveAlreadyAccount = true;
            }
        }

        if(isHaveAlreadyAccount == false){
            pstmt.setString(1, request.getFullName());
            pstmt.setString(2, request.getUsername());
            pstmt.setString(3, request.getEmail());
            pstmt.setString(4, request.getPhone());
            pstmt.setString(5, request.getAddress());
            pstmt.setString(6, request.getPassword());

            pstmt.executeUpdate();
            Statement stmt_Temp = conn.createStatement();
            ResultSet rs_Temp = stmt_Temp.executeQuery("Select * from " + tableName + " where username='" + request.getUsername() + "'");
            rs_Temp.next();
            response = new AccountResponse(
                    rs_Temp.getInt("account_id"),
                    rs_Temp.getString("name"),
                    rs_Temp.getString("username"),
                    rs_Temp.getString("email"),
                    "Đăng ký thành công"
            );
        }
        return login(request, session);
    }
    public AccountResponse currentAccount(HttpSession session){
        Object account = session.getAttribute("currentAccount");
        AccountResponse response = null;
        if(account != null){
            response = (AccountResponse) account;
        }
        return response;
    }
}
