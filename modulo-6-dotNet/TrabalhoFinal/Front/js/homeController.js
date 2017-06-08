angular
	.module('app')
	.controller('homeController', function ($scope, authService, $location) {
	 
      $scope.auth = authService;
	  $scope.user = authService.getUsuario();

      if(authService.isAutenticado()){
        $scope.botaoLogout = true;
        $scope.botaoLogin = false;
      }
      else{
         $scope.botaoLogout = false;
          $scope.botaoLogin = true;
      }

      console.log($scope.user);

      $scope.gerente = authService.possuiPermissao('Balconista');
      
      $scope.irParaVendo = function () {
      $location.path('/vendas/');
      }
	});