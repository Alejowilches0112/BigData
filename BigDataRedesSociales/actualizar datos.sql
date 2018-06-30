SET SQL_SAFE_UPDATES = 0;
update analisis set favorabilidad = "POSITIVO" where porcentaje between '71.0' and '100';
SET SQL_SAFE_UPDATES = 1;