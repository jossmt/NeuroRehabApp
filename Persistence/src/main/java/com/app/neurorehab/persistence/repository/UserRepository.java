package com.app.neurorehab.persistence.repository;

import com.app.neurorehab.persistence.model.UserPersistenceModel;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;

/**
 * User Repo Interface
 */
@Repository
@Component
public interface UserRepository extends CrudRepository<UserPersistenceModel, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT * FROM User", nativeQuery = true)
    List<UserPersistenceModel> findAllAsList();

    @Transactional
    @Query(value = "SELECT * FROM User WHERE User.email = :email ", nativeQuery = true)
    UserPersistenceModel findByEmail(@Param("email") final String email);

    @Transactional
    @Query(value = "SELECT * FROM User WHERE User.user_reference = :user_reference ", nativeQuery = true)
    UserPersistenceModel findByReference(@Param("user_reference") final String user_reference);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM UserPersistenceModel u WHERE u.email = ?1")
    Boolean emailExists(String email);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM UserPersistenceModel u WHERE u.userReference = ?1")
    Boolean userReferenceExists(String userReference);
}
