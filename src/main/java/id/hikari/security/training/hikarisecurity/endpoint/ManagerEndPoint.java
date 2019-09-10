package id.hikari.security.training.hikarisecurity.endpoint;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management")
public class ManagerEndPoint {

    @GetMapping("/index")
    public String testManager(){
        return "manager/index";
    }

}
