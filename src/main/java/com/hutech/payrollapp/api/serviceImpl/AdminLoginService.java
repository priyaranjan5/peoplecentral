package com.hutech.payrollapp.api.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.AdminLogin;
import com.hutech.payrollapp.api.repository.AdminRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminLogin adminLogin = adminRepository.findByEmpEmail(username);
		return new org.springframework.security.core.userdetails.User(adminLogin.getEmpEmail(),
				adminLogin.getPassword(), new ArrayList<>());
	}

	public String forgotPassword(String empEmail) {
		Optional<AdminLogin> admin = Optional.ofNullable(adminRepository.findByEmpEmail(empEmail));
		if (!admin.isPresent()) {
			return "Invalid email id.";
		}
		AdminLogin adm = admin.get();
		String token = RandomString.make(64);
		adm.setAdminToken(token);

		adm = adminRepository.save(adm);
		return adm.getAdminToken();
	}

	public String resetPassword(String adminToken, String password) {

		Optional<AdminLogin> userOptional = Optional.ofNullable(adminRepository.findByAdminToken(adminToken));

		if (!userOptional.isPresent()) {
			return "Invalid token.";
		}

		AdminLogin user = userOptional.get();
		user.setPassword(password);
		user.setResetPassword(password);
		user.setAdminToken(null);
		adminRepository.save(user);
		return "Your password successfully updated.";
	}

}
