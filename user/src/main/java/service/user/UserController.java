package service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(@RequestParam("uid") String uid){
        return userService.getUser(uid);
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userService.newUser(user);
    }
}
