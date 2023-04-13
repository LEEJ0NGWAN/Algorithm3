select 10000 * (price div 10000) as price_group, count(*) as products
from product
group by price div 10000
order by price div 10000;
