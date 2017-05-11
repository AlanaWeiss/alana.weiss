console.log("carregou!");
// alert("Bem vindo(a)");
// var pi = 3.14;

if (typeof pi !== "undefined"){
  console.log(pi);
}

function somaSemReturn(a, b){
  return a + b;
}

console.log("somaSemReturn", somaSemReturn(1,2));
console.log("typeof somaSemReturn",typeof somaSemReturn);

var somar = function(a, b){
  return a + b;
}

// var somar{
//     var a = arguments[0], b = arguments[1];
//     return a + b;
// }
console.log("somar", somar(1,2));
console.log("typeof somar", typeof somar);

 var somarArrowFunction = (a, b) => a + b   //ES2015 nao funciona em todos os navegadores ex: ie10
 console.log("somarArrowFunction", somarArrowFunction(1,2));
 console.log("typeof somarArrowFunction", typeof somarArrowFunction);

 console.log("somar(1, 2, 4)", somar(1, 2, 4));
