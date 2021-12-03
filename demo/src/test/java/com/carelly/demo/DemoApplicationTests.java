package com.carelly.demo;

import java.util.ArrayList;
import java.util.List;

import com.carelly.demo.model.Rol;
import com.carelly.demo.model.User;
import com.carelly.demo.repository.IRolJpaRepository;
import com.carelly.demo.repository.IUserJpaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private IUserJpaRepository userRepo;

	@Autowired
	private IRolJpaRepository rolRepo;

	@Test
	public void crearUserTest() {
		List<Rol> adminRoles = new ArrayList<>();
        adminRoles.add(rolRepo.findByRol("ADMIN"));

		List<Rol> clienteRoles = new ArrayList<>();
        clienteRoles.add(rolRepo.findByRol("CLIENTE"));

		User admin = new User();
		admin.setName("admin");
		admin.setPassword(encoder.encode("12345"));
		admin.setRoles(adminRoles);

		User cliente = new User();
		cliente.setName("cliente");
		cliente.setPassword(encoder.encode("12345"));
		cliente.setRoles(clienteRoles);

		userRepo.save(cliente);
		userRepo.save(admin);
	}
}
