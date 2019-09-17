package id.hikari.security.training.hikarisecurity.endpoint.impl;

import id.hikari.security.training.hikarisecurity.core.impl.BaseEndPointImpl;
import id.hikari.security.training.hikarisecurity.data.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserEndPoint extends BaseEndPointImpl<User,Long> {
}
