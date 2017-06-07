angular.module('app')
.factory('produtoService', function ($http) {

    let urlBase = 'http://localhost:53511/api/produto/';
   
    let clientes;

    //getProduto().then(response => clientes = response.dados);

    function  getProduto(headerAuth) {
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
    listarProduto: getProduto,
    buscarProduto: getId
  };
});