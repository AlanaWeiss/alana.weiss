angular.module('app')
    .controller('homeController', function ($scope, authService, $location, homeService, toastr, curtidaService) {
    $scope.user = authService.getUsuario();
    console.log($scope.user);
    listar();
    $scope.curtido = false;
    $scope.descurtido= true;

    $scope.logout = function () {
    authService.logout();
  }

    $scope.publicar = function () {
         $scope.post.idpost=0;
        $scope.post.idusuario= {"idusuario":$scope.user.idusuario};
        console.log($scope.post);
         homeService.criarPublicacao($scope.post).then( function (){
              toastr.success('Publicado com sucesso!');
              listar();
              $scope.post = {};
             
        });
    }

    function listar() {
        homeService.getPost($scope.user).then(function (response) {
            $scope.posts = response.data;
            console.log($scope.posts);
        })
    }

    $scope.curtir = function (idpost) {
        var curtida = {
            "idcurtida":0, "idpost":{"idpost":idpost}, "idusuario":{"idusuario":$scope.user.idusuario}
        }
        console.log("curti",curtida);
        curtidaService.curtir(curtida)
            .then(function () {
                $scope.curtido = true;
                 $scope.descurtido = false;
            })
    }

    $scope.descurtir = function (idpost) {
         $scope.curtido = false;
        $scope.descurtido = true;
    }
});