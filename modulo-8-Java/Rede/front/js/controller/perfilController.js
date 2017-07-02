angular.module('app')
    .controller('perfilController', function ($scope, authService, $location) {
    $scope.user = authService.getUsuario();
});