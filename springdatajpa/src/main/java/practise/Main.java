package practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import practise.access.Access;
import practise.user.User;
import practise.user.UserService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        UserService userService = context.getBean(UserService.class);
        for (User user : userService.findAllUsers()) {
            System.out.println(user.getId() + " " + user.getEmail());
            for (Access access : user.getAccessList()) {
                System.out.println(access.getId().getUserId() + " " + access.getOrganization());
            }
        }
    }

}
