package springmvc.orders.db;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import springmvc.bean.Order;

public interface OrderOperations {
	@Cacheable("spittle")
	List<Order> findOrdersByType(String t);

}
