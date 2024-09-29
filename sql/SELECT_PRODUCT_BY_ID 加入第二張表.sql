/*SELECT_PRODUCT_BY_ID 加入第二張表*/
SELECT id, name, unit_price, products.stock, photo_url, category, maker, description, products.release_date, discount, 
		product_id, size_name, 
        IFNULL(product_sizes.release_date,products.release_date) AS size_release_date, 
        product_sizes.stock AS size_stock
		FROM products 
		LEFT JOIN product_sizes ON products.id=product_sizes.product_id
		WHERE id="1" ORDER BY product_sizes.ordinal;