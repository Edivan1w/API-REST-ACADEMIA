package me.dio.academia.digital.config.userConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public void postUser(@RequestBody User user) {
		System.out.println("chegou aqui");
		userService.createUser(user);
	}
	
}
