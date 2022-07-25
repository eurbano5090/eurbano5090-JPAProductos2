package com.edutecno.jpacrud.VO;

import java.util.List;
import com.edutecno.jpacrud.modelo.Producto;



public class ProductoVO extends GenericVO{
List<Producto> productos;
 
  
  public ProductoVO(List<Producto> productos,String mensaje, String codigo) {
	  super(mensaje,codigo);
	  this.productos=productos;	  
  } 
  
@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
}

@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}

public ProductoVO() {
	super();
}

public void setProductos(List<Producto> productos) {
	this.productos = productos;
}

public ProductoVO(List<Producto> productos) {
	super();
	this.productos = productos;
}

public List<Producto> getProductos() {
	return productos;
}
	
}



  
	

