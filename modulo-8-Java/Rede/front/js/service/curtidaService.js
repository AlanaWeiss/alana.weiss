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

    function descurtir(curtida) {
      return $http({
        url: urlBase + 'descurtir/' + curtida,
        method: 'DELETE'
      });
    }

    function buscarCurtida(idPost, idUsuario) {
      return $http({
        url: urlBase + 'user/' + idUsuario + '?idPost=' + idPost,
        method: 'GET'
      });
    }

    function getCurtidas(idPost) {
      return $http({
        url: urlBase + idPost,
        method: 'GET'
      });
    }

    return {
      curtir : curtir,
      descurtir : descurtir,
      buscarCurtida : buscarCurtida,
      getCurtidas : getCurtidas
    };
  });