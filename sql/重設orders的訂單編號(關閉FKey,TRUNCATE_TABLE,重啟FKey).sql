/*重設orders的訂單編號(關閉FKEY)*/
truncate table ailm.order_items;
truncate table ailm.order_logs;

SET foreign_key_checks = 0;
truncate table ailm.orders;
SET foreign_key_checks = 1;