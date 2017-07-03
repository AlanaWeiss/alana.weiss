angular.module('app')
  .factory('amigosService', function ($http) {

    let urlBase = 'http://localhost:9090/api/';

    // let clientes;

    //getProduto().then(response => clientes = response.dados);

    function getAmigosPendentes(user) {
      return $http({
        url: urlBase + 'amizade/pendentes/'+user.idusuario,
        method: 'GET'
        // headers: {
        //   Authorization: headerAuth
        // }
      });
    };

    function getAmigos(user) {
      return $http({
        url: urlBase + 'amizade/aceitos/'+user.idusuario,
        method: 'GET'
        // headers: {
        //   Authorization: headerAuth
        // }
      });
    };

    function buscarUsuario(stringBusca) {
      return $http({
        url: urlBase + 'usuario/search?busca=' + stringBusca,
        method: 'GET'
      });
    }

    function solicitarAmizade(amizade) {
      return $http({
        url: urlBase + 'amizade',
        method: 'POST',
        data: amizade
      });
    }

    function aceitarAmizade(amizade) {
      return $http({
        url: urlBase + 'amizade/aceitar/' + amizade,
        method: 'PUT'
      });
    }


    return {
      buscarUsuario: buscarUsuario,
      getAmigos : getAmigos,
      solicitarAmizade : solicitarAmizade,
      getAmigosPendentes:getAmigosPendentes
    };
  });