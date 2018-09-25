package com.metacube.training.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import com.metacube.training.model.EmployeeRole;
import com.metacube.training.serviceInterface.EmployeeRolesService;
import com.metacube.training.serviceInterface.EmployeeServiceInterface;

@Component
public class CustomAuthentication implements AuthenticationProvider {

	@Autowired
	private EmployeeServiceInterface employeeService;

	@Autowired
	private EmployeeRolesService employeeRolesService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String email = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());

		if (!(employeeService.validateLogin(email, password))) {
			throw new BadCredentialsException(
					"External system authentication failed");
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		List<EmployeeRole> roleList = employeeRolesService
				.getInfoByEmail(email);

		for (EmployeeRole role : roleList) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return new UsernamePasswordAuthenticationToken(email, password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}