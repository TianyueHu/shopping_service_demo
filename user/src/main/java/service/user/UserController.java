package service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public User getUser(String uid){
        return userService.getUser(uid);
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userService.newUser(user);
    }
}
