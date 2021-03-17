package com.example.accounts;

import com.example.accounts.domain.User;
import com.example.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "user", required = false,defaultValue = "World") String user,
            Map<String,Object> model
    ) {
        model.put("user", user);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String,Object> model) {
        Iterable<User> users = accountRepository.findAll();

        model.put("users", users);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String username,@RequestParam String password, Map<String,Object> model){
        User user = new User(username, password);
        accountRepository.save(user);

        Iterable<User> users = accountRepository.findAll();

        model.put("users", users);

        return "main";
    }
}
