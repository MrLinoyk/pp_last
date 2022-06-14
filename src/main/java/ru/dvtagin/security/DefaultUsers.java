package ru.dvtagin.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.dvtagin.DAO.RoleDAO;
import ru.dvtagin.DAO.UserDAO;
import ru.dvtagin.model.Role;
import ru.dvtagin.model.User;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DefaultUsers {
    @Bean
    CommandLineRunner addDefault (RoleDAO roleDAO, UserDAO userDAO, PasswordEncoder passwordEncoder) {
        return args -> {
            Set<Role> roles1 = new HashSet<>();
            roles1.add(roleDAO.findById(1L).orElse(null));
            roles1.add(roleDAO.findById(2L).orElse(null));
            Set <Role> roles2 = new HashSet<>();
            roles2.add(roleDAO.findById(2L).orElse(null));
            userDAO.save(new User("Dmitry", "Vtagin", (byte) 16,
                    "admin@mail.ru", "admin", passwordEncoder.encode("admin"), roles2));
            userDAO.save(new User("Nika", "Vtagina",
                    (byte)24, "user@mail.ru", "user", passwordEncoder.encode("user"), roles1));

        };
    }
}
