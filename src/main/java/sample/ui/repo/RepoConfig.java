package sample.ui.repo;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import sample.ui.domain.Server;

@Configuration
@ComponentScan
public class RepoConfig {

	@Autowired
	private ServerRepository serverRepository;

	@PostConstruct
	public void checkTemplateLocationExists() {
		serverRepository.save(Server.builder()
				.name("First server")
				.endpoint("http://localhost:9980/sparklr3/oauth/authorize?client_id=tonr&state=XXX&response_type=code&scope=read&redirect_uri=http://localhost:9980/srap/oauth")
				.created(Calendar.getInstance())
				.build());

		serverRepository.save(Server.builder()
				.name("First server")
				.endpoint("http://localhost:9980/sparklr3/oauth/authorize?client_id=cli1&state=XXX&response_type=code&scope=read&redirect_uri=http://localhost:9980/srap/oauth")
				.created(Calendar.getInstance())
				.build());
	}

}
