package com.creditgame.Controller;

import com.creditgame.Service.UserCreditServices;
import com.creditgame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("")
public class controller {
    @Autowired
    private UserCreditServices userCreditServices;

    @GetMapping("/home")
    private  String gethome()
    {
        return "credit";
    }

    @GetMapping("/home/users")
    private String getUsers(Model model){
        List<User> users = userCreditServices.listUsers();
        System.out.println(users);
        model.addAttribute("user",users);
        return "credit2";
    }

    @PostMapping("/home/{id}")
    public String createSpaceshipInDatabase( User user,
                                             BindingResult bindingResult, Model model, @PathVariable Integer id){


        if (bindingResult.hasErrors()) {
            return "error";
        }
        User userf = userCreditServices.getuser(user.getId());
        User usert =userCreditServices.getUserByName(user.getName());
        Integer temp = user.getCredit();
        userf.setCredit(userf.getCredit()-temp);
        usert.setCredit(usert.getCredit()+temp);
        userCreditServices.updateTransferCredit(userf);
        userCreditServices.updateTransferCredit(usert);
        return "redirect:/home/users";
    }
}
