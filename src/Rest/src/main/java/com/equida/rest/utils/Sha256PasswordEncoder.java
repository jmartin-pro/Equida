package com.equida.rest.utils;

import com.equida.rest.config.SecurityConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence cs) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(SecurityConfig.class.getName()).log(Level.SEVERE, null, ex);
		}
		md.update(cs.toString().getBytes());
		byte[] digest = md.digest();
		return new String(Hex.encode(digest));
	}


	@Override
	public boolean matches(CharSequence cs, String string) {
		return string.equals(encode(cs));
	}
}
