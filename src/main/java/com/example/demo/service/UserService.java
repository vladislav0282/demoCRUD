package com.example.demo.service;

import com.example.demo.repository.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

   private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User create(User user){
        Optional<User> optionalUser = userRepository
                .findeByEmail(user.getEmail());
       if(optionalUser.isPresent()){
           throw new IllegalStateException("пользователь с таким email уже существует");
       }
       user.setAge(Period.between(user.getBirth(), LocalDate.now()).getYears()); // что бы автоматически рассчитывался age
        return userRepository.save(user);
    }

    public void delete(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new IllegalStateException("Пользователь с" + id + "не найден");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void update (Long id, String email, String name){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new IllegalStateException("Пользователь с" + id + "не найден");
        }

        User user = optionalUser.get();

        if(email != null && !email.equals(user.getEmail())){
            Optional<User> foundByEmail = userRepository.findeByEmail(email);
            if(foundByEmail.isPresent()){
                throw new IllegalStateException("пользователь с таким" + email+ "уже существует");
            }
            user.setEmail(email);
        }

        if(name != null && !name.equals(user.getName())){
            user.setName(name);
        }
//        userRepository.save(user);
    }
}
