package PP_3_1_2_Spring_security.initialization;

import PP_3_1_2_Spring_security.model.Role;
import PP_3_1_2_Spring_security.model.User;
import PP_3_1_2_Spring_security.service.RoleService;
import PP_3_1_2_Spring_security.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;


@Component
public class DbInitialization {
    private final RoleService roleService;
    private final UserService userService;


    public DbInitialization(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");

        roleService.addRole(roleUser);
        roleService.addRole(roleAdmin);

        User userAdmin = new User("admin", "admin", "admin", 32, "admin@mail.ru",Set.of(roleAdmin, roleUser));
        User userUser = new User("user", "user", "user", 25, "user@mail.ru",Set.of(roleUser));

        userService.addUser(userUser);
        userService.addUser(userAdmin);

    }

}
