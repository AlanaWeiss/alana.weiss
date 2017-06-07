angular
	.module('app')
	.controller('vendasController', function ($scope, authService, $localStorage, $location, clienteService, produtoService,pacoteService, opcionalService) {
	 $scope.novaReserva ={}
      $scope.auth = authService;
	  $scope.user = authService.getUsuario();
      $scope.buscarCliente = buscarCliente;
      $scope.criarCliente = criarCliente;
      $scope.escolherImovel = escolherImovel;
      $scope.escolherPacote = escolherPacote;
      $scope.escolherOpcionais = escolherOpcionais;
      $scope.finalizar = finalizar;

      listar();
      listarProdutos();
      listarPacote();
      listarOpcional();

      function listar() {
        clienteService.listarClientes()
        .then(response => {
            $scope.clientes = response.data.dados;
            console.log(response.data);
        })
    }

      function buscarCliente(cpf){
            clienteService.buscarCliente(cpf)
            .then (response => {
                $scope.novaReserva.Cliente = response.data.dados;
                 if($scope.novaReserva.Cliente=== null){
                     $scope.clienteNaoExiste = true;
                 }
            })
      }

      function criarCliente() {
          $scope.novoCliente.Id = 1;
          clienteService.criarCliente($scope.novoCliente).then(response => listar());
           listar();
           listar;
      }

      function listarProdutos() {
          produtoService.listarProduto($localStorage.headerAuth)
          .then( response => {
              $scope.produtos = response.data.dados;
              console.log(response.data);
          })
      }

      function escolherImovel() {
          $scope.novaReserva.Produto = JSON.parse($scope.novaReserva.Produto);
          console.log($scope.novaReserva);
          $scope.mostrarPacotes = true;
      }

      function listarPacote() {
          pacoteService.listarPacote($localStorage.headerAuth)
          .then( response => {
              $scope.pacotes = response.data.dados;
              console.log(response.data);
          })
      }

      function escolherPacote() {
          $scope.novaReserva.Pacote = JSON.parse($scope.novaReserva.Pacote);
          $scope.mostrarOpcionais = true;
      }

      function listarOpcional() {
          opcionalService.listarOpcional($localStorage.headerAuth)
          .then( response => {
              $scope.opcionais = response.data.dados;
              console.log('eita',response.data);
          })
      }
      
      function escolherOpcionais() {
          $scope.novaReserva.Opcionais = JSON.parse($scope.novaReserva.Opcionais);
          $scope.mostrarFinalizar = true;
      }

      function finalizar() {
          console.log('nova reserva', $scope.novaReserva);
          $scope.reserva = true;
      }

	});