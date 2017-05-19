var modulo = angular.module('exercicio', []);

modulo.filter('mascada', function(){
  return function(nome){
    return nome.replace(/(nunes)/gi,' $ $1 $ ');
  };
});

modulo.filter('filtroAula', function($filter){
  return function(aulas) {
    return `${ aulas.numero.toString().padStart(3, 0) } - ${ $filter('uppercase')(aulas.aula) }`;
  };
});

modulo.controller('Tema', function($scope){
  var instrutores =
	[{
	    nome: 'Pedro (PHP)',
	    aula: [{
	      numero: 3,
	      nome: 'HTML e CSS'
	    }]
	  },
	  {
	    nome: 'Zanatta',
	    aula: [{
	      numero: 5,
	      nome: 'AngularJS'
	    }]
	  },
	  {
	    nome: 'Bernardo',
	    aula: [{
	        numero: 1,
	        nome: 'OO'
	      },
	      {
	        numero: 4,
	        nome: 'Javascript'
	      }
	    ]
	  },
	  {
	    nome: 'Nunes',
	    aula: [{
	      numero: 2,
	      nome: 'Banco de Dados I'
	    }]
	  }
	];
  let aulas = [];

  	instrutores.forEach(item => {
  		item.aula.forEach(e => aulas.push({numero: e.numero, aula: e.nome, instrutor: item.nome }));
  	});

  	$scope.aulasEInstrutor = aulas;
});
