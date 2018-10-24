package org.scd.service;

import org.scd.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * Get existing list of users from database
     * @return
     */
    List<User> getUsers();

    /**
     * Login into application
     * @param userData - user information
     * @return
     */
    User login(Map<String, String> userData) throws Exception;
}
