package ru.dvtagin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dvtagin.model.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {
}
