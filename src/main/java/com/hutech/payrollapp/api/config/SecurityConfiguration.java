package com.hutech.payrollapp.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hutech.payrollapp.api.filter.JwtRequestFilter;
import com.hutech.payrollapp.api.repository.EmployeeRepository;
import com.hutech.payrollapp.api.serviceImpl.AdminLoginService;
import com.hutech.payrollapp.api.serviceImpl.EmployeeServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private AdminLoginService loginService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new EmployeeServiceImpl(employeeRepo);
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(employeeServiceImpl);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginService);

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()

				.antMatchers("/logintoken", "/addAdmin", "/emp", "/employeeLogin", "/empLogin", "/empLoginsucess",
						"/login", "/", "/verifyEmployee", "/reset_password", "/createPassword", "/application**",
						"/registration**", "/v2/api-docs", "/success", "/loginSucess", "/addEmployee",
						"/addMultipartfile/{empId}", "/onboardedEmployees", "/getEmployeeById/{empId}", "/addClient",
						"/onboardClient", "/verifyEmployee", "/createPassword", "/reset_password", "/createDesignation",
						"/findEmpInfo", "/paySlip", "/createBusinessUnit", "/viewBusinessUnit", "/createDepartment",
						"/createDesignation", "/createEmployeement", "/addOrganizationInfo", "/addProject",
						"/viewProject", "/createRole", "/addTimesheet", "/verify", "/forgotPasswordEmail",
						"/emp_forgot_password", "/emp_reset_password", "/addCalendarRegion", "/addHoliday",
						"/findHolidayList", "/findHolidayByRegion/{calendarRegion}", "/holidayList/{hId}", "/{hId}",
						"/check", "https://ecstatic-joliot-113494.netlify.app/", "/addDocumentInfo",
						"/uploadDocument/{id}", "/getDocument/{id}", "/getDocumentDetails/{id}",
						"/addFamilyInformation", "/getFamilyInfoById/{familyId}", "/deleteFamilyInfo/{familyId}",
						"/images/**", "/css/**", "/scripts/**","/findAdmin/{id}")
				.permitAll().anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
}