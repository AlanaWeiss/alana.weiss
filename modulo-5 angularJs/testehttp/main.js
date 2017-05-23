let app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/pagina01', {
      controller: 'Pagina01Controller',
      templateUrl: 'pagina01.html'
    })
    .when('/pagina02', {
      controller: 'Pagina02Controller',
      templateUrl: 'pagina02.html'
    })
    .otherwise({redirectTo: '/pagina01'});
});

app.controller('PrincipalController', function ($scope) {
  $scope.controller = 'PrincipalController';
  $scope.aulas = ['OO'];
});

app.controller('Pagina01Controller', function ($scope) {
  $scope.controller = 'Pagina01Controller';
});

app.controller('Pagina02Controller', function ($scope) {
  $scope.controller = 'Pagina02Controller';
});
