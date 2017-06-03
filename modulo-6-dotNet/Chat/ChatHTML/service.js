modulo.factory("heroisService", function ($http) {
    return ({
        obterHerois: obterUsuarios,
        enviarHeroi: enviarUsuarios
    });

    function obterUsuarios() {
        return $http.get("http://localhost:53264/api/Usuarios");
    }

    function enviarUsuarios(usuario) {
        return $http.post("http://localhost:53264/api/Usuarios", usuario);
    }
});

modulo.factory("mensagemService", function ($http) {
    return ({
        obterMensagem: obterMensagem,
        enviarMensagem: enviarMensagem
    });

    function obterMensagem() {
        return $http.get("http://localhost:53264/api/Mensagens");
    }

    function enviarMensagem(usuario) {
        return $http.post("http://localhost:53264/api/Mensagens", usuario);
    }
});