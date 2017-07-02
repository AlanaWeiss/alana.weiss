angular.module('app')
    .factory('homeService', function ($http) {

    let urlBase = 'http://localhost:9090/api/';
   
    // let clientes;

    //getProduto().then(response => clientes = response.dados);

    // function  getProduto(headerAuth) {
    //   return $http({
    //       url: urlBase,
    //     method: 'GET',
    //     headers: {
    //         Authorization: headerAuth
    //     }
    //   });
    // };


    function criarPublicacao(publicacao) {
        return $http({
          url: urlBase + 'publicacao',
        method: 'POST',
        data: publicacao
      });
    }


  return {
    criarPublicacao : criarPublicacao
  };
});