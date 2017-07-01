angular.module('app')
    .controller('cadastrarController', function ($scope, $rootScope, $location, usuarioService) {
   
   $scope.cadastrar = function () {
    // if ($scope.formCadastro.$valid) {
        $scope.user.idusuario=0;

        usuarioService.criarUsuario($scope.user).then( function (){
            alert('Cadastro com sucesso! Faça o Login');
            $location.path('/login');
        });
    // } else {
    //     alert('Preencha todos os dados corretamente.', 'Dados inválidos!');
    // }
  };
});