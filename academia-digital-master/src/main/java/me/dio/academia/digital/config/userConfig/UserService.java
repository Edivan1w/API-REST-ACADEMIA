package me.dio.academia.digital.config.userConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void createUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	

}
