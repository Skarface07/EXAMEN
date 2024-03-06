package com.TD.CommunityManager;

import com.TD.CommunityManager.enums.UserRole;
import com.TD.CommunityManager.model.User;
import com.TD.CommunityManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CommunityManagerApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CommunityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(UserRole.ADMIN);
		if (null == adminAccount){
			User user = new User();

			user.setNom("ADMIN");
			user.setPrenom("Spirit");
			user.setEmail("admin@spirit.com");
			user.setRole(UserRole.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));

			userRepository.save(user);
		}
	}

}
