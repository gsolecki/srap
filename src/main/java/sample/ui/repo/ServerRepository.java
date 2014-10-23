package sample.ui.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.ui.domain.Server;

public interface ServerRepository extends JpaRepository<Server, Long> {
}