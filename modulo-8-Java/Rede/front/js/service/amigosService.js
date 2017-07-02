angular.module('app')
  .factory('amigosService', function ($http) {

    let urlBase = 'http://localhost:9090/api/';

    // let clientes;

    //getProduto().then(response => clientes = response.dados);

    function getAmigos(user) {
      return $http({
        url: urlBase + 'amizade/pendentes/'+user.idusuario,
        method: 'GET'
        // headers: {
        //   Authorization: headerAuth
        // }
      });
    };


    function criarPublicacao(publicacao) {
      return $http({
        url: urlBase + 'publicacao',
        method: 'POST',
        data: publicacao
      });
    }


    return {
      criarPublicacao: criarPublicacao,
      getAmigos : getAmigos
    };
  });