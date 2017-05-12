console.log("Carregou");

function daisyGame(petalas){
  if( petalas % 2 === 1 ){
    console.log("Love Me");
  } else {
    console.log("Love Me Not");
  }
}

console.log( daisyGame(1));
console.log( daisyGame(2));
console.log( daisyGame(3));
console.log( daisyGame(4));

//exercicio 2

function maiorTexto(lista) {
  var maiorTexto = " ";
  for(lista of lista) {
    if(lista.length > maiorTexto.length) maiorTexto = lista;
  }
  return maiorTexto;
}
console.log(maiorTexto(['loucura', 'gsus', 'lalala', 'Bom dia como vai voce']));

//exercicio 3

function imprime(arrayDeStrings, funcao) {
  if(typeof funcao === 'function'){
    for (var i = 0; i < arrayDeStrings.length; i++) {
      funcao(arrayDeStrings[i])
    }
  }
  else console.log("Jabulani");
}

function funcion(nomeInstrutor) {
  console.log("Olá querido instrutor:", nomeInstrutor);
}

console.log(imprime(["Bernardo", "Nunes", "Fabrício", "Ben-hur", "Carlos"],
 funcion))

 // ex 4

 function adicionar(a) {
  return function(b) {
    return a + b;
  };
}
console.log("7", adicionar(3)(4));
console.log("14391", adicionar(5642)(8749));

//exercicio 5

function fiboSum(num) {
  var fiboSum = 0;
  var var1 = 0;
  var var2 = 1;

  for (var i = 1; i <= num; i++) {
    if (num < 2) {
      fiboSum = 1;
    } else {
      fiboSum = var1 + var2;
      var1 = var2;
      var2 = fiboSum;
    }
  }
  return fiboSum-1;
}
console.log("FiboSum: ", fiboSum(4));

//----------------- exercicio 6
// var numericArray = [80, 9, 700];
// console.log('Ordenada:', numericArray.sort());
//para exibir em forma de string: console.log(numericArray.sort().toString());

function queroCafe(mascada, precos){
  var arrayAux = [];
  var implementaIndex = 0;
  for (var i = 0; i < precos.length; i++) {
    if (precos[i] <= mascada) {
      arrayAux[implementaIndex] = precos[i];
      implementaIndex++;
    }
  }
  console.log(arrayAux.sort().toString());
}
queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ])
