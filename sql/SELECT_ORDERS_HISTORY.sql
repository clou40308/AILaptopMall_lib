/*SELECT_ORDERS_HISTORY*/
SELECT id, customer_account, created_date, careted_time, status,
	shipping_type, shipping_fee, payment_type, payment_fee,
    order_id,
    SUM(price * quantity) AS total_amount
    FROM orders
		INNER JOIN order_items 
			ON orders.id = order_items.order_id
	WHERE customer_account ="clou40308" 
    AND created_date BETWEEN date_add(curdate(), INTERVAL -1 MONTH) AND curdate()
    GROUP BY orders.id
    ORDER BY created_date DESC, careted_time DESC;