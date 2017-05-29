var modulo = angular.module('herois-app', []);

modulo.controller('HeroisController', function ($scope, heroisService, mensagemService) {
    $scope.exibe = function () {
        return (localStorage.getItem("Nome") === null) ? true : false;
    }
    $scope.exibeChat = function () {
        return (localStorage.getItem("Nome") === null) ? false : true;
    }
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
         
        heroisService
        .enviarHeroi($scope.novoUsuario)
        .then(herois => {
            localStorage.setItem('Nome', $scope.novoUsuario.Nome);
            localStorage.setItem('FotoUrl', $scope.novoUsuario.FotoUrl);
            obterHerois();
        }).then(a => obterHerois());
    }

    $scope.mensagens = {};
    $scope.criarMensagem = criarMensagem;
    
     obterMensagem(); 
    
             
       setInterval(function(){ 
        
                            obterMensagem(); 
                          
                          }, 1000);
       

    function obterMensagem() {
        mensagemService
        .obterMensagem()
        .then(response => {
            $scope.mensagens = response.data;
            
        })
    }

    $scope.usuario = {nome:localStorage.getItem('Nome'), FotoUrl:localStorage.getItem('FotoUrl')};

    function criarMensagem() {
        $scope.novaMensagem.Usuario = $scope.usuario;
        console.log($scope.novaMensagem.Usuario.nome);
        console.log($scope.novaMensagem.Usuario.FotoUrl);
        mensagemService
        .enviarMensagem($scope.novaMensagem)
        .then(mensagens => {
            obterMensagem();
        })
        console.log("clicou");
        delete $scope.novaMensagem;
    }
});