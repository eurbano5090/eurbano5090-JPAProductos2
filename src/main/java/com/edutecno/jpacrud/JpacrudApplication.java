package com.edutecno.jpacrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edutecno.jpacrud.modelo.Producto;
import com.edutecno.jpacrud.repository.ProductoRepository;

@SpringBootApplication
public class JpacrudApplication {

	private static final Logger log= LoggerFactory.getLogger(JpacrudApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JpacrudApplication.class, args);
	}
	@Bean
   public CommandLineRunner inicioApp(ProductoRepository repo) {
	   return (args)->{
		   repo.save(new Producto(null,"librero",109,"0"));
		   repo.save(new Producto(null,"tocadiscos",104,"3"));
		   repo.save(new Producto(null,"pandero",123,"2"));
		   
		   log.info("lista de productos a mostrar");
		   for(Producto producto:repo.findAll()) {
			   log.info(producto.toString());
		   }
   };
	
}
}