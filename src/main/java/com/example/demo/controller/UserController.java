package com.example.demo.controller;

import com.example.demo.repository.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/users")
public class UserController {

//    @Autowired //ID полем
//    private final UserService userService;

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService; // ID конструктором
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable(name = "id") Long id) { // @PathVariable(name = "id") если поле id отличается
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestParam(required = false)String email,
                       @RequestParam(required = false)String name){
        userService.update(id, email, name);
    }
}
