package org.mvpsuite.repository;

import org.mvpsuite.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    User existsByUsername(@Param("userName") String userName);

}
