var myApp = angular.module('myApp', []);

myApp.controller('mainController', function($scope){

    var aulas = [{
      nome: 'Orientação a obj', // Obrigatório (length = min 3, max 20)
      id: 0
      }];

      $scope.novaAula = {}

    $scope.aulas = aulas;
    function idArray(aulas) {
      if (aulas.length < 0) {
        return 0;
       } else {
         return aulas[aulas.length-1].id+1;
      }
    }
    $scope.incluir = function () {
      $scope.novaAula.id = idArray(aulas);
        $scope.aulas.push(angular.copy($scope.novaAula));
        $scope.novaAula = {}
    }

    $scope.excluirAula = function (index) {
      $scope.aulas.splice(index, 1);
      $scope.removerInstrutor = {};
      $scope.formExcluirAula.$setPristine();
    }

    $scope.editarAula = function (index) {
      $scope.aulas.forEach((item) => {
       if(item.id === Number(index))
         item.nome = $scope.nomeEditado;
     });
    }
})
