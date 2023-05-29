package br.com.vinicius.injecaodependencia.service;

import br.com.vinicius.injecaodependencia.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService service;

    public double total(Order order){
        return service.shipment(order) + (order.getBasic() - (order.getBasic() * order.getDiscout() / 100));
    }
}