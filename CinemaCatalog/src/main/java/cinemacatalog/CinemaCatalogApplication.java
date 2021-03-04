package cinemacatalog;


import com.soselab.vmamvserviceclient.annotation.EnableVmamvClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableVmamvClient
@EnableEurekaClient
@EnableFeignClients
public class CinemaCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaCatalogApplication.class, args);
	}

}

