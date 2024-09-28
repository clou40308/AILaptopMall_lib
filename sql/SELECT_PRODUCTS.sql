/*SELECT_ALL_PRODUCTS*/
SELECT id, name, unit_price, stock, photo_url, category, maker, description, release_date, discount FROM products;

/*SELECT_PRODUCTS_BY_KEYWORD*/
SELECT id, name, unit_price, stock, photo_url, category, maker, description, release_date, discount FROM products WHERE name LIKE "%聯想%";
