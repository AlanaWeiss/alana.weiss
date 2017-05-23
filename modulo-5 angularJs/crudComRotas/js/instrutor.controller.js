app.controller('instrutorController', function ($scope, $routeParams, instrutorService, aulaService) {

    listar();
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

function listar() {
    aulaService.list().then((response) => $scope.aulas = response.data);
		instrutorService.list().then((response) => $scope.instrutores = response.data);
  
  }

});