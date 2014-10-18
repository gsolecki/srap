package sample.ui.repo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import sample.ui.domain.Server;
import sample.ui.repo.ServerRepository;

public class InMemoryServerRepository extends AbstractJpaRepository<Server, Long> implements ServerRepository {

	private static AtomicLong counter = new AtomicLong();

	private final ConcurrentMap<Long, Server> servers = new ConcurrentHashMap<Long, Server>();

	@Override
	public List findAll() {
		return new ArrayList<Server>(servers.values());
	}

	@Override
	public Server save(Server server) {
		if (server.getId() == null) {
			server.setId(counter.incrementAndGet());
		}
		servers.put(server.getId(), server);
		return server;
	}

	@Override
	public Server findOne(Long id) {
		return servers.get(id);
	}

}
