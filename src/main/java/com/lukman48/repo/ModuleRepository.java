package com.lukman48.repo;

import com.lukman48.domain.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Long> {

}
