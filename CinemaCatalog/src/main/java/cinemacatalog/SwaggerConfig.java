package cinemacatalog;

import com.soselab.vmamvserviceclient.service.ContractAnalyzer;
import com.soselab.vmamvserviceclient.service.ContractAnalyzer2;
import com.soselab.vmamvserviceclient.service.ServiceDependencyAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    ServiceDependencyAnalyzer serviceDependencyAnalyzer;
    @Autowired
    ContractAnalyzer contractAnalyzer;
    @Autowired
    ContractAnalyzer2 contractAnalyzer2;

    @Value("${spring.application.name}")
    private String appName;
    @Value("${info.version}")
    private String version;
    @Value("${contract.path}")
    private String contractPath;
    @Value("${test.path}")
    private String testPath;

    @Bean
    public Docket createRestApi() throws Exception {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(appName))
                .paths(PathSelectors.any())
                .build()
                .extensions(contractAnalyzer.swaggerExtension(contractPath, testPath + "testng-results.xml", appName))
                .extensions(serviceDependencyAnalyzer.swaggerExtension(appName));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appName)
                .description("root：http://140.121.197.128:4104/")
                .termsOfServiceUrl("http://140.121.197.128:4104/")
                .contact("俊佑")
                .version(version)
                .build();
    }
}