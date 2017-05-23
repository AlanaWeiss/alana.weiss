app.factory('instrutorService', function ($http) {
    
    let urlBase = 'http://localhost:3000';
    let instrutores;

    getTodosOsInstrutores().then(response => instrutores = response.data)

    function getTodosOsInstrutores() {
        return $http.get(urlBase + '/instrutor')
    }

    return {
        list: getTodosOsInstrutores
    }
})