package com.example.controller;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Account;
import com.example.service.AccountService;

/**
 * TODO: You will need to write your own endpoints and handlers for your
 * controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use
 * the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations.
 * You should
 * refer to prior mini-project labs and lecture materials for guidance on how a
 * controller may be built.
 */
@Controller
public class SocialMediaController {

    private AccountService accountService;

    @Autowired
    public void SocialMediaController(AccountService accountService) {
        this.accountService = accountService;
    }

    /*
     * ## 1: Our API should be able to process new User registrations.
     * 
     * As a user, I should be able to create a new Account on the endpoint POST
     * localhost:8080/register. The body will contain a representation of a JSON
     * Account, but will not contain an accountId.
     * 
     * - The registration will be successful if and only if the username is not
     * blank, the password is at least 4 characters long, and an Account with that
     * username does not already exist. If all these conditions are met, the
     * response body should contain a JSON of the Account, including its accountId.
     * The response status should be 200 OK, which is the default. The new account
     * should be persisted to the database.
     * - If the registration is not successful due to a duplicate username, the
     * response status should be 409. (Conflict)
     * - If the registration is not successful for some other reason, the response
     * status should be 400. (Client error)
     */
    @PostMapping("/register")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {

        if (account.getUsername().isEmpty() || account.getPassword().length() < 4) {
            return ResponseEntity.status(400)
                    .body("Username cannot be empty and password must be at least 4 characters long.");
        }

        if (accountService.isUsernameExist(account.getUsername())) {
            return ResponseEntity.status(409).body("Username is already taken. Please choose another one.");
        }
        accountService.saveAccount(account);
        return ResponseEntity.status(200).body("Your account has be successfuly created.");
    }

    /*
     * ## 2: Our API should be able to process User logins.
     * 
     * As a user, I should be able to verify my login on the endpoint POST
     * localhost:8080/login. The request body will contain a JSON representation of
     * an Account.
     * 
     * - The login will be successful if and only if the username and password
     * provided in the request body JSON match a real account existing on the
     * database. If successful, the response body should contain a JSON of the
     * account in the response body, including its accountId. The response status
     * should be 200 OK, which is the default.
     * - If the login is not successful, the response status should be 401.
     * (Unauthorized)
     */

     @PostMapping("/login")
     public ResponseEntity <String> login (@RequestBody Account account,String username,String password) throws AuthenticationException, RuntimeException{
       
        if (account.getUsername().equals(username) && account.getPassword().equals(password)) {

            accountService.login(account.getUsername(),account.getPassword());
            return ResponseEntity.status(200).body(null);

        }else{
            return ResponseEntity.status(401).body(null);
        }


    }

     }

