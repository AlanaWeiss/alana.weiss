angular.module('app')
    .controller('homeController', function ($scope, authService, $location, homeService) {
    $scope.user = authService.getUsuario();
    console.log($scope.user);

});