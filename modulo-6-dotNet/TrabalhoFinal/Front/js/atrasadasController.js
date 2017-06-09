angular
	.module('app')
	.controller('atrasadasController', function ($scope, authService, $localStorage, $location, reservaService) {

        listarAtrasadas();


        function listarAtrasadas() {
            reservaService.atrasadas($localStorage.headerAuth)
            .then( response => {
                $scope.atrasadas = response.data.dados;
            })
        }
    });