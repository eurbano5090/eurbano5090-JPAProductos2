package com.edutecno.jpacrud.controlador;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.edutecno.jpacrud.VO.ProductoVO;

import com.edutecno.jpacrud.modelo.Producto;

import com.edutecno.jpacrud.service.ProductoService;

@Controller
public class ProductoController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService svc;
	
	public ProductoController() {
		new ArrayList<Producto>();
		
	}
	public void setProducto(Producto producto) {
	}
	
@GetMapping({"/","/home"})
public String home(Model model) {
	model.addAttribute("VO",svc.getAllProductos());
	
	return "home";
	
}
/*@GetMapping({"/","/home"})
public String getProductoList(ModelMap model) {
	if(producto.getIdProducto()>0) {
		listaproductos.add(producto);
	}
	model.put("listaproductos",listaproductos);
	return "home";
}*/

@GetMapping("/editarForm")
public ModelAndView editarForm(Model model, @RequestParam String idProducto, RedirectAttributes ra) {
   ProductoVO respuestaServicio = new ProductoVO();
    respuestaServicio.setMensaje("UPPS! Intente nuevamente");
    try {
        Integer id = (Integer.parseInt(idProducto));
        respuestaServicio = svc.findById(id);
        model.addAttribute("mensaje", respuestaServicio.getMensaje());
        model.addAttribute("VO", respuestaServicio.getCodigo());
        return new ModelAndView("editar");
    } catch (Exception e) {
        log.error("Error", e);
    }
    ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
    respuestaServicio = svc.getAllProductos();
    return new ModelAndView("redirect:/home");
}

/**
 * Llama al método del servicio que se encarga de actualizar los datos del
 * usuario en base de datos
 */
@PostMapping("/editar")
public ModelAndView editar(@ModelAttribute Producto producto, RedirectAttributes ra) {
    ProductoVO respuestaServicio = svc.update(producto);
    ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
    if (respuestaServicio.getCodigo().equals("0")) {
        return new ModelAndView("redirect:/home");
    } else {
        return new ModelAndView("redirect:/editarForm");
    }
}

/**
 * Abre el formulario de creación de usuarios
 */
@GetMapping("/agregarForm")
public String agregarForm(Model model) {
    return "agregar";
}

/**
 * Llama al método del servicio que se encarga de crear los datos del usuario en
 * base de datos
 */
@PostMapping("/agregar")
public ModelAndView agregarSubmit(@ModelAttribute Producto producto, RedirectAttributes ra) {
    ProductoVO respuestaServicio = svc.add(producto);
    ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
    if (respuestaServicio.getCodigo().equals("0")) {
        return new ModelAndView("redirect:/home");
    } else {
        return new ModelAndView("redirect:/agregarForm");
    }
}

/**
* Llama al método del servicio que se encarga de eliminar los datos
del usuario en base de datos
* y redirecciona al home.
*/
@GetMapping("/eliminar")
public ModelAndView eliminar(Model model, @RequestParam String idProducto, RedirectAttributes ra) {
   ProductoVO respuestaServicio = new ProductoVO();
    respuestaServicio.setMensaje("No se pudo eliminar al usuario, intente nuevamente.");

    try {
        Producto eliminado = new Producto();
        eliminado.setIdProducto(Integer.parseInt(idProducto));
        respuestaServicio = svc.delete(eliminado);
        ra.addFlashAttribute("mensaje",
        respuestaServicio.getMensaje());
        return new ModelAndView("redirect:/home");
    } catch (Exception e) {
        log.error("Error en UsuarioController eliminar", e);
    }
    ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
    respuestaServicio = svc.getAllProductos();
    ra.addAttribute("VO", respuestaServicio);
    return new ModelAndView("redirect:/home");
}
@PostMapping("/buscar")
public ModelAndView buscar(@ModelAttribute Integer id, RedirectAttributes ra) {
    ProductoVO resultado = svc.findById(id);
    ra.addFlashAttribute("mensaje", resultado.getMensaje());
    if (resultado.getCodigo().equals("0")) {
        return new ModelAndView("redirect:/home");
    } else {
        return new ModelAndView("redirect:/buscarForm");
    }
}

@GetMapping("/buscarForm")
public String buscarForm(Model model) {
	
    return "buscar";
}
}