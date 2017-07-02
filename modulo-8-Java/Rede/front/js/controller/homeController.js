angular.module('app')
    .controller('homeController', function ($scope, authService, $location) {
    $scope.user = authService.getUsuario();
});