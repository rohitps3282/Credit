package com.creditgame.Service;

import com.creditgame.DOA.UserCreditRepository;
import com.creditgame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCreditServices {
    private final UserCreditRepository userCreditRepository;

    public UserCreditServices(UserCreditRepository userCreditRepository) {
        this.userCreditRepository = userCreditRepository;
    }

    public List<User> listUsers(){
        return userCreditRepository.findAll();

    }

    public User getuser(Integer id){
        return userCreditRepository.findById(id).get();
    }

    public void updateTransferCredit(User user){
        userCreditRepository.save(user);
    }

    public User getUserByName(String name){
        return userCreditRepository.findByName(name);
    }
//    public void UpdatedCredits(User user){
//
//    }
}
