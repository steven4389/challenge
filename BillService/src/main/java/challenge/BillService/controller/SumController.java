package challenge.BillService.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import challenge.BillService.models.Product;
import challenge.BillService.services.ISumService;

/**
 * In this class is the calculation for the sum of the products
 * @author estiv
 *
 */
@RestController
@RequestMapping("/sumService")

public class SumController {
	
	@Autowired
	private ISumService SumService; 
	
	/**
	 * 
	 * @param costAndQuantity. In this parameter a battery enters with the multiplication of the quantity by the cost of each product
	 * @return
	 */
	@PostMapping("/sum")
    public Long createOrder(@RequestBody Stack<Long> costAndQuantity) {
		
		System.out.println("costAndQuantity2"+costAndQuantity);
		
		return SumService.SumProducts(costAndQuantity);
		
	}

}

