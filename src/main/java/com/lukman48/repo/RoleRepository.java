package com.lukman48.repo;

import com.lukman48.domain.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Module, Long> {

}
