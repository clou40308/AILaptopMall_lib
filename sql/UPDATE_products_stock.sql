/*E09修改products*/
/*
	UPDATE products SET stock=stock-? WHERE stock >=? AND id =? ;
*/
UPDATE products SET stock=stock-1 WHERE id = 1 ANd stock >=1;

/*E09修改product_sizes庫存*/
/*
	UPDATE product_sizes SET stock=stock-? WHERE stock >=? AND product_id =? AND size_name=?;
*/
UPDATE product_sizes SET stock=stock-1 WHERE product_id = 1 AND size_name="14" AND stock >=1;

/*E09修改product_size_specs庫存*/
/*
	UPDATE product_size_specs SET stock=stock-? WHERE stock >=? AND product_id =? AND size_name=? AND spec_name=? ;
*/
UPDATE product_size_specs SET stock=stock-1 WHERE product_id = 1 AND size_name="14" AND spec_name="Ultra5"  AND stock >=1;