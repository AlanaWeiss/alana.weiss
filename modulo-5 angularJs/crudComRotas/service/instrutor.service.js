app.factory('instrutorService', function ($http) {
    
    let urlBase = 'http://localhost:3000';
    let instrutores;

    getTodosOsInstrutores().then(response => instrutores = response.data)

    function getTodosOsInstrutores() {
        return $http.get(urlBase + '/instrutor')
    }

    function getInstrutorPorId(id) {
      return $http.get(urlBase + '/instrutor' + '/' + id);
    };

    function atualizar(instrutor) {

          instrutores.forEach((item) => {
            if(item.id === Number(instrutor.id))
                $http.put(urlBase + '/instrutor' + '/' + instrutor.id, instrutor);
          });
  };

  function criar(instrutor) {
    if(typeof instrutor.urlFoto === 'undefined') instrutor.urlFoto = "https://cdn3.iconfinder.com/data/icons/avatars-9/145/Avatar_Penguin-512.png"
       return $http.post(urlBase + '/instrutor', instrutor);
  };

  function deletar(instrutor) {
    return $http.delete(urlBase + '/instrutor/' + instrutor.id, instrutor);
  }

  return {
    list: getTodosOsInstrutores,
    findById: getInstrutorPorId,
    update: atualizar,
    create: criar,
    delete: deletar
  };
})