angular.module('app')
    .config(function ($routeProvider) {
        $routeProvider
        .when('/home', {
            controller: 'homeController',
            templateUrl: 'html/home.html'
        })
        .when('/login', {
            controller: 'loginController',
            templateUrl: 'html/login.html'
        })
        .when('/vendas', {
            controller: 'vendasController',
            templateUrl: 'html/vendas.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise('/home');
});