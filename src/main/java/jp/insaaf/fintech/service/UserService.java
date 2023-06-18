package jp.insaaf.fintech.service;

import jp.insaaf.fintech.data.entity.User;
import jp.insaaf.fintech.data.model.ResponseModel;
import jp.insaaf.fintech.data.repository.AddressRepository;
import jp.insaaf.fintech.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User createUser(User user) {
        user.setJpAddress(addressRepository.save(user.getJpAddress()));
        user.setBdAddress(addressRepository.save(user.getBdAddress()));
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public ResponseEntity<Object> loginWithEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.isPresent() && user.get().getPassword().equals(password)){
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("bad credentials");
    }
}
