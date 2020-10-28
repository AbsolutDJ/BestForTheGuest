package projektarbete.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektarbete.demo.House;
import projektarbete.demo.User;
import projektarbete.demo.repository.IUserCrud;

@Service
public class UserService {

    @Autowired
    private IUserCrud crud;

    public User addUser(User user){return crud.addUser(user);}
}
