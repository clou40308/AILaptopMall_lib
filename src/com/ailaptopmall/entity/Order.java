package com.ailaptopmall.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Order {//網路交易憑證
	private int id;//Pkey, Auto-increment
	private Customer member; //必要
	private LocalDate createdDate; //必要
	private LocalTime createdTime; //必要
	private int status; //0:新訂單, 1:已轉帳, 2:已付款, 3:已出貨, 4: 已到店, 5: 已簽收送達, 6: 已完成
						//10:取消, 11: 退貨, 12: 確定已退貨, 13:...
	
	private ShippingType shippingType;  //必要
	private String shippingNote; //非必要
	private double shippingFee; 	     //必要
	
	private PaymentType paymentType;  //必要
	private String paymentNote; 	  //非必要
	private double paymentFee; 	      //必要
	
	private String recipientName;	  //必要
	private String recipientEmail;	  //必要
	private String recipientPhone;	  //必要
	private String shippingAddress;	  //必要
	
	private Set<OrderItem> orderItemsSet = new HashSet<>();

	//orderItemsSet's getters
	public Set<OrderItem> getOrderItemsSet() {
		return new HashSet<>(orderItemsSet);
	}

	//由[Source] -> [generate delegate method]
	public int size() {//共n項
		return orderItemsSet.size();
	}
	
	public int getTotalQuantity() {
		int sum = 0;
		if(orderItemsSet!=null && orderItemsSet.size()>0) {
			for(OrderItem orderItem:orderItemsSet) {
				sum = sum + orderItem.getQuantity();
			}		
		}
		return sum;
	}
	
	public double getTotalAmount() { //總金額
		double sum = 0;
		if(orderItemsSet!=null && orderItemsSet.size()>0) {
			for(OrderItem orderItem:orderItemsSet) {
				sum = sum + orderItem.getAmount();
			}		
		}
		return (sum); //用跟購物車getTotalAmount()一樣的Math.round或ceil或floor
	}
	
//	public double MAX_WITHOUT_FEE = 2000;
	public double getTotalAmountWithFee() {
		double totalAmount = getTotalAmount();		
//		if(totalAmount>=MAX_WITHOUT_FEE) //是否達免運
//			return totalAmount;			 //若達免運，不收物流手續費
		return totalAmount+ shippingFee + paymentFee;
	}
	
	//orderItemsSet's setters: add, (update, remove這裡不做)
	public void add(OrderItem orderItem) { //for OrdersDAO 從資料庫查詢明細
		if(orderItem ==null)throw new IllegalArgumentException("訂單明細不得為null");
		
		orderItemsSet.add(orderItem);
	}
	
	public void add(ShoppingCart cart) { //for CheckoutServlet 從購物車中的cartItem->orderItem
		if(cart==null || cart.isEmpty())
			throw new IllegalArgumentException("結帳時cart為空，無法建立訂單明細");
		
		for(CartItem cartItem:cart.getCartItemsSet()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartItem.getTheProduct());
			orderItem.setSizeName(cartItem.getSizeName());
			orderItem.setSpecName(cartItem.getSpecName());
//			orderItem.setListPrice(cartItem.getListPrice());
//			orderItem.setDiscountString(cartItem.getDiscountString());
			orderItem.setPrice(cartItem.getPrice());
			orderItem.setQuantity(cart.getQuantity(cartItem));			
			
			orderItemsSet.add(orderItem);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getMember() {
		return member;
	}

	public void setMember(Customer member) {
		this.member = member;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalTime createdTime) {
		this.createdTime = createdTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ShippingType getShippingType() {
		return shippingType;
	}

	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}

	public String getShippingNote() {
		return shippingNote;
	}

	public void setShippingNote(String shippingNote) {
		this.shippingNote = shippingNote;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentNote() {
		return paymentNote;
	}

	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}

	public double getPaymentFee() {
		return paymentFee;
	}

	public void setPaymentFee(double paymentFee) {
		this.paymentFee = paymentFee;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Order [訂單編號=" + id + ", 訂購人=" + member.getName() 
			+ ", 訂購日期時間=" + createdDate + ", " + createdTime 
			+ ", 處理狀態=" + status 
			+ ",\n 貨運方式/手續費/Note=" + shippingType.name() + "/" + shippingFee + "元," + shippingNote 
			+ ",\n 付款方式/手續費/Note=" + paymentType.name() + "/" + paymentFee  + "元," + paymentNote
			+ ",\n 收件人=" + recipientName + "," + recipientEmail + "," + recipientPhone 
			+ ",\n 收件地址=" + shippingAddress
			+ ",\n訂單明細=" + orderItemsSet 
			+ ",\n共" + size() + "項, " + getTotalQuantity() + "件,"
			+ "\n 總金額=" + getTotalAmount() + "元, 總金額(含手續費)" + getTotalAmountWithFee() + "元]";
	}
}
