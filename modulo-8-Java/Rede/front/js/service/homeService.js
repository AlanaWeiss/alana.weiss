angular.module('app')
  .factory('homeService', function ($http) {

    let urlBase = 'http://localhost:9090/api/publicacao/';

    // let clientes;

    //getProduto().then(response => clientes = response.dados);

    function getPost(user) {
      return $http({
        url: urlBase + 'amigos/'+user.idusuario,
        method: 'GET'
      });
    };

    function getPostUsuario(user) {
      return $http({
        url: urlBase + user.idusuario,
        method: 'GET'
      });
    }


    function criarPublicacao(publicacao) {
      return $http({
        url: urlBase,
        method: 'POST',
        data: publicacao
      });
    }


    return {
      criarPublicacao: criarPublicacao,
      getPost : getPost
    };
  });