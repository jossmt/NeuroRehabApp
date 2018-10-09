package com.app.neurorehab.persistence.repository;

import com.app.neurorehab.persistence.model.RolePersistenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Component
public interface RoleRepository extends CrudRepository<RolePersistenceModel, Long> {

    @Transactional
    @Query(value = "SELECT * FROM Role WHERE Role.role = :name ", nativeQuery = true)
    RolePersistenceModel findByName(@Param("name") final String name);
}
