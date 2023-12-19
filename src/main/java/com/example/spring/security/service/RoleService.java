package com.example.spring.security.service;

import com.example.spring.security.entities.Role;
import com.example.spring.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void deleteRole(Role role){
        roleRepository.delete(role);
    }

    public Role getRoleById(int id){
        return roleRepository.findById(id).orElse(null);
    }

    public Role updateRole(int id,Role role){
        Role roleById = this.roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        roleById.setDescription(role.getDescription());
        return this.roleRepository.save(roleById);
    }
}
