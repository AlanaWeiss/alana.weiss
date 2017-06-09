angular
	.module('app')
	.controller('atrasadasController', function ($scope, authService, $localStorage, $location, reservaService) {
        $scope.relistar =relistar;
        listarAtrasadas();


        function listarAtrasadas() {
            reservaService.atrasadas($localStorage.headerAuth)
            .then( response => {
                $scope.atrasadas = response.data.dados;
            })
        }

        function relistar() {
            reservaService.atrasadas($localStorage.headerAuth)
            .then( response => {
                $scope.atrasadas = response.data.dados;
            })
        }
    });