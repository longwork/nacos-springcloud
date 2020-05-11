package wimi.masterlink.comtroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wimi.masterlink.entity.User;
import wimi.masterlink.service.UserService;

import java.util.List;

/**
 * @author : wenchao.long
 * @date : Created in 2020/04/29 17:31
 */
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/long")
    public List<User> test() {
        return userService.list();
    }
}
