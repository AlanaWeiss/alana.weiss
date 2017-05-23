let app = angular.module('app', ['ngRoute']);

app.controller('aulaController', function ($scope, $routeParams, aulaService) {

    listar();
    $scope.clicouParaEditarAula = false;

    $scope.incluir = function () {
     let promisse = aulaService.create($scope.novaAula);
     promisse.then(function (response) {
        $scope.novaAula = {}
        alert('Aula inserida com sucesso.');
        listar();
     })
   }

   $scope.excluirAula = function (aula) {
     let promisse = aulaService.delete(aula);

     promisse.then(function (response) {
        alert('Aula excluida com sucesso.');
        listar();
     })
   }

   $scope.clicouParaEditarAula = function (aula) {
     $scope.aulaEditada = aula;
     $scope.querEditar = true;
   }

   $scope.editarAula = function () {
     aulaService.update($scope.aulaEditada.nome);
    $scope.querEditar = false;
   }

   function listar() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
  }

});