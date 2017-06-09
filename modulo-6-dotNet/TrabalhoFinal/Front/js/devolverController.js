angular
	.module('app')
	.controller('devolverController', function ($scope, authService, $localStorage, $location, reservaService) {

        $scope.devolverReserva = devolverReserva;
        listarDevolver();

        function devolverReserva(reserva) {
           
            reservaService.devolverReserva(reserva, $localStorage.headerAuth)
            .then(response => {
                $scope.devolvida = response.data.dados;
                listarDevolver();
                console.log("devolveu", reserva.Id);
                console.log("devolveu", $scope.devolvida);
                $scope.valorTotal = true;
            })
        }

        function listarDevolver() {
            reservaService.naoDevolvidas($localStorage.headerAuth)
            .then( response => {
                $scope.reservas = response.data.dados;
            })
        }

        function valorTotal() {
            $scope.valorTotal = false;
        }
    });
	