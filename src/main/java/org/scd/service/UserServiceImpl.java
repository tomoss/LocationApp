package org.scd.service;

import org.scd.model.User;
import org.scd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User login(Map<String, String> userData) throws Exception {
        final String email = userData.get("email");
        final String password = userData.get("password");

        if (Objects.isNull(email)) {
            //TODO: add custom exception handler here
            throw new Exception("Email not provided");
        }
        //TODO: check if password is provided
        if(Objects.isNull(password)) {
            //TODO: add custom exception handler here
            throw new Exception("Password not provided");
        }

        final User user = userRepository.findByEmail(email);
        //TODO: validate if user exists
        //TODO: validate if password match
         return user;



         //
         // throw new BusinessException(400,"Email not found")
         //
        /*
        @Override
        public User doLogin(LoginCredentialsDTO loginCredetialsDTO) throws BusinessException {
            if(Objects.isNull(loginCredentialsDTO)){
                throw new BusinessException(400,"Body cannot be null")
            }

            if (Objects.isNull(loginCredentialsDTO.getEmail()){

            }
            if(Objects.isNull(loginCredentialsDTO.getPassword(){
            }
            final User existingUser = userRepository.findbByEmail(loginCredetialsDTO.getEmail());
            
            if(Objects.isNull(existingUser)) {
                //bad credentials
            }

            if(!passwordEncoder.matches(loginCredentialsDTO.getPassword(), existingUser.getPassword())) {
               //bad credentials
            }

            return existingUser

        }
         */
    }
}
