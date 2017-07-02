angular.module('app')
    .controller('homeController', function ($scope, authService, $location, homeService, toastr) {
    $scope.user = authService.getUsuario();
    console.log($scope.user);

    $scope.logout = function () {
    authService.logout();
  }

    $scope.publicar = function () {
         $scope.post.idpost=0;
        $scope.post.idusuario= {"idusuario":$scope.user.idusuario};
        console.log($scope.post);
         homeService.criarPublicacao($scope.post).then( function (){
              toastr.success('Publicado com sucesso!');
             
        });
    }
});