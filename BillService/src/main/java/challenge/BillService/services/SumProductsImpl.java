package challenge.BillService.services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.springframework.stereotype.Service;

import challenge.BillService.models.Product;

@Service
public class SumProductsImpl implements ISumService {

	Stack<Long> tipo = new Stack<Long>();
	String h = "";
	
	@Override
	public Long SumProducts(Stack<Long>  costAndQuantity) {
		
		
		System.out.println("costAndQuantity3 " + costAndQuantity);
		
		Long sum = 0L ;
		while(!costAndQuantity.empty()) {
			sum= sum + costAndQuantity.pop(); 
		}
		
		System.out.println("suma " + sum);
		
		return sum;
	}

}
