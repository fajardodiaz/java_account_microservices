package com.securityandcoding.accounts.service.impl;

import com.securityandcoding.accounts.constants.AccountsConstants;
import com.securityandcoding.accounts.dto.CustomerDto;
import com.securityandcoding.accounts.entity.Accounts;
import com.securityandcoding.accounts.entity.Customer;
import com.securityandcoding.accounts.exception.CustomerAlreadyExistsException;
import com.securityandcoding.accounts.mapper.CustomerMapper;
import com.securityandcoding.accounts.repository.AccountsRepository;
import com.securityandcoding.accounts.repository.CustomerRepository;
import com.securityandcoding.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

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
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        
        // Validations
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        Optional<Customer> optionalCustomerByEmail = customerRepository.findByEmail(customerDto.getEmail());
        // Validate if the mobile number is registered
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number " + customerDto.getMobileNumber());
        }
        // Validate if the email is registered
        if (optionalCustomerByEmail.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with email " + customerDto.getEmail());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }
    
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}
