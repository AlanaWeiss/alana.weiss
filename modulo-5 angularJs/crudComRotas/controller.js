var myApp = angular.module('myApp', []);


myApp.config(function ($routeProvider) {

  $routeProvider
    .when('/aulas', {
      controller: 'aulasController',
      templateUrl: 'aulas.html'
    })
    .when('/instrutores', {
      controller: 'instrutoresController',
      templateUrl: 'instrutores.html'
    })
    .otherwise({redirectTo: '/index.html'});
});

myApp.controller('aulasController', function ($scope) {
      $scope.incluir = function () {
        if($scope.meuForm.$valid && !verificaAulaExiste($scope.novaAula.nome)){
          $scope.novaAula.id = idAula++;
            $scope.aulas.push(angular.copy($scope.novaAula));
            $scope.novaAula = {}
        } else alert("Aula já cadastada");
        alert("Ação realizada com sucesso!");
      }

      function verificaAulaExiste(nome) {
        return $scope.aulas.some(a => a.nome === nome);
      }

      $scope.excluirAula = function (index) {
        $scope.aulas.splice(index, 1);
        $scope.removerInstrutor = {};
        $scope.formExcluirAula.$setPristine();
        alert("Ação realizada com sucesso!");
      }

      $scope.editarAula = function (index) {
        $scope.aulas.forEach((item) => {
         if(item.id === Number(index))
           item.nome = $scope.nomeEditado;
       });
       alert("Ação realizada com sucesso!");
      }
});

myApp.controller('instrutoresController', function ($scope) {
  //   $scope.incluirInstrutor= function(){
  //     if($scope.formInstrutor.$valid && !verificaInstutorComMesmoNome($scope.novoInstrutor.nome) && !verificaEmail($scope.novoInstrutor.email)){
  //     $scope.novoInstrutor.id = idInstrutor++;
  //     $scope.instrutores.push(angular.copy($scope.novoInstrutor));
  //     $scope.novoInstrutor = {}
  //   } else {
  //     $scope.mostrarAvisoNome = true;
  //     $scope.mostrarAvisoEmail = true;
  //   }
  //  }

  $scope.incluirInstrutor= function(){
    if($scope.formInstrutor.$valid){
      if(!verificaInstutorComMesmoNome($scope.novoInstrutor.nome)){
        if (!verificaEmail($scope.novoInstrutor.email)) {
          $scope.novoInstrutor.id = idInstrutor++;
          if (typeof $scope.novoInstrutor.urlFoto === 'undefined') $scope.novoInstrutor.urlFoto = "https:/pbs.twimg.com/media/C8SpgFqXYAActhH.jpg";
          $scope.instrutores.push(angular.copy($scope.novoInstrutor));
          $scope.novoInstrutor = {}
        } else alert("Email já está sendo utilizado");
      } else alert("Instrutor já cadastrado");
    }
    alert("Ação realizada com sucesso!");
  }

   function verificaInstutorComMesmoNome(nome) {
     return $scope.instrutores.some(a => a.nome === nome);
   }

   function verificaEmail(email) {
     return $scope.instrutores.some(a => a.email === email);
   }

   $scope.querEditar = function (instrutor) {
         $scope.clicouParaEditar = true;
         $scope.instrutorEditado = instrutor;
    }

    $scope.salvarInstrutor = function(instrutorEditado){
        let idInstrutor = instrutorEditado.id;
        $scope.instrutores.splice(idInstrutor,1,instrutorEditado);
        $scope.instrutorEditado = {};
        $scope.clicouParaEditar = false;
        alert("Ação realizada com sucesso!");
    }

    $scope.querExcluir = function (instrutor){
        let idInstrutor = $scope.instrutores.indexOf(instrutor);
      $scope.instrutores.splice(idInstrutor, 1);
      alert("Ação realizada com sucesso!");
    }
})

myApp.controller('mainController', function($scope){

    $scope.instrutores = [{
    }];

    $scope.aulas =[];

    let idAula = 0;
    let idInstrutor = 0;




})
