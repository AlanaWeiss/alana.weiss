angular
	.module('app')
	.controller('relatorioController', function ($scope, authService,  $localStorage, $location, reservaService) {
		$scope.procurar = procurar;

		function procurar() {
			data = $scope.dataProcura.toISOString().split('T')[0];
			console.log(data);

			reservaService.relatorio(data, $localStorage.headerAuth)
			.then(response => {
				$scope.finalizadas = response.data.dados;
			})
		}
	});