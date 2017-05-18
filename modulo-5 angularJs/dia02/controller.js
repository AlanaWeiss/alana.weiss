var modulo = angular.module('exercicio', []);

modulo.controller('converterData', function($scope){ 
  $scope.converter = converter;

  function converter() {

    let dataObjeto = new Date($scope.dataDigitada);
    
    $scope.dataObjeto = dataObjeto;
  }
});