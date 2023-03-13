package com.example.SecurityDemoV4;

import com.example.SecurityDemoV4.Model.User;
import com.example.SecurityDemoV4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityDemoV4Application  {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoV4Application.class, args);
	}
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	@Override
//	public void run(String... args) throws Exception {
//		// Khi chương trình chạy
//		// Insert vào csdl một user.
//		User user = new User();
//		user.setUsername("loda");
//		user.setPassword(passwordEncoder.encode("loda"));
//		userRepository.save(user);
//		System.out.println(user);
//	}
}
