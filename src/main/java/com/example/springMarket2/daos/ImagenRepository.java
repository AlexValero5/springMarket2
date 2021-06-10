package com.example.springMarket2.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springMarket2.entidades.Imagen;


@Repository
public interface ImagenRepository extends CrudRepository<Imagen, Long>{

}
