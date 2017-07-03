angular.module('app')
    .controller('amigosController', function ($scope, $rootScope, $location, authService, amigosService, toastr) {
        $scope.user = authService.getUsuario();
        console.log($scope.user);
         listar();

         function listar() {
             amigosService.getAmigos($scope.user).then(function (response) {
                 $scope.amigos = response.data;
                 console.log($scope.amigos);
             })
         }

         $scope.buscar = function (stringBusca) {
             $scope.mostraResultado = true;
             amigosService.buscarUsuario(stringBusca)
                .then(function (response) {
                    $scope.resultadoBusca = response.data;
                    console.log($scope.resultadoBusca);
                })
         }


         $scope.solicitar = function (solicitado) {
             debugger;
             var amizade = {
                 "idamizade":0,
                "idsolicitante":{"idusuario":$scope.user.idusuario},
                 "idsolicitado":{"idusuario":solicitado}
             }
             amigosService.solicitarAmizade(amizade)
                .then(function () {
                    toastr.success('Solicitado!');
                })
         }
});