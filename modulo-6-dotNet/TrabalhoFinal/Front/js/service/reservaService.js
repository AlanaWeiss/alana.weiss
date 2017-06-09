angular.module('app')
.factory('reservaService', function ($http) {

    let urlBase = 'http://localhost:53511/api/reserva/';
   
    let clientes;

    //getProduto().then(response => clientes = response.dados);

    function  getReserva(headerAuth) {
      return $http({
          url: urlBase,
        method: 'GET',
        headers: {
            Authorization: headerAuth
        }
      });
    };

    function naoDevolvidas(headerAuth) {
      return $http({
        url: urlBase + "devolucoes",
        method: 'GET',
        headers: {
            Authorization: headerAuth
        }
      });
    }

    function getId(id) {
      return $http.get(urlBase + id);
    }

    function criarReserva(reserva, headerAuth) {
        return $http({
          url: urlBase,
        method: 'POST',
        headers: {
            Authorization: headerAuth
        },
        data: reserva
      });
    }

    function devolverReserva(reserva, headerAuth) {
        return $http({
          url: urlBase + "devolver/" + reserva.Id,
        method: 'PUT',
        headers: {
            Authorization: headerAuth
        }//,
        //data: reserva
      });
    }

    function calcularOrcamento(reserva, headerAuth) {
        return $http({
          url: urlBase + "orcamento",
        method: 'POST',
        headers: {
            Authorization: headerAuth
        },
        data: reserva
      });
    }


  return {
    listarReserva: getReserva,
    buscarProduto: getId,
    criarReserva: criarReserva,
    devolverReserva: devolverReserva,
    orcamento : calcularOrcamento,
    naoDevolvidas : naoDevolvidas
  };
});