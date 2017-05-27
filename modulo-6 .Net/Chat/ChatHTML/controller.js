var modulo = angular.module('herois-app', []);

modulo.controller('HeroisController', function ($scope, heroisService, mensagemService) {
    $scope.herois = {};
    $scope.criarUsuario = criarUsuario;
    obterHerois();    

    function obterHerois() {
         $scope.testeNome = localStorage.getItem("Nome");
        heroisService
        .obterHerois()
        .then(response => {
            $scope.herois = response.data;
            $scope.testeId = $scope.herois.find(h => {
               if (h.Nome === $scope.testeNome) {
                   $scope.localId = h.Id;
               }
                
            });
        })
    }

    function criarUsuario() {
         localStorage.setItem("Nome", $scope.novoUsuario.Nome);
         localStorage.setItem("FotoUrl", $scope.novoUsuario.FotoUrl);
        heroisService
        .enviarHeroi($scope.novoUsuario)
        .then(herois => {
            obterHerois();
        })
    }

    $scope.mensagens = {};
    $scope.criarMensagem = criarMensagem;
    obterMensagem();    

    function obterMensagem() {
        mensagemService
        .obterMensagem()
        .then(response => {
            $scope.mensagens = response.data;
        })
    }

    function criarMensagem() {
        $scope.novaMensagem.IdAutor = $scope.localId;
        mensagemService
        .enviarMensagem($scope.novaMensagem)
        .then(mensagens => {
            obterMensagem();
        })
        console.log("clicou");
    }
});