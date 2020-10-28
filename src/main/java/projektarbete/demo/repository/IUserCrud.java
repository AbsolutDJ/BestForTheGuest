package projektarbete.demo.repository;

import projektarbete.demo.House;
import projektarbete.demo.User;

import java.util.List;

public interface IUserCrud {

    public List<User> getAllUsers();
    public User addUser(User user);
}
