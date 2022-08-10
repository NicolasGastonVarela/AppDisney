package com.AppDisney.AppDisney.Repository;

import com.AppDisney.AppDisney.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> findByName(String name);

}
