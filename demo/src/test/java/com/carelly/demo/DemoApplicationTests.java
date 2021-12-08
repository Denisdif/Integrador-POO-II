package com.carelly.demo;

import java.util.ArrayList;
import java.util.List;

import com.carelly.demo.model.Rol;
import com.carelly.demo.model.TipoMasaje;
import com.carelly.demo.model.User;
import com.carelly.demo.repository.IRolJpaRepository;
import com.carelly.demo.repository.ITipoMasajeRepository;
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

	@Autowired
    ITipoMasajeRepository tipoRepo;

	@Test
	public void crearUserTest() {
		rolRepo.save(new Rol("ADMIN"));
		rolRepo.save(new Rol("CLIENTE"));

		List<Rol> adminRoles = new ArrayList<>();
        adminRoles.add(rolRepo.findByRol("ADMIN"));

		List<Rol> clienteRoles = new ArrayList<>();
        clienteRoles.add(rolRepo.findByRol("CLIENTE"));

		User admin = new User("admin",encoder.encode("12345"),adminRoles);
		User cliente = new User("cliente",encoder.encode("12345"),clienteRoles);

		userRepo.save(admin);
		userRepo.save(cliente);

		TipoMasaje masaje = new TipoMasaje("Masaje para contracturas", "Este tipo de masaje se enfoca en eliminar contracturas musculares", 60, true);
		tipoRepo.save(masaje);
	}
}
