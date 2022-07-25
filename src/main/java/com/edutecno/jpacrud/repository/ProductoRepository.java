package com.edutecno.jpacrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.jpacrud.modelo.Producto;


@Repository
 public interface ProductoRepository extends CrudRepository<Producto,Integer> {


	
	
}
