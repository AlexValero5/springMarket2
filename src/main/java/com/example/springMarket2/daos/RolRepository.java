package com.example.springMarket2.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springMarket2.entidades.Rol;

@Repository
@Component("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Long>{

}
