package hwController;

public interface ShoppingController {
	//调用商品和购物车接口
	public int addToShoppingcart();
	public int deleteFromShoppingcart();
	
	//调用订单接口，商品接口，用户接口，用户-地址接口
	public int directBuy() ;
	
	//调用购物车接口，订单接口
	public int BuyFromShoppingcart();
	
	//退货：调用订单接口，用户接口，商品接口，库存接口
	public int returngoods();
	
	
	
	
	
	
		

}
