package practise.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUser(String email) {
        User user = this.userRepository.findByEmail(email);
        return user;
    }

    public List<User> findAllUsers() {
        List<User> users = (List<User>) this.userRepository.findAll();
        return users;
    }

}
