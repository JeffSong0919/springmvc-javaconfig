package springmvc.orders.db;

import java.util.List;

import springmvc.bean.Order;

public interface OrderOperations {
	List<Order> findOrdersByType(String t);

}
