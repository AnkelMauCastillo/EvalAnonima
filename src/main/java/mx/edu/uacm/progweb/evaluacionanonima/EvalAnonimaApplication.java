package mx.edu.uacm.progweb.evaluacionanonima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EvalAnonimaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvalAnonimaApplication.class, args);
	}

}
