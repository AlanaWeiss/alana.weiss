angular
	.module('app')
	.controller('homeController', function ($scope, authService, $location) {
	 
      $scope.auth = authService;
	  $scope.user = authService.getUsuario();

      if(authService.isAutenticado()){
        $scope.botaoLogout = true;
      }
      else $scope.botaoLogout = false;
      
	});