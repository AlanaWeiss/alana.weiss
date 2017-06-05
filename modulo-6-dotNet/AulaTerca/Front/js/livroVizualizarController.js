angular.module('livraria')
    .controller('livroVizualizarController', function ($scope, livrosService, $routeParams, authService) {


    buscarLivro($routeParams.isbn);

    function buscarLivro(isbn) {
        livrosService.buscarIsbn(isbn).then(function (response) {
             $scope.livro = response.data.dados;
             $scope.dataNaoNula = $scope.livro.DataPublicacao !== null;
    $scope.dataNula = $scope.livro.DataPublicacao === null;
      })
    };

     if(authService.isAutenticado()){
    $scope.mostrarAdm = true;
}

    
});