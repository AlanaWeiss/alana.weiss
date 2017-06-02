angular.module('livraria')
    .controller('livroVizualizarController', function ($scope, livrosService, $routeParams) {


    buscarLivro($routeParams.isbn);

    function buscarLivro(isbn) {
        livrosService.buscarIsbn(isbn).then(function (response) {
             $scope.livro = response.data.dados;
      })
    };
});