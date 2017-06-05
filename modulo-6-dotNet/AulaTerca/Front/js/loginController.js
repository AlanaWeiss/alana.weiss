angular.module('livraria').controller('loginController', function ($scope, authService, $location) {

  if(authService.isAutenticado()){
  $location.path('/administrativo');
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