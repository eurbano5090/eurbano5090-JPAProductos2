package com.edutecno.jpacrud.service.Impl;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutecno.jpacrud.VO.ProductoVO;
import com.edutecno.jpacrud.modelo.Producto;
import com.edutecno.jpacrud.repository.ProductoRepository;
import com.edutecno.jpacrud.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	private static final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

	@Autowired
	ProductoRepository dao;

	ProductoVO respuesta;


	@Override
	@Transactional
	public ProductoVO findById(Integer id) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "ocurrio un error", "102");
		try {
			Producto producto=dao.findById(id).get();
			respuesta.setMensaje("se encuentra producto:" + producto.getNombreProducto());
			respuesta.setCodigo("0");

		} catch (Exception e) {
			log.trace("Usuario Service: Error en metodo findById()", e);
		}
		return respuesta;
		
	}


	@Override
	@Transactional
	public ProductoVO getAllProductos() {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "ocurrio un error", "102");
		try {
			respuesta.setProductos((List<Producto>) dao.findAll());
			respuesta.setMensaje("se han encontrado usuarios");
			respuesta.setCodigo("0");

		} catch (Exception e) {
			log.trace("Usuario Service: Error en metodo getAllUsuarios()", e);
		}
		return respuesta;
	}


	@Override
	@Transactional
	public ProductoVO add(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "ocurrio un error", "102");
		try {
			dao.save(producto);
			respuesta.setMensaje("se agrego :" + producto.getNombreProducto());
			respuesta.setCodigo("0");

		} catch (Exception e) {
			log.trace("Usuario Service: Error en metodo update()", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO update(Producto producto) {
	respuesta = new ProductoVO(new ArrayList<Producto>(), "ocurrio un error", "102");
		try {
			dao.save(producto);
			respuesta.setMensaje("se actualizo producto :" + producto.getNombreProducto());
			respuesta.setCodigo("0");

		} catch (Exception e) {
			log.trace("Producto Service: Error en metodo update()", e);
		}
		return respuesta;

		
	}

	@Override
	@Transactional
	public ProductoVO delete(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "ocurrio un error", "102");
		try {
			dao.delete(producto);
			respuesta.setMensaje("se borro usuario :" +producto.getNombreProducto());
			respuesta.setCodigo("0");

		} catch (Exception e) {
			log.trace("Usuario Service: Error en metodo delete()", e);
		}
		return respuesta;
	}
	}

	

		
	


