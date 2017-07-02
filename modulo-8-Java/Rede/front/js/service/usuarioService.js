angular.module('app')
    .factory('usuarioService', function ($http) {

    let urlBase = 'http://localhost:9090/api/usuario';

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