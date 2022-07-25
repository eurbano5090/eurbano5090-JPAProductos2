package com.edutecno.jpacrud.service;

import com.edutecno.jpacrud.VO.ProductoVO;
import com.edutecno.jpacrud.modelo.Producto;

public interface ProductoService {

	public ProductoVO getAllProductos();

	public ProductoVO findById(Integer id);

	public ProductoVO add(Producto producto);

	public ProductoVO update(Producto producto);

	public ProductoVO delete(Producto producto);

	
}
