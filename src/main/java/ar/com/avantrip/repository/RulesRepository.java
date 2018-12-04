package ar.com.avantrip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.avantrip.binding.RulesResquest;

@Repository
public interface RulesRepository extends CrudRepository<RulesResquest, Long> {
}
