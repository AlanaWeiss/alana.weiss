angular.module('app')
    .controller('perfilController', function ($scope, $location, authService, $location, usuarioService, toastr, $routeParams,homeService) {
        $scope.user = authService.getUsuario();
        $scope.user.datanascimento = new Date($scope.user.datanascimento);
        var id = $scope.user.idusuario;
        listar(id);
        console.log(id);
        function listar(id) {
            $scope.user = authService.getUsuario();
            usuarioService.getUsuario(id)
                .then(function (response) {
                    $scope.userA = response.data;
                    console.log($scope.userA);
                });
            homeService.getPostUsuario(id)
                .then(function (response) {
                    $scope.posts = response.data;
                })
        }

        $scope.alterar = function () {
            $location.path('/alterar/' + $scope.userA.idusuario);
        }

        $scope.salvarAlteracao = function () {
            debugger;
            usuarioService.alterarUsuario($scope.user)
                .then(function (response) {
                   $location.path('/perfil/' + $scope.user.idusuario);
                    toastr.success('Perfil Alterado');
                })
        }
    });