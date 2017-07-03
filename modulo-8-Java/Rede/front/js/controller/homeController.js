angular.module('app')
    .controller('homeController', function ($scope, authService, $location, homeService, toastr, curtidaService) {
        $scope.user = authService.getUsuario();
        console.log($scope.user);
        listar();
        $scope.curtido = false;
        $scope.descurtido = true;

        $scope.logout = function () {
            authService.logout();
        }

        $scope.publicar = function () {
            $scope.post.idpost = 0;
            $scope.post.idusuario = {
                "idusuario": $scope.user.idusuario
            };
            console.log($scope.post);
            homeService.criarPublicacao($scope.post).then(function () {
                toastr.success('Publicado com sucesso!');
                listar();
                $scope.post = {};

            });
        }
        var i = 0;

        function listar() {
            homeService.getPost($scope.user).then(function (response) {

                $scope.posts = response.data;
                console.log($scope.posts);
                $scope.posts.forEach(function (post) {
                    getCurtidas(post)
                }, this);
            })
        }

        function getCurtidas(post) {
             curtidaService.getCurtidas(post.idpost)
                .then(function (response) {
                    post.curtidas = response.data;
                    console.log(post.curtidas);
                    post.curtidas.forEach(function (curtida) {
                        if (curtida.idusuario.idusuario === $scope.user.idusuario && curtida.idpost.idpost === post.idpost) {
                            post.curtido=true;
                        }
                    }, this);
                })
        }

        $scope.curtir = function (idpost) {
            var curtida = {
                "idcurtida": 0,
                "idpost": {
                    "idpost": idpost
                },
                "idusuario": {
                    "idusuario": $scope.user.idusuario
                }
            }
            console.log("curti", curtida);
            curtidaService.curtir(curtida)
                .then(function () {
                    $scope.curtido = true;
                    $scope.descurtido = false;
                    console.log("aqui", {
                        "idposr": curtida.idpost.idpost,
                        "idusuario": curtida.idusuario.idusuario
                    });
                    listar();
                });
            curtidaService.buscarCurtida(curtida.idpost.idpost, curtida.idusuario.idusuario)
                .then(function (response) {
                    $scope.curtidaUsuario = response.data;
                    console.log("curtida usuario", $scope.curtidaUsuario);
                })
        }

        $scope.descurtir = function (idpost) {
            var curtida = {
                "idcurtida": 0,
                "idpost": {
                    "idpost": idpost
                },
                "idusuario": {
                    "idusuario": $scope.user.idusuario
                }
            }
            curtidaService.buscarCurtida(curtida.idpost.idpost, curtida.idusuario.idusuario)
                .then(function (response) {
                    $scope.curtidaU = response.data;
                    console.log("descurtidausuario", $scope.curtidaU);
                    curtidaService.descurtir($scope.curtidaU.idcurtida)
                        .then(function () {
                            $scope.curtido = false;
                            $scope.descurtido = true;
                        })
                })


        }
    });