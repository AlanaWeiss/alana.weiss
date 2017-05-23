let app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/aula', {
      controller: 'aulaController',
      templateUrl: 'html/aula.html'
    })
    .when('/instrutor', {
      controller: 'instrutorController',
      templateUrl: 'html/instrutor.html'
    })
    .otherwise({redirectTo: '/index.html'});
});




app.factory('aulaService', function ($http) {

    let urlBase = 'http://localhost:3000';
    let aulas;

    getTodasAsAulas().then(response => aulas = response.data);

    function getTodasAsAulas() {
      return $http.get(urlBase + '/aula');
    };

    function getAulaPorId(id) {
      return $http.get(urlBase + '/aula' + '/' + id);
    };

    function atualizar(aula) {

        if(!verificaAulaExiste(aula)){

          aulas.forEach((item) => {
            if(item.id === Number(aula.id))
                $http.put(urlBase + '/aula' + '/' + aula.id, aula);
          });
          alert('Aula alterada com sucesso.');
        } else {
          alert('Aula já cadastrada.');
        }
  };

  function verificaAulaExiste(aula) {
    return aulas.some(a => a.nome === aula.nome);
  }

  function criar(aula) {

      if(!verificaAulaExiste(aula)){
       return $http.post(urlBase + '/aula', aula);
        alert('Aula inserida com sucesso.');
      } else {
        alert('Aula já cadastrada.');
      }
  };

  function deletar(aula) {
    return $http.delete(urlBase + '/aula/' + aula.id, aula);
    alert("Ação realizada com sucesso!");
  }

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar,
    delete: deletar
  };
});

app.controller('aulaController', function ($scope, $routeParams, aulaService) {

    listar();
    $scope.clicouParaEditarAula = false;

    $scope.incluir = function () {
     let promisse = aulaService.create($scope.novaAula);
     promisse.then(function (response) {
        $scope.novaAula = {}
        alert('Aula inserida com sucesso.');
        listar();
     })
   }

   $scope.excluirAula = function (aula) {
     let promisse = aulaService.delete(aula);

     promisse.then(function (response) {
        alert('Aula excluida com sucesso.');
        listar();
     })
   }

   $scope.clicouParaEditarAula = function (aula) {
     $scope.aulaEditada = aula;
     $scope.querEditar = true;
   }

   $scope.editarAula = function () {
     aulaService.update($scope.aulaEditada.nome);
    $scope.querEditar = false;
   }

   function listar() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
  }

});

app.controller('instrutorController', function ($scope) {

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
              $scope.novoInstrutor.id = s$cope.idInstrutor++;
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



});