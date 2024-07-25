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
@AllArgsConstructor
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
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
    
//    @GetMapping("/fetch/mobile")
//    public ResponseEntity<ResponseDto> fetchAccountDetailsByMobileNumber(@RequestParam String mobile){
//        
//    }
}
