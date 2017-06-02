angular.module('livraria')
.factory('livrosService', function ($http) {

    let urlBase = 'http://localhost:60523/api/Livros/';
   
    let livros;

    getLivros().then(response => livros = response.dados);

    function  getLivros() {
      return $http.get(urlBase);
    };

     function listar(parametros) {
      return $http({
            url: urlBase,
            method: 'GET',
            params: parametros
          });
  }

    function  getLancamentos() {
      return $http.get(urlBase + '/lancamentos');
    }

    function getIsbn(isbn) {
      return $http.get(urlBase + isbn);
    }

//     function getAulaPorId(id) {
//       return $http.get(urlBase + '/aula' + '/' + id);
//     };

//     function atualizar(aula) {

//           aulas.forEach((item) => {
//             if(item.id === Number(aula.id))
//                 $http.put(urlBase + '/aula' + '/' + aula.id, aula);
//           });
//   };

//   function criar(aula) {

//        return $http.post(urlBase + '/aula', aula);
//   };

//   function deletar(aula) {
//     return $http.delete(urlBase + '/aula/' + aula.id, aula);
//     alert("Ação realizada com sucesso!");
//   }

  return {
    list: getLivros,
    listNews : getLancamentos,
    buscarIsbn : getIsbn
    // findById: getAulaPorId,
    // update: atualizar,
    // create: criar,
    // delete: deletar
  };
});