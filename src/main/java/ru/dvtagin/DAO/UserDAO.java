package ru.dvtagin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dvtagin.model.User;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {
    @Query("select u from User u join fetch u.roles where u.username = :username")
    User findByUsername(@Param("username")String username);
}
