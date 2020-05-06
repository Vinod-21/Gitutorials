package com.bridgelabz.fundoo.configuration;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;

@Component
public class JasonWebToken {

	final String SECRET_KEY = "vinodKumar";
	
 	public String createJWT(Long id) {
		
			// to set algorithm
			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
			// payload
			String token = JWT.create().withClaim("userId", id).sign(algorithm);
			return token;
		
		}
		
		public Long decodeJWT(String token) {
			Long userid;
			// for verification algorithm
			Verification verification = null;
			try {
				verification = JWT.require(Algorithm.HMAC256(SECRET_KEY));
			} catch (IllegalArgumentException e) {
		
				e.printStackTrace();
			}
			JWTVerifier jwtverifier = verification.build();
			// to decode token
			DecodedJWT decodedjwt = jwtverifier.verify(token);

			Claim claim = decodedjwt.getClaim("userId");
			userid = claim.asLong();
			return userid;
		}
		
	}

