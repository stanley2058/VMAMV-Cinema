package com.soselab.vmamveurekaclient.annotation;

import com.soselab.vmamveurekaclient.service.Register;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(Register.class)
public @interface EnableVmamvRegister {}
