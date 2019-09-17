package id.hikari.security.training.hikarisecurity.endpoint.support;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminEndPoint {


    @GetMapping("/index")
    public String testAdmin(){
        return "admin/index";
    }


}
