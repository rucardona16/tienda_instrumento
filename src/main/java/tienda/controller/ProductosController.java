package tienda.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tienda.model.Productos;
import tienda.repository.ProductosRepository;

@Controller
@RequestMapping(path="/productos")
public class ProductosController {
	
	@Autowired
	ProductosRepository productosRepository;
	
	@CrossOrigin
	@PostMapping(path="")
	@ResponseBody 
	public ResponseEntity<?> addNewUser(@RequestBody Productos producto) {
		try {
			productosRepository.save(producto);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
		
	@CrossOrigin
	@GetMapping(path="/{nombre}")
	@ResponseBody 
	public ResponseEntity<Iterable<Productos>> addNewUser(@PathVariable(value = "nombre") String nombre) {
		try {
			Iterable<Productos> listaProductos = productosRepository.findByNombrel(nombre);
			if(((Collection<?>)listaProductos).size() == 0){
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<Iterable<Productos>>(listaProductos, HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
 
}
