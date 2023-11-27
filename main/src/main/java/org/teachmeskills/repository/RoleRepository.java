package org.teachmeskills.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teachmeskills.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Role getRoleByName(String nameRole);
}
