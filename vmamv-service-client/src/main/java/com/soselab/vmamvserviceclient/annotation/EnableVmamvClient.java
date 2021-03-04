package com.soselab.vmamvserviceclient.annotation;

//import com.soselab.vmamvserviceclient.service.ServiceDependencyAnalyzer;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({com.soselab.vmamvserviceclient.service.ServiceDependencyAnalyzer.class,com.soselab.vmamvserviceclient.service.ContractAnalyzer.class,com.soselab.vmamvserviceclient.service.ContractAnalyzer2.class})
public @interface EnableVmamvClient {
}
