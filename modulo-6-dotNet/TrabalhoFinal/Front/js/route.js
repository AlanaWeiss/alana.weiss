angular.module('app')
    .config(function ($routeProvider) {
        $routeProvider
        .when('/home', {
            controller: 'homeController',
            templateUrl: 'html/livros.html'
        })
        .when('/login', {
            controller: 'loginController',
            templateUrl: 'html/login.html'
        })
        .when('/vendas', {
            controller: 'vendasController',
            templateUrl: 'Hhtml/vendas.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise('/home');
});