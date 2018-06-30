use bigdata;
Select twitter.idtwitter,twitter.texto, twitter.palabra,analisis.favorabilidad, twitter.fecha from analisis join twitter on analisis.twit_id_twit = twitter.idtwitter;