/*SELECT_STOCK_BY_PRODUCTID_SIZENAME_SPECNAME*/
SELECT id,name, 
		IFNULL(product_size_specs.size_name, IFNULL(product_sizes.size_name,'')) as size_name, 
		IFNULL(product_size_specs.spec_name,'') as spec_name, 
		IFNULL(product_size_specs.stock, IFNULL(product_sizes.stock, products.stock)) as stock 
		FROM products  
		   LEFT JOIN product_sizes ON products.id=product_sizes.product_id          
			 LEFT JOIN product_size_specs ON products.id=product_size_specs.product_id  
			  AND(product_sizes.size_name = product_size_specs.size_name OR product_sizes.size_name IS NULL) 
			  WHERE products.id = "1"
			  HAVING size_name="14" AND spec_name="Ultra5";   