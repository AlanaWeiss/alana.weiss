angular.module('app')
    .controller('perfilController', function ($scope, $rootScope) {
    $rootScope.user = {nome: "alana", idade: 19};
    console.log($rootScope.user);

    $rootScope.isAutenticado = true;
});