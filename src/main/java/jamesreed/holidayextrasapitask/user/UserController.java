package jamesreed.holidayextrasapitask.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/{id}")
    public UserDto get(@PathVariable final Long id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public UserDto upsert(@RequestBody final UserDto userDto) {
        return userService.upsert(userDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void delete(@PathVariable final Long id) {
        userService.delete(id);
    }

    @RequestMapping(value = "/user")
    public List<UserDto> list() {
        return userService.list();
    }
}
