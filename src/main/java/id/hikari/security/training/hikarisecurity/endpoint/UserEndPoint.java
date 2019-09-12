package id.hikari.security.training.hikarisecurity.endpoint;

import id.hikari.security.training.hikarisecurity.core.impl.BaseEndPointImpl;
import id.hikari.security.training.hikarisecurity.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserEndPoint extends BaseEndPointImpl<User,Long> {
}
