package com.nvk.apicrud.Services;

import com.nvk.apicrud.DTO.Account.AccountRequest;
import com.nvk.apicrud.DTO.Account.AccountResponse;
import com.nvk.apicrud.Entity.Account;
import com.nvk.apicrud.Repository.AccountsRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AccountService {
    public static final String SESSION_ACCOUNT = "currentAccount";

    private final AccountsRepository accountsRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountsRepository accountsRepository, PasswordEncoder passwordEncoder) {
        this.accountsRepository = accountsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void login(AccountRequest request, HttpSession session) {
        String username = request.getUsername();
        String password = request.getPassword();
        String hashPassword = passwordEncoder.encode(password);
    }

    public void register(AccountRequest request, HttpSession session) {
        String username = request.getUsername();
        String password = request.getPassword();
        String hashPassword = passwordEncoder.encode(password);

        Account account = new Account();

        account.setFullName(request.getFullName());
        account.setUsername(request.getUsername());
        account.setPassword(hashPassword);
        account.setPhone(request.getPhone());
        account.setEmail(request.getEmail());
        account.setAddress(request.getAddress());

        accountsRepository.save(account);
    }

    public AccountResponse currentAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();
        if(!(principal instanceof Account)){
            System.out.println("Not login ever");
            return null;
        }else{
            Account account = (Account) authentication.getPrincipal();
            AccountResponse response = new AccountResponse(
                    account.getId(),
                    account.getFullName(),
                    account.getUsername(),
                    account.getEmail(),
                    "mmb",
                    account.getRole()
            );
            return response;
        }
    }

    public Optional<Account> findAccountByUsername(String username){
        return accountsRepository.findByUsername(username);
    }
    public void logout(HttpSession session) {
        session.invalidate();
    }

    private void validateLogin(AccountRequest request) {
    }

    private void validateRegister(AccountRequest request) {
    }

    private boolean passwordMatches(String rawPassword, Object savedPassword) {
        return true;
    }

    private AccountResponse toResponse(Account account, String message) {
        return null;
    }



    private String toString(Object value) {
        return value == null ? "" : String.valueOf(value);
    }
}
