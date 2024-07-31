package lab.microservice.hello;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userdb-service")
@LoadBalancerClient(name = "userdb-service", configuration = LoadBalancerConfiguration.class)
@EnableDiscoveryClient
public interface UserDBProxy {

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable Long id);
}
