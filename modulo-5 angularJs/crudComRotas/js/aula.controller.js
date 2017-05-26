let app = angular.module('app', ['ngRoute','ngAnimate', 'toastr']);

app.controller('aulaController', function ($scope, $routeParams, aulaService,toastr) {

    listar();

    $scope.incluir = function () {
      if($scope.meuForm.$invalid){
        toastr.error('Houston, We Have a Problem');
        return;
      }

     let promisse = aulaService.create($scope.novaAula);
     promisse.then(function (response) {
        $scope.novaAula = {}
        toastr.success('Aula inserida com sucesso!');
        listar();
     })
   }

   $scope.excluirAula = function (aula) {
     let promisse = aulaService.delete(aula);

     promisse.then(function (response) {
        toastr.success('Aula excluida com sucesso.');
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