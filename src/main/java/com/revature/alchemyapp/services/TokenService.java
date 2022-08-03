package com.revature.alchemyapp.services;

import java.util.Optional;

import com.revature.alchemyapp.exceptions.FailedAuthenticationException;
import com.revature.alchemyapp.exceptions.TokenExpirationException;
import com.revature.alchemyapp.models.User;
import com.revature.alchemyapp.models.dtos.UserDTO;

public interface TokenService {
	public String createToken(User user);
	public Optional<UserDTO> validateToken(String token) throws FailedAuthenticationException, TokenExpirationException;
	public int getDefaultExpiration();
}
