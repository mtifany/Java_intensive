package edu.school21.sockets.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public boolean signUp(String username, String password) {
        Optional<User> optionalUser = repository.findByUsername(username);
        if (optionalUser.isPresent()){
            return false;
        }
        User user = new User(0L, username, encoder.encode(password));
        repository.save(user);
        return true;
    }


}
