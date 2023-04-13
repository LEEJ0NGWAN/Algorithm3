select p.product_code, if(sum(o.sales_amount) is null, 0, p.price*sum(o.sales_amount)) as sales
from product p left join offline_sale o on p.product_id = o.product_id
group by o.product_id
order by if(sum(o.sales_amount) is null, 0, p.price*sum(o.sales_amount)) desc, p.product_code;
