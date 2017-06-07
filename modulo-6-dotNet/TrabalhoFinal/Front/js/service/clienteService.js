angular.module('app')
.factory('clienteService', function ($http) {

    let urlBase = 'http://localhost:53511/api/cliente/';
   
    let clientes;

    getClientes().then(response => clientes = response.dados);

    function  getClientes() {
      return $http.get(urlBase);
    };

//     // function  getLancamentos() {
//     //   return $http.get(urlBase + '/lancamentos');
//     // }

    function getCpf(cpf) {
      return $http.get(urlBase + cpf);
    }

//     // function listarLivrosPaginacao(parametros) {
//     //   return $http({
//     //         url: urlBase,
//     //         method: 'GET',
//     //         params: parametros
//     //       });
//     // }

//     // function  getIncompletos() {
//     //   return $http.get(urlBase + '/incompletos');
//     // }

//     // function putIsbn(isbn, livro) {
//     //   return $http.put(urlBase + isbn, livro);

//     // } 

// //     function putIsbn(isbn, livro) {
// //     return $http({
// //       url: urlBase + isbn,
// //       method: 'PUT',
// //       data: livro
// //     });
// //   }

  function criar(cliente) {
    return $http({
      url: urlBase,
      method: 'POST',
      data: cliente
    });
  }

// //   function deletar(cliente) {
// //     return $http.delete(urlBase + livro.Isbn, livro);
// //     }
// // //     function getAulaPorId(id) {
// //       return $http.get(urlBase + '/aula' + '/' + id);
// //     };

// //     function atualizar(aula) {

// //           aulas.forEach((item) => {
// //             if(item.id === Number(aula.id))
// //                 $http.put(urlBase + '/aula' + '/' + aula.id, aula);
// //           });
// //   };

// //   function criar(aula) {

// //        return $http.post(urlBase + '/aula', aula);
// //   };

// //   function deletar(aula) {
// //     return $http.delete(urlBase + '/aula/' + aula.id, aula);
// //     alert("Ação realizada com sucesso!");
// //   }

  return {
    listarClientes: getClientes,
    criarCliente: criar,
    buscarCliente: getCpf
  };
});