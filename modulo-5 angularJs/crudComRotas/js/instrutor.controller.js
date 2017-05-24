app.controller('instrutorController', function ($scope, $routeParams, instrutorService, aulaService) {
    
    listar();
      
      $scope.incluirInstrutor= function(){
            
        if($scope.formInstrutor.$invalid){
            toastr.error('Houston, We Have a Problem');
            return;   
        } 

        let promisse = instrutorService.create($scope.novoInstrutor);

        promisse.then(function (response) {
            $scope.novoInstrutor = {}
            toastr.success('Instrutor inserido com sucesso.');
            listar();
        })
      }

       $scope.clicouParaEditarInstrutor = function (instrutor) {
             $scope.clicouParaEditar = true;
             $scope.instrutorEditado = instrutor;
        }

        $scope.editarInstrutor = function(){
            instrutorService.update($scope.instrutorEditado.nome);
             $scope.clicouParaEditar = false;
            toastr.success("Ação realizada com sucesso!");
        }

        $scope.querExcluir = function (instrutor){
           let promisse = instrutorService.delete(instrutor);

            promisse.then(function (response) {
            toastr.success('Instrutor excluido com sucesso.');
            listar();
           })
        }

        function listar() {
            aulaService.list().then((response) => $scope.aulas = response.data);
                instrutorService.list().then((response) => $scope.instrutores = response.data);
        
        }

});