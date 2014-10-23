package sample.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class Srap extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.sources(Srap.class);
		return super.configure(application);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Srap.class, args);
	}

}
