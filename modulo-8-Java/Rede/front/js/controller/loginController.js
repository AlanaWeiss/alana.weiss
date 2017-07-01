angular.module('app')
    .controller('loginController', function ($scope, authService, $location) {
   
   $scope.login = function (usuario) {

    if ($scope.formLogin.$valid) {
    authService.login(usuario)
      .then(function (response) {
            alert('Login com sucesso!');
            $location.path('/home');
          
        },
        function (response) {
          alert('Login ou Senha inválidos!');
        });
    } else {
        alert('Preencha todos os dados corretamente.', 'Dados inválidos!');
    }
  };

});