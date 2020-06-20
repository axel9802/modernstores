package pe.edu.upc.modernstores.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.modernstores.model.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	
}