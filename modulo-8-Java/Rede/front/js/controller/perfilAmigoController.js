angular.module('app')
    .controller('perfilAmigoController', function ($scope, authService, $location, usuarioService, toastr, $routeParams, homeService) {
       
        listar($routeParams.idusuario);

        function listar(idusuario) {
            $scope.user = authService.getUsuario();
            usuarioService.getUsuario(idusuario)
                .then(function (response) {
                    $scope.userA = response.data;
                });
            
            homeService.getPostUsuario(idusuario)
                .then(function (response) {
                    $scope.posts = response.data;
                })
        }
    });