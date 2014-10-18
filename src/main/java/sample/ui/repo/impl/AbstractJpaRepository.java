package sample.ui.repo.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractJpaRepository<T, ID extends Serializable> implements JpaRepository<T, ID> {

	@Override
	public Page<T> findAll(Pageable pageable) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public <S extends T> S save(S entity) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public T findOne(Serializable id) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public boolean exists(Serializable id) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public long count() {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public void delete(Serializable id) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public void delete(T entity) {
		throw new RuntimeException("Not Yet Implemented.");

	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public void deleteAll() {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public List<T> findAll() {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public List<T> findAll(Sort sort) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public List<T> findAll(Iterable<ID> ids) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public void flush() {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		throw new RuntimeException("Not Yet Implemented.");

	}

	@Override
	public void deleteAllInBatch() {
		throw new RuntimeException("Not Yet Implemented.");
	}

	@Override
	public T getOne(Serializable id) {
		throw new RuntimeException("Not Yet Implemented.");
	}

}
