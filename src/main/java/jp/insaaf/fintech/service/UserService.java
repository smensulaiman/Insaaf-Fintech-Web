package jp.insaaf.fintech.service;

import jp.insaaf.fintech.data.entity.User;
import jp.insaaf.fintech.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User addUser(User user) {
        return userRepository.insert(user);
    }

}
