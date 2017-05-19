var myApp = angular.module('myApp', []);

myApp.controller('mainController', function($scope){
    $scope.instrutores = [
    {
        nome: 'Bernardo',
        sobrenome: 'Rezende',
        idade: 30,
        email: 'bernardo@cwi.com.br',
        jaDeuAula: true,
        aula: 'OO'
    }
    ];

    $scope.aulas = [
        'OO',
        'HTML e CSS',
        'Javascript',
        'AngularJS',
        'Banco de Dados I'
        ];

    $scope.incluir = function () {
        $scope.instrutores.push(angular.copy($scope.novoInstrutor));
        $scope.novoInstrutor = {}
    }
})