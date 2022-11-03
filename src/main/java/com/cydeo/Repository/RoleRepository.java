package com.cydeo.Repository;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    //give me the role based on the description
    // i will use derive query
    Role findByDescription(String description);

}
