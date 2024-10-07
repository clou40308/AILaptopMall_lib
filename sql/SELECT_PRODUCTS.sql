/*SELECT_ALL_PRODUCTS*/
SELECT id, name, unit_price, stock, phoproductsto_url, category, maker, description, release_date, discount FROM products;

/*SELECT_PRODUCTS_BY_KEYWORD*/
SELECT id, name, unit_price, stock, photo_url, category, maker, description, release_date, discount FROM products WHERE name LIKE "%聯想%";

/*SELECT_PRODUCTS_BY_MAKER*/
SELECT id, name, unit_price, stock, photo_url, category, maker, description, release_date, discount FROM products WHERE maker="HP";

/*SELECT_LATEST_PRODUCTS*/
SELECT id, name, unit_price, stock, photo_url, category, maker, description, release_date, discount FROM products  ORDER BY release_date DESC  LIMIT 5;

/*SELECT_PRODUCT_BY_ID*/
SELECT id, name, unit_price, stock, photo_url, category, maker, description, release_date, discount FROM products WHERE id="2";

/*SELECT_RANDOM_PRODUCTS*/
SELECT id, name, unit_price, stock, photo_url, category, maker, description, release_date, discount 
	 FROM products 
	 ORDER BY RAND() 
	 LIMIT 5 ;