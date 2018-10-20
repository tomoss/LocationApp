package org.scd.service;

import org.scd.model.User;

import java.util.List;

public interface UserService {
    /**
     * Get existing list of users from database
     * @return
     */
    List<User> getUsers();
}
