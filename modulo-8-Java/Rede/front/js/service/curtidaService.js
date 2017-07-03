angular.module('app')
  .factory('curtidaService', function ($http) {

    let urlBase = 'http://localhost:9090/api/curtir/';

    function curtir(post) {
      return $http({
        url: urlBase,
        method: 'POST',
        data: post
      });
    }

    function descurtir(idcurtida) {
      return $http({
        url: urlBase + 'descurtir/' + idcurtida,
        method: 'DELETE'
      });
    }

    return {
      curtir : curtir,
      descurtir : descurtir
    };
  });