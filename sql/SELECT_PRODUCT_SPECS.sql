/*SELECT_PRODUCT_SPECS_BY_ID_AND_SIZENAME*/
SELECT product_id, size_name, spec_name, product_size_specs.stock, product_size_specs.unit_price, 
			product_size_specs.unit_price * (100-products.discount) / 100 AS price, 
            product_size_specs.photo_url, description_1, description_2, description_3, ordinal 
			FROM product_size_specs JOIN products ON product_size_specs.product_id = products.id 
            WHERE product_id="1" AND size_name="14" ORDER BY ordinal;
