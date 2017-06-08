angular.module('app')
.factory('pacoteService', function ($http) {

    let urlBase = 'http://localhost:53511/api/pacote/';
   
    let clientes;

    //getProduto().then(response => clientes = response.dados);

    function  getPacote(headerAuth) {
      return $http({
          url: urlBase,
        method: 'GET',
        headers: {
            Authorization: headerAuth
        }
      });
    };


    function getId(id) {
      return $http.get(urlBase + id);
    }


  return {
    listarPacote: getPacote,
    buscarPacote: getId
  };
});