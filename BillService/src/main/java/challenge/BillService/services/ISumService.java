package challenge.BillService.services;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import challenge.BillService.models.Product;

public interface ISumService {

	public Long SumProducts(Stack<Long>  costAndQuantity);
}
