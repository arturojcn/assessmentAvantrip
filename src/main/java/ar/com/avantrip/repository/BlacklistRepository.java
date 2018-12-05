package ar.com.avantrip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.avantrip.binding.BlacklistCardRequest;;

@Repository
public interface BlacklistRepository extends CrudRepository<BlacklistCardRequest, Long> {

}
