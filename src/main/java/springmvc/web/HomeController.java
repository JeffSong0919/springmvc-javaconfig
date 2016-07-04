package springmvc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.bean.Order;
import springmvc.orders.db.OrderRepository;

@Controller
public class HomeController {
	@Autowired
	MongoOperations mongo;
	@Autowired
	OrderRepository orderRepository;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String index() {
//		 long orderCount=mongo.getCollection("order").count();
//		 System.out.println(orderCount);
//		Order order = new Order();
//		order.setId("1");
//		order.setCustomer("gg");
//		order.setType("2");
//		mongo.save(order,"order");
//		String orderId="1";
//		Order order=mongo.findById(orderId, Order.class);
//		System.out.println(order.getCustomer());
		List<Order> list=orderRepository.findByCustomer("gg");
		System.out.println(list.size());
		return "index";
	}
}
