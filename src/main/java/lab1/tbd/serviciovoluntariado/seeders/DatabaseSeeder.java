package lab1.tbd.serviciovoluntariado.seeders;

import lab1.tbd.serviciovoluntariado.config.Constants;
import lab1.tbd.serviciovoluntariado.repositories.UsuarioRepository;
import lab1.tbd.serviciovoluntariado.models.Usuario;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

// import java.util.Arrays;
// import java.util.List;

@Component
public class DatabaseSeeder {

	Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
	private UsuarioRepository userRepository;

	@Autowired
	public DatabaseSeeder(
		UsuarioRepository userRepository
	) {
		this.userRepository = userRepository;
	}

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedUsersTable();
	}

	private void seedUsersTable() {
		Usuario user = userRepository.findOneByEmail(Constants.ADMIN_EMAIL).orElse(null);
		if(user == null) {
			user = new Usuario();
			user.setName(Constants.ADMIN_NAME);
			user.setEmail(Constants.ADMIN_EMAIL);
			user.setPassword(new BCryptPasswordEncoder().encode(Constants.ADMIN_PASSWORD));
			userRepository.save(user);
            logger.info("Usuario admin registrado");
		} else {
            logger.info("Usuario admin ya está registrado");
		}
	}
}
