package ar.com.avantrip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.avantrip.binding.ScoreResquest;

@Repository
public interface ScoreRepository extends CrudRepository<ScoreResquest, Long> {
}
