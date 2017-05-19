var myApp = angular.module('myApp', []);

myApp.controller('mainController', function($scope){
   $scope.nomes = ['Andre', 'Bernardo'];
   
   if($scope.meuForm.$invalid){ // se algum campo for invalido não retorna nada;
       return;
   }

    $scope.incluir = function(novoNome){
        $scope.nomes.push(novoNome);
    }

})