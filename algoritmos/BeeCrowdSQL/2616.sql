SELECT c.id, c.name 
FROM Customers c
LEFT JOIN locations l
ON c.id = l.id_customers
Where l IS NULL
ORDER BY c.id
