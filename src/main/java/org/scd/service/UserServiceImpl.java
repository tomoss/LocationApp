package org.scd.service;

import org.scd.config.exception.BusinessException;
import org.scd.model.User;
import org.scd.model.dto.UserLoginDTO;
import org.scd.model.dto.UserRegisterDTO;
import org.scd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) throws BusinessException{

        if(Objects.isNull(userLoginDTO)){
            throw new BusinessException(401,"Body null !");
        }

        if(Objects.isNull(userLoginDTO.getEmail())){
            throw new BusinessException(400,"Email cannot be null !");
        }

        if(Objects.isNull(userLoginDTO.getPassword())){
            throw new BusinessException(400,"Password cannot be null !");
        }

        final User user = userRepository.findByEmail(userLoginDTO.getEmail());

        if(Objects.isNull(user)){
            throw new BusinessException(401,"Bad credentials !");
        }

        if(!passwordEncoder.matches(userLoginDTO.getPassword(),user.getPassword())){
            throw new BusinessException(401,"Bad credentials !");
        }

        return  user;
    }

    @Override
    public User register(UserRegisterDTO userRegisterDTO) throws BusinessException{

        return  null;
    }



}
