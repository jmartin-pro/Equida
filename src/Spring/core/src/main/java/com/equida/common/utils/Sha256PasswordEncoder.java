package com.equida.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence cs) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
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
