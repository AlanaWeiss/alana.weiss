angular.module('app')
    .controller('pendentesController', function ($scope, $rootScope, $location, authService, amigosService, toastr) {
        $scope.user = authService.getUsuario();
        console.log($scope.user);
         if(!authService.isAutenticado()){
            $location.path("/login");
        }
        listar();

        function listar() {
            amigosService.getAmigosPendentes($scope.user).then(function (response) {
                $scope.pendentes = response.data;
                console.log( $scope.pendentes);
            })
        }



        $scope.aceitar = function (amizade) {
            debugger;
            amigosService.aceitarAmizade(amizade.idamizade)
                .then(function () {
                    toastr.success('Aceito!');
                    listar();
                })
            console.log(amizade);
        }
    });