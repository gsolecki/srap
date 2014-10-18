package sample.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import sample.ui.domain.Server;
import sample.ui.repo.ServerRepository;
import sample.ui.repo.impl.InMemoryServerRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebApp extends SpringBootServletInitializer {

	@Bean
	@ConditionalOnMissingBean
	public ServerRepository serverRepository() {
		return new InMemoryServerRepository();
	}

	@Bean
	public Converter<String, Server> serverConverter(final ServerRepository serverRepository) {
		return new Converter<String, Server>() {
			@Override
			public Server convert(String id) {
				return serverRepository.findOne(Long.valueOf(id));
			}
		};
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.sources(WebApp.class);
		return super.configure(application);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebApp.class, args);
	}

}
