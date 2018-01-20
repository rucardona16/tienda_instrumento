package tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tienda.model.Productos;

public interface ProductosRepository extends CrudRepository<Productos, Long>, JpaRepository<Productos, Long>{
	
	@Query("select u from Productos u where u.nombre like %?1%")
	Iterable<Productos> findByNombrel(String nombre);

}
