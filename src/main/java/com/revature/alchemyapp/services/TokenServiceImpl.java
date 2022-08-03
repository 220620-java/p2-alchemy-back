package com.revature.alchemyapp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.alchemyapp.auth.JWTConfig;
import com.revature.alchemyapp.exceptions.FailedAuthenticationException;
import com.revature.alchemyapp.exceptions.TokenExpirationException;
import com.revature.alchemyapp.models.User;
import com.revature.alchemyapp.models.dtos.UserDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Service
public class TokenServiceImpl implements TokenService {
	private JWTConfig jwtConfig;
	
	public TokenServiceImpl(JWTConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	@Override
	public String createToken(User user) {
		String jws = "";
		
		if (user!=null && user.getUsername()!=null) {
			long now = System.currentTimeMillis();
			
			// JWS: signed JWT
			// here we are building the JWS by setting the "claims".
			// some claims are public claims like id, subject, issuer, etc.
			// whereas role is a custom one that we are adding
			jws = Jwts.builder()
					.setId(String.valueOf(user.getId()))
					.setSubject(user.getUsername())
					.claim("role", user.getRole().getName())
					.setIssuer("alchemyapp")
					.setIssuedAt(new Date(now))
					.setExpiration(new Date(now + jwtConfig.getExpiration()))
					.signWith(jwtConfig.getSigningKey())
					.compact();
		}
		return jws;
	}

	@Override
	public Optional<UserDTO> validateToken(String token) throws FailedAuthenticationException, TokenExpirationException {
		try {
			Claims jwtClaims = Jwts.parserBuilder()
				.setSigningKey(jwtConfig.getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
			
			long now = System.currentTimeMillis();
			if (jwtClaims.getExpiration().before(new Date(now))) {
				throw new TokenExpirationException();
			}
			
			UserDTO userDto = parseUser(jwtClaims);
			
			return Optional.of(userDto);
		} catch (JwtException e) {
			throw new FailedAuthenticationException();
		}
	}

	@Override
	public int getDefaultExpiration() {
		return jwtConfig.getExpiration();
	}
	
//	private UserDTO parseUser(Claims claims) {
//		int id = Integer.parseInt(claims.getId());
//		String username = claims.getSubject();
//		Role role = new Role();
//		role.setName(claims.get("role").toString());
//		
//		return new UserDTO(id, username, role, null);
//	}
}
