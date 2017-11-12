package com.springbootdev.examples.consumer.service;

import com.springbootdev.examples.consumer.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"all_cars_queue", "nissan_cars_queue"})
public class ConsumerService
{
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @RabbitHandler
    public void receiveMessage(Car car)
    {
        logger.info(" receive message [" + car.toString() + "] ");
    }
}
