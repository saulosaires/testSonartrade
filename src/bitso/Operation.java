package bitso;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Order;
import model.Svalue;
 

public  class Operation {
	
	TreeMap<String, Order> map;
	
	public Operation() {
		map = new TreeMap<String, Order>();
		
		
	}
	
	
	public void manageOrder(String orderId, OrderUpdate orderUpdate) {

		
			if(orderUpdate.getsValue().equals(Svalue.CANCELLED)){
				map.remove(orderUpdate.getOrderId());
			}else{
				map.put(orderUpdate.getOrderId(),new Order(orderUpdate.getBook(), orderUpdate.getPrice(), orderUpdate.getAmount(), orderUpdate.getOrderId()));
			}

		
    }

	public List<Order> getBestorders(int n){
 
		
//		Optional<BigDecimal> max = map.values().stream()
//									           .map(o -> o.getPrice())
//									           .filter(o -> Objects.nonNull(o))
//									           .max((o1,o2)-> o1.compareTo(o2));
//		
//		
//		Optional<BigDecimal> min = map.values().stream().map(o -> o.getPrice()).filter(o -> Objects.nonNull(o)).min((o1,o2)-> o1.compareTo(o2));
		
//		System.out.println("===============");
//		if(max.isPresent())System.out.println("MAX VALUE:"+max.get());
//		if(min.isPresent())System.out.println("MIN VALUE:"+min.get());
//		System.out.println("===============");
//		System.out.println("");
		
		   List<Order> list = map.values().stream()
				   						  .filter(o -> Objects.nonNull(o.getPrice()))
		    		   					  .sorted((o1,o2) -> o2.getPrice().compareTo(o1.getPrice()))
		    		   					  .limit(n).collect(Collectors.toList());


		   return list;
		  
	}
}

