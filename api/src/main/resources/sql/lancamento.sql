select
	lancamento_id id,
	data_hora datahora,
	conta.conta_id as contaid,
	conta.nome as contanome
from lancamento
join conta on conta.conta_id = lancamento.conta_id
where cast(data_hora as date) between :inicio and :fim
order by data_hora ;