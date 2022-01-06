package mx.edu.uacm.progweb.evaluacionanonima;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordTest {

	@Test
	public void encodePasswordTest() {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "1234";
		String encodePassword = bCryptPasswordEncoder.encode(rawPassword);
		System.out.println(encodePassword);
		
		boolean matches = bCryptPasswordEncoder.matches(rawPassword, encodePassword);
		assertThat(matches).isTrue();
	}
}
