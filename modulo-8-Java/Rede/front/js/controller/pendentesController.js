angular.module('app')
    .controller('pendentesController', function ($scope, $rootScope, $location, authService, amigosService, toastr) {
        $scope.user = authService.getUsuario();
        console.log($scope.user);
         listar();

         function listar() {
             amigosService.getAmigosPendentes($scope.user).then(function (response) {
                 $scope.pendentes = response.data;
                 console.log($scope.pendentes);
             })
         }

         
         $scope.aceitar = function (amizade) {
             debugger;
            console.log(amizade);
         }
});