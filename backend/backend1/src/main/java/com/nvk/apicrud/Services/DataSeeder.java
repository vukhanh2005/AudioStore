package com.nvk.apicrud.Services;

import com.nvk.apicrud.Entity.Account;
import com.nvk.apicrud.Repository.AccountsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    AccountsRepository accountsRepository;
    PasswordEncoder passwordEncoder;
    public DataSeeder(AccountsRepository accountsRepository, PasswordEncoder passwordEncoder){
        this.accountsRepository = accountsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(accountsRepository.findByUsername("admin").isEmpty()){
            System.out.println("Creating admin account......");
            Account adminAccount = new Account();
            String hashPassword = passwordEncoder.encode("vukhanh2411");

            adminAccount.setUsername("admin");
            adminAccount.setPassword(hashPassword);
            adminAccount.setAddress("Vinh Phuc");
            adminAccount.setEmail("nvk12a4@gmail.com");
            adminAccount.setPhone("0377516977");
            adminAccount.setFullName("Nguyen Vu Khanh");
            adminAccount.setRole("ROLE_ADMIN");

            accountsRepository.save(adminAccount);
            System.out.println("Created admin account----------------v;");
        }
    }
}
