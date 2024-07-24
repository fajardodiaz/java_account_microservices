package com.securityandcoding.accounts.service.impl;

import com.securityandcoding.accounts.dto.CustomerDto;
import com.securityandcoding.accounts.repository.AccountsRepository;
import com.securityandcoding.accounts.repository.CustomerRepository;
import com.securityandcoding.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService {
    
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * 
     * @param customerDto - Account Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        
    }
}
