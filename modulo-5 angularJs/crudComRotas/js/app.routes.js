app.config(function ($routeProvider) {

  $routeProvider
    .when('/aula', {
      controller: 'aulaController',
      templateUrl: 'html/aula.html'
    })
    .when('/instrutor', {
      controller: 'instrutorController',
      templateUrl: 'html/instrutor.html'
    })
    .otherwise({redirectTo: '/index.html'});
});