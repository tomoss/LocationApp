package org.scd.repository;

import org.scd.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * User Repository
 */
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * Find user by email
     * @param email - unique email address
     * @return
     */
    User findByEmail(final String email);

    Optional<User> findById(final Long id);

    User save(User user);
}