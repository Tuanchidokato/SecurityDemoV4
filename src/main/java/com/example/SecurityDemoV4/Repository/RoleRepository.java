package com.example.SecurityDemoV4.Repository;

import com.example.SecurityDemoV4.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {

}
