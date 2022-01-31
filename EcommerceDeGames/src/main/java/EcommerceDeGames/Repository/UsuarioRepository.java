package EcommerceDeGames.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import EcommerceDeGames.Model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	
	public Optional<UsuarioModel> findByUsuario(String usuario);
	
}
