select 

extract(year from r.DTLANCAMENTO) as ANO,
(
sum(abs(r.QTRACAO))/(
    select 
    sum(abs(m.QTANIMAIS))
    from ESANMOVANIMAIS m
    where m.CDFASE = 6
    and m.FLTIPO  = 'F'
    and extract(year from m.DTMOVIMENTACAO) = extract(year from r.DTLANCAMENTO)
)
) as KG_ANIMAL
from EFABLANCAMENTORACAO r inner join EFABRACAO ra
on ra.CDRACAO = r.CDRACAO
where r.CDFASE = 4
and r.CDRACAO = $P{COD_RACAO}
group by ANO
