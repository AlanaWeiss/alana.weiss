angular
	.module('livraria')
	.controller('AdminstrativoController', function ($scope, authService, livrosService,$location) {

        listar();
	  $scope.auth = authService;
	  $scope.user = authService.getUsuario();
      $scope.revisar = revisar;
      $scope.publicar = publicar;
      $scope.clicouAdd = clicouAdd;
      $scope.adicionar = adicionar;
      $scope.clicouAlterar = clicouAlterar;
      $scope.alterar = alterar;
      $scope.clicouVizualizar = clicouVizualizar;
      $scope.excluir = excluir;

      function listar() {
        livrosService.listIncompleto()
        .then(response => {
            $scope.livros = response.data.dados;
            
        })
    }
    var dia = new Date().getDay();
        if (dia === 6 || dia === 0){
            $scope.desabilitaBotao = true;
        }
    function revisar(livro) {
        $scope.desabilitaBotaoRev = true;
       livro.DataRevisao = new Date();
      livro.Revisor = $scope.user.Nome;
       livrosService.updateLivro(livro.Isbn, livro);
        listar();
    }

    function publicar(livro) {
        livro.DataPublicacao = new Date();
        livrosService.updateLivro(livro.Isbn, livro);
        console.log(livro.DataPublicacao);
        listar();
    }

      $scope.revisorVe = authService.possuiPermissao('Revisor');
      $scope.publicadorVe = authService.possuiPermissao('Publicador');

      function clicouAdd() {
          $scope.mostrarAdicao = true;
          $scope.botaoAdd = true;
      }

      function adicionar() {
        livrosService.criarLivro($scope.novoLivro);
        listar();
        $scope.mostrarAdicao = false;
        $scope.botaoAdd = false;
        listar();
      }

      function clicouAlterar(livro) {
          $scope.novoLivro = livro;
          $scope.mostrarAdicao = true;
          $scope.botaoAlt = true;
      }
        
      function alterar() {
          livrosService.updateLivro($scope.novoLivro.Isbn, $scope.novoLivro);
          $scope.mostrarAdicao = false;
          $scope.botaoAlt = false;
      }  

      function clicouVizualizar(livro) {
          $location.path('/livros/' + livro);
          console.log(livro);
      }

      function excluir(livro) {
          console.log("cliocu");
          listar();
          livrosService.deletar(livro);
          listar();
      }

	});