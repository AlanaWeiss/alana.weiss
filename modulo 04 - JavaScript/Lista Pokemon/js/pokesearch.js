
document.addEventListener('DOMContentLoaded', function() {
  var numeroPokemon = document.getElementById('inputPokemon');
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
    fetch(`http://pokeapi.co/api/v2/pokemon/${numeroPokemon.value}/`)
       .then(response => response.json())
       .then(json => {
         renderizar(json)
       })
  }
  var renderizar = (json) => {
    console.log(json);
    let div = document.getElementById('detalhesPokemon');
    let img = document.createElement('img');
    let nome = document.createElement('h2');
    let titleTypes = document.createElement('h4');
    let tipos = document.createElement('ul');
    let titleStats = document.createElement('h4');
    let stats = document.createElement('ul');

    nome.innerText = `${json.name} - ${json.id}`;
    img.src = json.sprites.front_default;
    titleTypes.innerText = `Tipos:`;
    json.types.forEach(item => {
      let li = document.createElement('li');
      li.innerText = `${item.type.name}`;
      tipos.append(li);
    })
    titleStats.innerText = `Status`
    json.stats.forEach(item =>{
      let li = document.createElement('li');
      let progresso = document.createElement('progress');
      progresso.max = 100;
      progresso.value = item.base_stat;
      li.innerText = `${item.stat.name}     `;
      stats.append(li);
      stats.append(progresso);
    })
    div.append(nome);
    div.append(img);
    div.append(titleTypes);
    div.append(tipos);
    div.append(titleStats);
    div.append(stats);
  }
})//fecha a função DOMContentLoaded
