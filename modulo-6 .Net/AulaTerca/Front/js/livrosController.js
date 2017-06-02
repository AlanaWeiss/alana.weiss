angular.module('livraria')
    .controller('livrosController', function ($scope, livrosService, $routeParams) {

    listar();
    listarLancamentos();

    function listar() {
        livrosService.list().then(function (response) {
        $scope.livros = response.data;
        });
    }

    function listarLancamentos() {
        livrosService.listNews().then(function (response) {
            $scope.livrosLancamentos = response.data.dados;
            console.log( $scope.livrosLancamentos);
        });
    }
});