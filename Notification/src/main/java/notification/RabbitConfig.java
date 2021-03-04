/*
package notification;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableRabbit
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private String rabbitmq_host;
    @Value("${spring.rabbitmq.port}")
    private int rabbitmq_port;
    @Value("${spring.rabbitmq.username}")
    private String rabbitmq_username;
    @Value("${spring.rabbitmq.password}")
    private String rabbitmq_password;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(rabbitmq_host);
        factory.setPort(rabbitmq_port);
        factory.setUsername(rabbitmq_username);
        factory.setPassword(rabbitmq_password);
        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }

*/
/*    @RabbitListener(queues = "date")
    public void receive1(String message) {
        System.out.println("consumer receive a fanout message 1: " + message);
    }*//*


    //Connection connection = factory.createConnection();

*/
/*    @Bean
    public Queue dateQueue() {
        return new Queue("date");
    }

    @Bean
    public Queue objQueue() {
        return new Queue("object");
    }*//*

}
*/
