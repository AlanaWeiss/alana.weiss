angular.module('app')
    .controller('amigosController', function ($scope, $rootScope, $location, authService, amigosService) {
        $scope.user = authService.getUsuario();
        console.log($scope.user);
         listar();

         function listar() {
             amigosService.getAmigos($scope.user).then(function (response) {
                 $scope.amigos = response.data;
                 console.log($scope.amigos);
             })
         }
});