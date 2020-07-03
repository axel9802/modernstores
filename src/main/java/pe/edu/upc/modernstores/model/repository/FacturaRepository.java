package pe.edu.upc.modernstores.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.modernstores.model.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer>{

}
