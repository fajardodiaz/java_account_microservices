package com.securityandcoding.accounts.service;

import com.securityandcoding.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * 
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    /**
     * 
     * @param email - Input email
     * @return Account details based on a given email address
     */
    CustomerDto fetchAccountByEmail(String email);

    /**
     *
     * @param mobileNumber - Input email
     * @return Account details based on a given mobile number
     */
    CustomerDto fetchAccountByMobileNumber(String mobileNumber);
}
