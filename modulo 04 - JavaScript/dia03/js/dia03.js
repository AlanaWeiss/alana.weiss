Number.prototype.arredondar = function (casas) {
  if(!casas) casas = 2;
  return parseFloat(this.toFixed(casas));
};

var pi = 3.1428;
console.log(pi.arredondar());
var numero = 63.998653;
console.log(numero.arredondar(3));

Number.prototype.arredondarComRound = function (casas) {
  if(!casas) casas = 2;
  var casaDec = Math.pow(10,casas);
  return Math.round(this * casaDec)/casaDec;
};

var pi = 3.1428;
console.log(pi.arredondarComRound());
var numero = 63.998653;
console.log(numero.arredondarComRound(3));
