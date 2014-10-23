package sample.ui.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import sample.ui.domain.Server;
import sample.ui.repo.ServerRepository;

@Configuration
public class WebConfig {

	@Bean
	public Converter<String, Server> serverConverter(final ServerRepository serverRepository) {
		return new Converter<String, Server>() {
			@Override
			public Server convert(String id) {
				return serverRepository.findOne(Long.valueOf(id));
			}
		};
	}

}
