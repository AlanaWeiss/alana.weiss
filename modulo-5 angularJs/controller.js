var modulo = angular.module('exercicio', []);

modulo.controller('MainController', function($scope){

    $scope.pokemon = {nome:'Pikachu', tipo: 'Default'};
});

modulo.controller('ex02', function($scope) {
	$scope.pokemons = [
        {
            nome: 'poke1',
             tipo: 'tipo1'
        },
        {
            nome: 'poke2',
            tipo: 'tipo2'
        },
        {
            nome: 'poke3',
            tipo: 'tipo3'},
        {
            nome: 'poke4',
            tipo: 'tipo4'
        }];
});
