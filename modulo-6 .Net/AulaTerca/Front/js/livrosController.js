angular.module('livraria')
    .controller('livrosController', function ($scope, livrosService, $routeParams) {
   
   let paginaAtual = 1;

  livrosService.list()
    .then(response => gerarQuantidadePaginas(response.data.length / 5))
    .catch(error => console.log(error));

  $scope.parametros = {
      quantidadePular: 0,
      quantidadeTrazer: 5
    };

  listar();
  listarLancamentos()

  $scope.irParaPagina = (num) => {
    let result = 0;

    if(num > paginaAtual) 
      $scope.parametros.quantidadePular += (num - 1) * 5;
    else if(num < paginaAtual)
      $scope.parametros.quantidadePular -= (num) * 5
    
    console.log('pular',$scope.parametros.quantidadePular);
    console.log('num', num);
    console.log('pagina', paginaAtual);
    listar();
    listarLancamentos()
    paginaAtual = num;
  }

  $scope.avancar = () => {
    $scope.parametros.quantidadePular += 5;
    listar();
  }

  $scope.voltar = () => {
    $scope.parametros.quantidadePular -= 5;
    if($scope.parametros.quantidadePular < 0) $scope.parametros.quantidadePular = 0;
    listar();
  }
    function listar() {
        livrosService.list($scope.parametros).then(function (response) {
        $scope.livros = response.data;
        });
    }

    function listarLancamentos() {
        livrosService.listNews().then(function (response) {
            $scope.livrosLancamentos = response.data.dados;
            console.log( $scope.livrosLancamentos);
        });
    }

    function gerarQuantidadePaginas(num) {
    $scope.totalLivros = [];
    for(var i = 1; i <= Math.ceil(num); i++) 
      $scope.totalLivros.push({indice: i}); 
  }

    function exibirLivro(livro) {
    $location.path('/livros/' + livro.Isbn);
  }

});