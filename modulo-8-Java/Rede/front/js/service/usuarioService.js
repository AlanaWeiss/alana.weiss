angular.module('app')
    .factory('usuarioService', function ($http) {

    let urlBase = 'http://localhost:9090/api/usuario';
   
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


    function criarUsuario(usuario) {
        return $http({
          url: urlBase,
        method: 'POST',
        data: usuario
      });
    }


  return {
    criarUsuario : criarUsuario
  };
});