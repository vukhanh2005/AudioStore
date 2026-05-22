package com.nvk.apicrud.Services;

import com.nvk.apicrud.DTO.AccountRequest;
import com.nvk.apicrud.DTO.AccountResponse;
import com.nvk.apicrud.Entity.Account;
import com.nvk.apicrud.Repository.AccountsRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AccountService {
    public static final String SESSION_ACCOUNT = "currentAccount";

    private final AccountsRepository accountsRepository;

    public AccountService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public AccountResponse login(AccountRequest request, HttpSession session) {
        validateLogin(request);
        Account account = accountsRepository.findByUsername(request.getUsername().trim())
                .orElseThrow(() -> new IllegalArgumentException("Tên đăng nhập hoặc mật khẩu không đúng"));

        if (!passwordMatches(request.getPassword(), account.getPassword())) {
            throw new IllegalArgumentException("Tên đăng nhập hoặc mật khẩu không đúng");
        }

        AccountResponse response = toResponse(account, "Đăng nhập thành công");
        session.setAttribute(SESSION_ACCOUNT, response);
        return response;
    }

    public AccountResponse register(AccountRequest request, HttpSession session) {
        validateRegister(request);
        if (accountsRepository.existsByUsername(request.getUsername().trim())) {
            throw new IllegalArgumentException("Tên đăng nhập đã tồn tại");
        }

        Account account = new Account();
        account.setFullName(request.getFullName().trim());
        account.setUsername(request.getUsername().trim());
        account.setEmail(blankToEmpty(request.getEmail()));
        account.setPhone(blankToEmpty(request.getPhone()));
        account.setAddress(blankToEmpty(request.getAddress()));
        account.setPassword(request.getPassword());
        accountsRepository.save(account);

        return login(request, session);
    }

    public AccountResponse currentAccount(HttpSession session) {
        Object account = session.getAttribute(SESSION_ACCOUNT);
        if (account instanceof AccountResponse) {
            return (AccountResponse) account;
        }else{

        }
        return null;
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

    private void validateLogin(AccountRequest request) {
        if (request.getUsername() == null || request.getUsername().isBlank()
                || request.getPassword() == null || request.getPassword().isBlank()) {
            throw new IllegalArgumentException("Vui lòng nhập tên đăng nhập và mật khẩu");
        }
    }

    private void validateRegister(AccountRequest request) {
        validateLogin(request);
        if (request.getFullName() == null || request.getFullName().isBlank()) {
            throw new IllegalArgumentException("Vui lòng nhập họ tên");
        }
    }

    private boolean passwordMatches(String rawPassword, Object savedPassword) {
        if (savedPassword == null) {
            return false;
        }
        String saved = String.valueOf(savedPassword);
        return saved.equals(rawPassword) || saved.equalsIgnoreCase(hashPassword(rawPassword));
    }

    private AccountResponse toResponse(Account account, String message) {
        return new AccountResponse(
                account.getId(),
                toString(account.getFullName()),
                toString(account.getUsername()),
                toString(account.getEmail()),
                message
        );
    }

    private String blankToEmpty(String value) {
        return value == null || value.isBlank() ? "" : value.trim();
    }

    private String blankToNull(String value) {
        return value == null || value.isBlank() ? null : value.trim();
    }

    private String toString(Object value) {
        return value == null ? "" : String.valueOf(value);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for (byte item : hash) {
                builder.append(String.format("%02x", item));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException exception) {
            throw new IllegalStateException("Không thể mã hóa mật khẩu", exception);
        }
    }
}
