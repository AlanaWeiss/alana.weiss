angular.module('app')
    .config(function ($routeProvider) {
        $routeProvider
        .when('/home', {
            controller: 'homeController',
            templateUrl: 'html/home.html'
        })
        .when('/perfil', {
            controller: 'perfilController',
            templateUrl: 'html/perfil.html'
        })
        .otherwise('/perfil');
});