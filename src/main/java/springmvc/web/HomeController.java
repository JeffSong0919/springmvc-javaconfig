package springmvc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
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
	@Autowired
    RedisTemplate<String, Object> redisTemplate;
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
//		List<Order> list=orderRepository.findByCustomer("gg");
//		System.out.println(list.size());

		List<Order> list=orderRepository.findOrdersByType("2");
		System.out.println(list.size());
//		redisTemplate.opsForValue().set("gege", 11);
//		System.out.print(redisTemplate.opsForValue().get("gege"));
//		redisTemplate.opsForValue().set("gege", new Order());
//		System.out.print(redisTemplate.opsForValue().get("gege"));
//		BoundListOperations<String, Object>cart=redisTemplate.boundListOps("cart");
//		cart.rightPop();
//		cart.rightPush("我笑了");
		return "index";
	}
}
