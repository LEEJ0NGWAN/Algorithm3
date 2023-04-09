select animal_id, name, sex_upon_intake
from animal_ins
where name in ('Pickle', 'Rogan', 'Sabrina', 'Mitty', 'Lucy', 'Ella')
order by animal_id;
