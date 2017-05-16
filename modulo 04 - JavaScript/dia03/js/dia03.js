function arredondar(numero, casas) {
  if(!casas) casas = 2;
  return numero.toFixed(casas);
}
console.log("arredondou p/ 2 sem casa informada", arredondar(22.3455));
console.log("arredondou para o numero da casa informada", arredondar(645.987644456633323, 4));
