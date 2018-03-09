package example.microservices.demo.notificationservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    RestTemplate orderServiceRestTemplate;

    public Map<String, Object> getOrder(String orderId) {
        return orderServiceRestTemplate.getForObject("/order/" + orderId,
                Map.class);
    }

    @SuppressWarnings("unused")
    public Map<String, Object> noOrderFound(String orderId) {
        logger.error("Error occurred trying to fetch order " + orderId);
        return null;
    }
}
