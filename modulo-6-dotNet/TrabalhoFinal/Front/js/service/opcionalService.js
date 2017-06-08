angular.module('app')
.factory('opcionalService', function ($http) {

    let urlBase = 'http://localhost:53511/api/opcional/';
   
    let clientes;

    //getProduto().then(response => clientes = response.dados);

    function  getOpcional(headerAuth) {
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
    listarOpcional: getOpcional,
    buscarOpcional: getId
  };
});