use restaurante2;

select * from cardapio;
select * from garcom;
select * from itempedido;
select * from pedido;

-- 1. Exibir os dados dos clientes.
select * from cliente;

-- 2. Exibir os dados das formas de pagamento.
select * from formapagamento;

-- 3. Exibir os dados das categorias.
select * from categoria;

-- 4. Exibir os itens do cardápio (código, nome, preço e categoria), organizar por categoria e nome do item.
select 
    car_codigo, car_nome, car_preco, categoria.cat_nome from cardapio inner join categoria using (cat_codigo) order by categoria.cat_nome ASC,
    cardapio.car_nome asc;
-- 5. Exibir os dados do(s) pedido(s) do cliente "Veronice".
select * from pedido inner join cliente using (cli_codigo) where cli_nome = "Veronice";

-- 6. Alterar a descrição da categoria Massas para Guloseimas.
-- UPDATE categoria
-- SET cat_nome = 'Guloseimas'
-- WHERE cat_nome = 'Massas';

-- 7. Adicionar a categoria Massas.
-- INSERT INTO categoria (cat_id, cat_nome)
-- VALUES (12, 'Massas');

-- 8. Adicionar o garçom Mário.
-- INSERT INTO garcom (gar_id, gar_nome, gar_datanascimento, gar_horaTrabalho)
-- VALUES (1, 'Mário', '24/12/1972');

-- 9. Exibir o número do pedido, a quantidade de pessoas na mesa, o valor total do pedido e o valor de cada pessoa.
select ped_numero, ped_numeroPessoas, ped_valorTotal, (ped_valorTotal / ped_numeroPessoas) AS valor_por_pessoa from pedido;

-- 10. Exibir a quantidade de itens do cardápio por categoria.
select count(*), cat_nome from cardapio inner join categoria using (cat_codigo) group by cat_codigo;

-- 11. Exibir a quantidade de itens consumidos em cada pedido.
	USE restaurante2;
	SELECT 
    p.ped_numero, 
    SUM(i.itm_quantidade) AS total_itens_consumidos
FROM 
    pedido p
INNER JOIN 
    itempedido i ON p.ped_numero = i.ped_numero
GROUP BY 
    p.ped_numero;

-- 12. Quais foram os itens já consumidos pela cliente "Veronice".
SELECT 
    c.cli_nome, 
    i.car_codigo, 
    i.itm_quantidade, 
    i.itm_valorunitario
FROM 
    cliente c
INNER JOIN 
    pedido p ON c.cli_codigo = p.cli_codigo
INNER JOIN 
    itempedido i ON p.ped_numero = i.ped_numero
WHERE 
    c.cli_nome = 'Veronice';
       
-- 13. Exibir a categoria dos itens que nunca foram vendidos.
SELECT 
    cat.cat_nome
FROM 
    categoria cat
WHERE 
    cat.cat_codigo NOT IN (
        SELECT DISTINCT 
            c.cat_codigo
        FROM 
            itempedido i
        INNER JOIN 
            cardapio c ON i.car_codigo = c.car_codigo
    );

-- 14. Exibir o nome dos clientes que nunca pediram "Guloseimas"
	select
		c.cli_nome
    from 
		cliente c
	where c.cli_codigo NOT IN(
    SELECT distinct
		p.cli_codigo
	FROM 
            pedido p
        INNER JOIN 
            itempedido i ON p.ped_numero = i.ped_numero
        INNER JOIN 
            cardapio ca ON i.car_codigo = ca.car_codigo
        INNER JOIN 
            categoria cat ON ca.cat_codigo = cat.cat_codigo
        WHERE 
            cat.cat_nome = 'Guloseimas'
    );

-- 15. Exibir o faturamento no mês de setembro/2024.
	SELECT 
		SUM(p.ped_valorTotal) AS faturamento_setembro_2024
	FROM 
		pedido p
	WHERE
		p.ped_data between '2024-09-01' AND '2024-09-30';

-- 16. Exibir o faturamento no mês de setembro/2024 organizado por forma de pagamento
	SELECT f.fpg_nome,
		SUM(p.ped_valorTotal) AS faturamento_setembro_2024
	FROM
		pedido p
	inner join
		formapagamento f ON p.fpg_codigo = f.fpg_codigo
	WHERE 
		p.ped_data between '2024-09-01' AND '2024-09-30'
	GROUP BY
		f.fpg_nome;
        

-- 17. Exibir o faturamento do mês de setembro/2024, organizado por categoria.
USE restaurante2;
		SELECT 
    cat.cat_nome, 
    SUM(i.itm_valorTotal) AS faturamento_setembro_2024
FROM 
    pedido p
INNER JOIN 
    itempedido i ON p.ped_numero = i.ped_numero
INNER JOIN 
    cardapio ca ON i.car_codigo = ca.car_codigo
INNER JOIN 
    categoria cat ON ca.cat_codigo = cat.cat_codigo
WHERE 
    p.ped_data BETWEEN '2024-09-01' AND '2024-09-30'
GROUP BY 
    cat.cat_nome;

-- 18. Exibir o nome de data de nascimento de todos os clientes que comemoram aniversário no  mesmo dia que o garçom "Cláudio".
		SELECT 
			c.cli_nome,
            c.cli_dataNascimento
		FROM
			cliente c
		INNER JOIN 
			garcom g ON c.cli_dataNascimento = g.gar_datanascimento
		WHERE
			g.gar_nome = 'claudio';
            
-- 19. Exibir os itens dos pedidos dos clientes que comemoram aniversário no mesmo dia do pedido.
SELECT 
    p.ped_numero,
    c.cli_nome,
    ca.car_nome,
    i.itm_quantidade,
    i.itm_valorunitario,
    i.itm_valorTotal
FROM 
    pedido p
INNER JOIN 
    cliente c ON p.cli_codigo = c.cli_codigo
INNER JOIN 
    itempedido i ON p.ped_numero = i.ped_numero
INNER JOIN 
    cardapio ca ON i.car_codigo = ca.car_codigo
WHERE 
    DATE_FORMAT(p.ped_data, '%m-%d') = DATE_FORMAT(STR_TO_DATE(c.cli_dataNascimento, '%Y-%m-%d'), '%m-%d');

-- 20. Exibir o(s) nome(s) dos garçons que já atenderam a cliente "Veronice".
SELECT DISTINCT 
    g.gar_nome
FROM 
    pedido p
INNER JOIN 
    cliente c ON p.cli_codigo = c.cli_codigo
INNER JOIN 
    itempedido i ON p.ped_numero = i.ped_numero
INNER JOIN 
    garcom g ON i.gar_codigo = g.gar_codigo
WHERE 
    c.cli_nome = 'Veronice';

-- 21. As quartas, qual é o prato mais vendido?
SELECT 
    ca.car_nome,
    SUM(i.itm_quantidade) AS total_vendido
FROM 
    pedido p
INNER JOIN 
    itempedido i ON p.ped_numero = i.ped_numero
INNER JOIN 
    cardapio ca ON i.car_codigo = ca.car_codigo
WHERE 
    DAYOFWEEK(p.ped_data) = 4
GROUP BY 
    ca.car_nome
ORDER BY 
    total_vendido DESC
LIMIT 1;

-- 22. Quais garçons não atenderam pedidos de Guloseimas?
SELECT 
    g.gar_nome
FROM 
    garcom g
WHERE 
    g.gar_codigo NOT IN (
        SELECT DISTINCT 
            i.gar_codigo
        FROM 
            itempedido i
        INNER JOIN 
            cardapio ca ON i.car_codigo = ca.car_codigo
        INNER JOIN 
            categoria cat ON ca.cat_codigo = cat.cat_codigo
        WHERE 
            cat.cat_nome = 'Guloseimas'
    );

-- 23. Qual foi o valor do maior pedido?
SELECT 
    MAX(ped_valorTotal) AS maior_pedido
FROM 
    pedido;

-- 24. Quais clientes possuem pedidos maiores que a média dos pedidos da cliente Veronice?.  Exibir o nome do cliente, numero, data  e hora do pedido; número do item, código e nome do item do cardápio, quantidade, valor unitário e valor total do item.
SELECT 
    c.cli_nome,
    p.ped_numero,
    p.ped_data,
    i.itm_numero,
    ca.car_codigo,
    ca.car_nome,
    i.itm_quantidade,
    i.itm_valorunitario,
    i.itm_valorTotal
FROM 
    pedido p
INNER JOIN 
    cliente c ON p.cli_codigo = c.cli_codigo
INNER JOIN 
    itempedido i ON p.ped_numero = i.ped_numero
INNER JOIN 
    cardapio ca ON i.car_codigo = ca.car_codigo
WHERE 
    p.ped_valorTotal > (
        SELECT 
            AVG(p2.ped_valorTotal)
        FROM 
            pedido p2
        INNER JOIN 
            cliente c2 ON p2.cli_codigo = c2.cli_codigo
        WHERE 
            c2.cli_nome = 'Veronice'
    );