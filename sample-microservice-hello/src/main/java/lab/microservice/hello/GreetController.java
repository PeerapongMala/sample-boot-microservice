package lab.microservice.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Autowired
	private UserDBProxy userDBProxy;

	public GreetController(UserDBProxy userDBProxy) {
		this.userDBProxy = userDBProxy;
	}

	// basic hello 
	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
	}

	@GetMapping("/hello/{id}")
	public ResponseEntity<String> helloByName(@PathVariable Long id){
		UserDTO user = userDBProxy.getUser(id);
		return new ResponseEntity<String>("Hello " + user.getName(), HttpStatus.OK);
	}

}