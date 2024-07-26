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

    /**
     * 
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update was successfully or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param email - User Email
     * @return boolean indicating if the delete action was successfully or not
     */
    boolean deleteAccount(String email);
}
