package com.springbootdev.examples.consumer.service;

import com.springbootdev.examples.consumer.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private static final String QUEUE_NAME = "all_cars_queue";

    @Scheduled(fixedRate = 5000)
    public void receive()
    {
        Object object = rabbitTemplate.receiveAndConvert(QUEUE_NAME);

        if (object != null) {
            Car car = (Car) object;
            logger.info(" received the message [" + car.toString() + "] ");
        }
    }
}
