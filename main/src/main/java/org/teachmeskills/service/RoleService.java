package org.teachmeskills.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teachmeskills.model.Role;
import org.teachmeskills.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

  private final RoleRepository roleRepository;

  public Role getRoleByName(String roleName) {
    return roleRepository.getRoleByName(roleName);
  }
}
