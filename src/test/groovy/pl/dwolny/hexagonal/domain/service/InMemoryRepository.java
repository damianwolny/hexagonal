package pl.dwolny.hexagonal.domain.service;

import lombok.SneakyThrows;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class InMemoryRepository<T, ID extends Serializable> {

	protected Map<ID, T> database = new HashMap<>();

	public T save(T entity) {

		final ID id = (ID) getId(entity);

		if (findById(id).isPresent()) {
			throw new IllegalStateException("inserting duplicating entry with id: " + id);
		}

		database.put(id, entity);
		return entity;
	}

	public List<T> findAll() {

		return new ArrayList<>(database.values());
	}

	public Optional<T> findById(ID id) {

		return Optional.ofNullable(database.get(id));
	}

	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {

		throw new RuntimeException("Not Implemented");
	}

	public boolean existsById(ID id) {

		throw new RuntimeException("Not Implemented");
	}

	public Iterable<T> findAllById(Iterable<ID> ids) {

		throw new RuntimeException("Not Implemented");
	}

	public long count() {

		throw new RuntimeException("Not Implemented");
	}

	public void deleteById(ID id) {

		throw new RuntimeException("Not Implemented");
	}

	public void delete(T entity) {

		throw new RuntimeException("Not Implemented");
	}

	public void deleteAll(Iterable<? extends T> entities) {

		throw new RuntimeException("Not Implemented");
	}

	public void deleteAll() {

		throw new RuntimeException("Not Implemented");
	}

	@SneakyThrows
	private static Object getId(Object t) {

		return MethodUtils.invokeMethod(t, "getId");
	}
}