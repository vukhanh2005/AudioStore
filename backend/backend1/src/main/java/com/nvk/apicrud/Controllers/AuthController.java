package com.nvk.apicrud.Controllers;

import com.nvk.apicrud.DTO.AccountRequest;
import com.nvk.apicrud.DTO.AccountResponse;
import com.nvk.apicrud.Services.AccountService;
import com.nvk.apicrud.Services.Alter.AlterAccountService;
import com.nvk.apicrud.Services.Alter.AlterProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"}, allowCredentials = "true")
public class AuthController {
    private final AccountService accountService;

    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public AccountResponse login(@RequestBody AccountRequest request, HttpSession session) throws Exception{
        return new AlterAccountService().login(request, session);
    }

    @PostMapping("/register")
    public AccountResponse register(@RequestBody AccountRequest request, HttpSession session) throws Exception{
        return new AlterAccountService().register(request, session);
    }

    @GetMapping("/me")
    public AccountResponse me(HttpSession session) throws Exception{
        return new AlterAccountService().currentAccount(session);
    }

    @PostMapping("/logout")
    public Map<String, String> logout(HttpSession session) {
        accountService.logout(session);
        return Map.of("message", "Đã đăng xuất");
    }

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<Map<String, String>> handleAuthError(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", exception.getMessage()));
    }
}
