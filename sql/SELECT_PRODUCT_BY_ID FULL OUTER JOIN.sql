/*SELECT_PRODUCT_BY_ID FULL OUTER JOIN*/
SELECT id, name, products.unit_price, IFNULL(SUM(product_size_specs.stock),products.stock) AS stock, 
		products.photo_url, category, maker, description, products.release_date, discount ,
        product_sizes.product_id, product_sizes.size_name, 
        IFNULL(product_sizes.release_date,products.release_date) AS size_release_date, 
        IFNULL(SUM(product_size_specs.stock),product_sizes.stock) AS size_stock, product_sizes.ordinal,
        COUNT(spec_name) AS spec_count 
        FROM products 
        LEFT JOIN product_sizes ON products.id=product_sizes.product_id 
        LEFT JOIN product_size_specs ON products.id = product_size_specs.product_id
					AND (product_sizes.size_name= product_size_specs.size_name
                    OR product_sizes.size_name IS NULL)
		WHERE products.id="1"
					GROUP BY products.id,product_sizes.size_name;