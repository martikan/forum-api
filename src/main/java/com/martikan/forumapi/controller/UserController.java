package com.martikan.forumapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.martikan.forumapi.model.tables.pojos.Account;
import com.martikan.forumapi.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Account>> getUsers(@RequestParam(name = "size", required = false, defaultValue = "25") final Integer size,
                                                  @Valid @RequestBody(required = false) final List<Account> previousPage) {
        
        return ResponseEntity.ok(previousPage == null ? userService.findTopN(size) : userService.findNextN(size, previousPage));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getUserById(@PathVariable("id") final Long id) throws Exception {
        return ResponseEntity.ok(userService.findById(id));
    }

}
