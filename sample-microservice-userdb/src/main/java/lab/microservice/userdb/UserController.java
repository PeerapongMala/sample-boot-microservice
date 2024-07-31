package lab.microservice.userdb;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getNameById(@PathVariable Long id){
		User user = userRepository.findById(id).get();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}