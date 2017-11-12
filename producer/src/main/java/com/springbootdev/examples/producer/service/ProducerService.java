package com.springbootdev.examples.producer.service;

import com.springbootdev.examples.producer.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "vehicle_exchange";

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private String[] routeKeys = new String[]{
            "nissan.cars.japan",
            "nissan.cars",
            "toyota.cars.japan.manufactured",
            "japan.toyota.cars",
            "import.nissan.cars.from.japan",
            "toyota.cars.manufatured",
            "no.latest.cars.toyota"
    };

    public void produce() {
        for (String routingKey : routeKeys) {
            logger.info(" sending the message with routing key {}", routingKey);

            Car car = new Car(routingKey);
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, routingKey, car);
        }
    }
}
