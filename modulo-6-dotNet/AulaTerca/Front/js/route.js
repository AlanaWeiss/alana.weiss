angular.module('livraria')
    .config(function ($routeProvider) {
        $routeProvider
        .when('/livros', {
            controller: 'livrosController',
            templateUrl: 'html/livros.html'
        })
        .when('/livros/:isbn', {
            controller: 'livroVizualizarController',
            templateUrl: 'html/livroVisualizar.html'
        })
        .when('/login', {
            controller: 'loginController',
            templateUrl: 'html/login.html'
        })
        .otherwise('/livros');
});