angular.module('app')
    .controller('amigosController', function ($scope, $rootScope, $location, authService, amigosService, toastr) {
        $scope.user = authService.getUsuario();
        console.log($scope.user);
         listar();
         jaConvidados();

         function listar() {
             amigosService.getAmigos($scope.user).then(function (response) {
                 $scope.amigos = response.data;
                 console.log($scope.amigos);
             })
         }

         function jaConvidados() {
             amigosService.getJaConvidado($scope.user)
                .then(function (response) {
                    $scope.convidados = response.data;
                    console.log("convidados",$scope.convidados);
                })
         }
         $scope.buscar = function (stringBusca) {
             
             $scope.mostraResultado = true;
             amigosService.buscarUsuario(stringBusca)
                .then(function (response) {
                    $scope.resultadoBusca = response.data;
                    $scope.resultadoBusca.forEach(function(resultado) {
                        $scope.amigos.forEach(function(amigo) {
                            if ($scope.convidados.lenght >0) {
                                
                            }
                            $scope.convidados.forEach(function(convidado) {
                                console.log("convidado",convidado);
                            console.log("resultado",resultado);
                            console.log("amigo", amigo);
                            if (amigo.email === resultado.email) {
                                resultado.ehAmigo = true;
                                resultado.amigos = true;
                                
                            }
                            if (resultado.email === $scope.user.email) {
                                debugger;
                                resultado.naoEhAmigo = true;
                            }
                            if (convidado.idsolicitado.email === resultado.email) {
                                debugger;
                                resultado.jaConvidado = true;
                                resultado.ehAmigo = true;
                            }
                            }, this);
                        }, this);
                    }, this);
                    console.log($scope.resultadoBusca);
                })
         }


         $scope.solicitar = function (solicitado) {
             debugger;
             var amizade = {
                 "idamizade":0,
                "idsolicitante":{"idusuario":$scope.user.idusuario},
                 "idsolicitado":{"idusuario":solicitado}
             }
             amigosService.solicitarAmizade(amizade)
                .then(function () {
                    toastr.success('Solicitado!');
                })
         }

         $scope.perfilAmigo = function (idusuario){
            $location.path('/vizualizar/' + idusuario);
         }
});