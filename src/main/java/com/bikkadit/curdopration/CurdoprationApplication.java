package com.bikkadit.curdopration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bikkadit.curdopration.dao.RoleRepo;
import com.bikkadit.curdopration.helper.AppConstant;
import com.bikkadit.curdopration.model.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class CurdoprationApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CurdoprationApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("xyz"));
		
		try {
			Role role = new Role();

			role.setRoleId(AppConstant.USER_ADMIN);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();

			role1.setRoleId(AppConstant.USER_NORMAL);
			role1.setName("ROLE_NORMAL");

			List<Role> list = List.of(role, role1);

			List<Role> list2 = this.roleRepo.saveAll(list);

			list2.forEach(l -> {
				System.out.println(l.getName());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


