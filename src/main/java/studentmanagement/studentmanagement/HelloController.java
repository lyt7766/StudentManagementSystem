package studentmanagement.studentmanagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/helo")
    public String hello(){
        return "HelloWord";
    }
}
