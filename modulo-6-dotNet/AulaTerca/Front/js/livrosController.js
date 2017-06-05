angular.module('livraria')
    .controller('livrosController', function ($scope, livrosService, $routeParams,$location, authService) {
   
   $scope.logout = authService.logout;
   let paginaAtual = 1;


  $scope.parametros = {
      quantidadePular: 0,
      quantidadeTrazer: 8
    };

  listar();
  listarLancamentos()

  if(authService.isAutenticado()){
    $scope.mostrarAdm = true;
}

    function listar() {
        livrosService.listPaginacao($scope.parametros)
        .then(response => {
            $scope.livros = response.data.dados;
        })
    }

     livrosService.list().then(response => { console.log("paginas", response) })

     livrosService.list().then(response => {
       console.log('aqui',response.data);
       qtdPaginas(response.data.length / 8)
    })
   
    function qtdPaginas(p) {
    $scope.paginas = [];
    for(var i = 1; i <= Math.ceil(p); i++) 
      $scope.paginas.push({indice: i}); 
    }
    
     $scope.CarregarPagina = function(pagina) {
    if(pagina > paginaAtual) {
      $scope.parametros.quantidadePular += (pagina - 1) * 8;
    }
    else if(pagina < paginaAtual) {
      $scope.parametros.quantidadePular -= (pagina) * 8;
    }
    
    listar();
    paginaAtual = pagina;
  }

    function listarLancamentos() {
        livrosService.listNews().then(function (response) {
            $scope.livrosLancamentos = response.data.dados;
            console.log( $scope.livrosLancamentos);
        });
    }

     $scope.exibirLivro = function (livro) {
    
    $location.path('/livros/' + livro.Isbn);
  }

});