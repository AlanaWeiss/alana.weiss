angular
	.module('app')
	.controller('vendasController', function ($scope, authService, $localStorage, $location, clienteService, produtoService,pacoteService, opcionalService, reservaService) {
	 $scope.novaReserva ={}
      $scope.auth = authService;
	  $scope.user = authService.getUsuario();
      $scope.buscarCliente = buscarCliente;
      $scope.criarCliente = criarCliente;
      $scope.escolherImovel = escolherImovel;
      $scope.escolherPacote = escolherPacote;
      $scope.escolherOpcionais = escolherOpcionais;
      $scope.finalizar = finalizar; 
      $scope.calcularOrcamento = calcularOrcamento;

      listar();
      listarProdutos();
      listarPacote();
      listarOpcional();
      listarReserva();

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
          clienteService.criarCliente($scope.novoCliente).then(response => {
              listar();
              //$scope.novaReserva.Cliente = $scope.novoCliente;
            })
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
          //$scope.novaReserva.Produto = JSON.parse($scope.novaReserva.Produto);
          console.log($scope.novaReserva.Produto);
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
         // $scope.novaReserva.Pacote = JSON.parse($scope.novaReserva.Pacote);
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
         // $scope.novaReserva.Opcional = JSON.parse($scope.novaReserva.Opcional);
          $scope.mostrarFinalizar = true;
          console.log('nova reserva', $scope.novaReserva);
      }

      function finalizar(novaReserva) {
          debugger;
          console.log('nova reserva2', novaReserva);
          reservaService.criarReserva(novaReserva, $localStorage.headerAuth);
          delete $scope.novaReserva;
      }

    function listarReserva() {
          reservaService.listarReserva($localStorage.headerAuth)
          .then( response => {
              $scope.reservas = response.data.dados;
              console.log(response.data);
          })
      }

      function calcularOrcamento(novaReserva) {
          reservaService.orcamento(novaReserva, $localStorage.headerAuth).then(response => {
              $scope.reservaOrcamento = response.data.dados;
              console.log( $scope.reservaOrcamento);
          })
      }
	});