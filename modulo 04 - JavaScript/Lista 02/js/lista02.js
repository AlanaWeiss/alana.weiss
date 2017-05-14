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
console.log("Exercicio 1");
console.log(seriesInvalidas(series));

/*EXERCICIO 2 devolve um outro array contendo apenas as séries com ano maior ou igual ao ano passado por parâmetro.*/

function filtarSeriesPorAno(series, ano){
  var seriesDoAnoOuSuperior = [];
  series.forEach( item => {if( item.anoEstreia >= ano ) seriesDoAnoOuSuperior.push(item.titulo) } );
  return "Series a partir do ano " + ano + ": " + seriesDoAnoOuSuperior.join(" - ");
}
console.log("Exercicio 2");
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
console.log("Exercicio 3");
console.log(mediaDeEpisodios(series));

/*EXERCICIO 4 Crie uma função chamada procurarPorNome(series, nome)
que recebe um array de séries e um nome e caso esse nome possua no elenco das séries, retorna true.*/

function procurarPorNome(series, nome) {
  var eAtor = false;
  series.forEach( item => {
      if( item.elenco.indexOf(nome)>=0 ) eAtor = true;
  } )
  return eAtor;
}
console.log("Exercicio 4");
console.log(procurarPorNome(series, 'Alana Weiss'));
console.log(procurarPorNome(series, 'Luna'));

/* EXERCICIO 5 rie uma função chamada mascadaEmSerie que retornará o valor total do salário a ser pago por mês para determinada série. */
function mascadaEmSerie(serie) {
  var salarioDiretores = serie.diretor.length * 100000;
  var salarioElenco = serie.elenco.length * 40000;
  var total = salarioDiretores + salarioElenco;

  return serie.titulo + ": R$ " + total;
}
console.log("Exercicio 5");
console.log(mascadaEmSerie(series[0]));
console.log(mascadaEmSerie(series[1]));
console.log(mascadaEmSerie(series[2]));


/*exercicio 6 A)*/
function queroGenero(genero) {
  var seriesDoGenero = [];
  series.forEach( item => {
      for( tipo of item.genero){
        if(genero === tipo) seriesDoGenero.push(item.titulo);
      }
  } )
  return seriesDoGenero.join(" - ");
}
console.log("Exercicio 6 a)");
console.log(queroGenero('Caos'));

/*EXERCICIO 6 B)  Escreva uma função chamada queroTitulo que retorne um array, co
m os títulos das séries que tem título semelhante ao passado*/

function queroTitulo(titulo) {
  var seriesComTitulo = [];
  series.forEach( item => {
    if( item.titulo.indexOf(titulo)>=0 ) seriesComTitulo.push(item.titulo)
  } );
  return seriesComTitulo.join(" - ")
}
console.log("Exercicio 6 b)");
console.log(queroTitulo("The"));
console.log(queroTitulo("of"));

/*Ao final de um episódio, temos os créditos do episódio. Para isso vamos implementar uma função,
chamada de creditosIlluminatis que recebe uma série como parâmetro e imprima os créditos a partir dela.
Deverá ser impresso, o Título da serie, os Diretores, avisando com um título que é o bloco deles. Em seguida vem o elenco,
também com um título de Elenco.
Tranquilo né? Easy! MAS, tem o seguinte: Os créditos são sempre ordenados alfabeticamente, mas pelo ÚLTIMO NOME!!.*/

function sobrenomePrimeiro(nomes) {
    var lista = [];

    for (i = 0; i < nomes.length; i++) {
        var sobrenome = nomes[i].split(" ")[1];
        var primeiroNome = nomes[i].split(" ")[0];
        var nomeInvertido = sobrenome + ", " + primeiroNome;
        lista.push(nomeInvertido);
    }

    return lista.sort();
}

function creditosIlluminatis(serie) {
  var diretores = [];
  var atores = [];

  for(diretor of serie.diretor)
    diretores.push(diretor);

  for(elenco of serie.elenco)
    atores.push(elenco);

  var outroDiretores = sobrenomePrimeiro(diretores);
  var outroElencos = sobrenomePrimeiro(atores);

  return `\nTitulo:
        \n${serie.titulo}\n
          Diretores:
    \n${outroDiretores.join('\n')}\n
            Elenco:
    \n${outroElencos.join('\n')}`;
}
console.log("Exercicio 7");
console.log(creditosIlluminatis(series[1]));
console.log(creditosIlluminatis(series[2]));
console.log(creditosIlluminatis(series[3]));
console.log(creditosIlluminatis(series[4]));
console.log(creditosIlluminatis(series[5]));
console.log(creditosIlluminatis(series[6]));

/*Essa é a informação básica! Construa uma função que identificará aquela série que tem TODOS do elenco com nomes abreviados.
Uma vez achada a série, vamos modificar um pouquinho a implementação. Coloque todas as palavras abreviadas
(de preferência sem os pontos finais) em uma string que será retornada ao final do método.
Forme uma hashtag com a palavra! #PALAVRA*/

function elencoIlluminati(series) {
  let lista = [];

  for(item of series) {
    for(elenc of item.elenco) {
      if(elenc.indexOf('.') >= 0)
        lista.push(elenc.substring(elenc.indexOf('.') - 1, elenc.indexOf('.')));
    }
  }

  return "#" + lista.join('');
}
console.log("Exercicio 8");
console.log(elencoIlluminati(series));

//
