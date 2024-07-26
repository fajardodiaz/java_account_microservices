package com.securityandcoding.accounts.controller;

import com.securityandcoding.accounts.constants.AccountsConstants;
import com.securityandcoding.accounts.dto.CustomerDto;
import com.securityandcoding.accounts.dto.ResponseDto;
import com.securityandcoding.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
//@AllArgsConstructor
public class AccountsController {
    private IAccountsService iAccountsService;
    
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetailsByEmail(@RequestParam String email){
        CustomerDto customerDto = iAccountsService.fetchAccountByEmail(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }
    
    @GetMapping("/fetch/mobile")
    public ResponseEntity<CustomerDto> fetchAccountDetailsByMobileNumber(@RequestParam String mobile){
        CustomerDto customerDto = iAccountsService.fetchAccountByMobileNumber(mobile);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }
    
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@RequestBody CustomerDto customerDto){
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam String email){
        boolean isDeleted = iAccountsService.deleteAccount(email);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
}
