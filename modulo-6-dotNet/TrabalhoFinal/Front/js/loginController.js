angular.module('app').controller('loginController', function ($scope, authService, $location) {

  if(authService.isAutenticado()){
  $location.path('/vendas');
}
  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          alert('Login com sucesso!');

        },
        function (response) {
          console.log(response);
          alert('Erro no Login!');
        });
  };

});