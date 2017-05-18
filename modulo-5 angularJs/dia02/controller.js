var modulo = angular.module('exercicio', []);

modulo.controller('converterData', function($scope, $filter){
     let dataObjeto = new Date($scope.dataDigitada);
    $scope.dataPronta = $filter('date')(dataObjeto, 'mediumDate')
});