/*INSERT_ORDERS*/
INSERT INTO orders(id, customer_account, created_date, careted_time, 
			shipping_type, shipping_fee, payment_type, payment_fee, 
            recipient_name, recipient_email, recipient_phone, shipping_address)
            VALUES(?,?,?,?, ?,?,?,?, ?,?,?,?);
            
/*INSERT_ORDER_ITEMS*/
INSERT INTO order_items
		(order_id, product_id, size_name, spec_name, price, quantity)
        VALUES(?,?,?,?, ?,?);