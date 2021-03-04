/*
package ordering;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    // Exchange -> FanoutExchange
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("ordering.fanout");
    }

    // 只要這邊有定義@Bean，Rabbitmq上就會有queue產生
    @Bean
    public Queue dateQueue() {
        return new Queue("date");
    }

    @Bean
    public Queue dateQueue2() {
        return new Queue("date2");
    }

    @Bean
    public Binding binding1(FanoutExchange fanout, Queue dateQueue) {
        return BindingBuilder.bind(dateQueue).to(fanout);
    }

    @Bean
    public Binding binding2(FanoutExchange fanout, Queue dateQueue2) {
        return BindingBuilder.bind(dateQueue2).to(fanout);
    }

*/
/*    @Bean
    public Queue objQueue() {
        return new Queue("object");
    }*//*





    // Exchange -> TopicExchange
    */
/*
     * '*' -> match one
     * '#' -> match 0...n
     * *//*

*/
/*    @Bean
    public TopicExchange topic() {
        return new TopicExchange("tut.topic");
    }

    // 只要這邊有定義@Bean，Rabbitmq上就會有queue產生
    @Bean
    public Queue dateQueue() {
        return new Queue("date");
    }

    @Bean
    public Queue dateQueue2() {
        return new Queue("date2");
    }

    @Bean
    public Queue dateQueue3() {
        return new Queue("date3");
    }


    @Bean
    public Binding binding1a(TopicExchange topic, Queue dateQueue) {
        return BindingBuilder.bind(dateQueue)
                .to(topic)
                .with("*.orange.*");
    }

    @Bean
    public Binding binding1b(TopicExchange topic, Queue dateQueue2) {
        return BindingBuilder.bind(dateQueue2)
                .to(topic)
                .with("*.*.rabbit");
    }

    @Bean
    public Binding binding2a(TopicExchange topic, Queue dateQueue3) {
        return BindingBuilder.bind(dateQueue3)
                .to(topic)
                .with("lazy.#");
    }*//*

}*/
