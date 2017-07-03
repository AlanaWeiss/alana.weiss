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
        .when('/login', {
            controller: 'loginController',
            templateUrl: 'html/login.html'
        })
        .when('/cadastrar', {
            controller: 'cadastrarController',
            templateUrl: 'html/cadastrar.html'
        })
        .when('/amigos', {
            controller: 'amigosController',
            templateUrl: 'html/amigos.html'
        })
        .when('/vizualizar', {
            controller: 'perfilAmigoController',
            templateUrl: 'html/perfilAmigo.html'
        })
        .when('/pendentes', {
            controller: 'pendentesController',
            templateUrl: 'html/pendentes.html'
        })
        .otherwise('/home');
});