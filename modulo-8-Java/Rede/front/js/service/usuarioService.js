angular.module('app')
    .factory('usuarioService', function ($http) {

    let urlBase = 'http://localhost:9090/api/usuario/';

    function criarUsuario(usuario) {
        return $http({
          url: urlBase,
        method: 'POST',
        data: usuario
      });
    }

    function alterarUsuario(usuario) {
        return $http({
          url: urlBase,
        method: 'PUT',
        data: usuario
      });
    }
    
    function getUsuario(idusuario) {
        return $http({
          url: urlBase + idusuario,
        method: 'GET'
      });
    }


  return {
    criarUsuario : criarUsuario,
    getUsuario : getUsuario,
    alterarUsuario : alterarUsuario
  };
});