app.factory('aulaService', function ($http) {

    let urlBase = 'http://localhost:3000';
    let aulas;

    getTodasAsAulas().then(response => aulas = response.data);

    function getTodasAsAulas() {
      return $http.get(urlBase + '/aula');
    };

    function getAulaPorId(id) {
      return $http.get(urlBase + '/aula' + '/' + id);
    };

    function atualizar(aula) {

          aulas.forEach((item) => {
            if(item.id === Number(aula.id))
                $http.put(urlBase + '/aula' + '/' + aula.id, aula);
          });
  };

  function criar(aula) {

       return $http.post(urlBase + '/aula', aula);
  };

  function deletar(aula) {
    return $http.delete(urlBase + '/aula/' + aula.id, aula);
    alert("Ação realizada com sucesso!");
  }

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar,
    delete: deletar
  };
});