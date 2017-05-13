//console.log(series);

/* EXERCICIO 1 seriesInvalidas(series) que recebe o array de séries,
verifica quais são as séries inválidas e retorna o título das séries inválidas em formato String.*/
 function seriesInvalidas(series){
   var invalido = [];
  series.forEach(item => { if(item.anoEstreia > new Date().getFullYear() || eUndefinedOuNull(item)) invalido.push(item.titulo)});
  return "Séries Inválidas:" + invalido.join(" - ");
}

function eUndefinedOuNull(item){
    for(i in item){
      if( typeof item[i] === "undefined" || item[i] === null || item[i] === "") return true;
    }
}

console.log(seriesInvalidas(series));

/*EXERCICIO 2 devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.*/

function filtarSeriesPorAno(series, ano){
  var seriesDoAnoOuSuperior = [];
  series.forEach( item => {if( item.anoEstreia >= ano ) seriesDoAnoOuSuperior.push(item.titulo) } );
  return "Series a partir do ano " + ano + ": " + seriesDoAnoOuSuperior.join(" - ");
}
console.log(filtarSeriesPorAno(series, 2010));

/*EXERCICIO 3 Crie uma função chamada mediaDeEpisodios(series) que recebe o
array de séres e retorna a média dos episódios de todas as séries contidas no array.*/

function mediaDeEpisodios(series) {
  var totalEp = 0;
  for(item of series){
    totalEp += item.numeroEpisodios;
  }
  return totalEp / series.length;
}
console.log(mediaDeEpisodios(series));














//
