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
    
/*SELECT_ORDER_BY_ID*/
SELECT  orders.id, customer_account, created_date, careted_time, status, 
		shipping_type, shipping_fee, shipping_note, payment_type, payment_fee, payment_note, 
        recipient_name, recipient_email, recipient_phone, shipping_address,
        order_id, order_items.product_id, order_items.size_name, order_items.spec_name, price, quantity,
        products.name, IFNULL(product_size_specs.photo_url,products.photo_url) AS photo_url
    FROM orders
		INNER JOIN order_items 
				ON orders.id = order_items.order_id
		INNER JOIN products
				ON order_items.product_id = products.id
		LEFT JOIN product_sizes
				ON order_items.product_id = product_sizes.product_id
					AND order_items.size_name = product_sizes.size_name
		LEFT JOIN product_size_specs
				ON order_items.product_id = product_size_specs.product_id
					AND order_items.size_name = product_size_specs.size_name
                    AND order_items.spec_name = product_size_specs.spec_name
	WHERE customer_account ="clou40308" AND orders.id= 1;