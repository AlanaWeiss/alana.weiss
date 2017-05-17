document.addEventListener('DOMContentLoaded', function() {
  let cor = document.getElementById('inputCor');
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
      // console.log(cor.value);
      // console.log( hexToRgb(cor.value)); // "51";
      document.getElementsByTagName("body")[0].style.background = cor.value;
  Object.values(hexToRgb(cor.value)).forEach(itemCor => {
      fetch(`http://pokeapi.co/api/v2/pokemon/${itemCor}/`)
         .then(response => response.json())
         .then(json => {
           renderizar(json)
         })
    })
  }
  function hexToRgb(hex) {
      var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
      return result ? {
          r: parseInt(result[1], 16),
          g: parseInt(result[2], 16),
          b: parseInt(result[3], 16)
      } : null;
  }

  function renderizar(json) {
    console.log(json);
    let div = document.getElementById('detalhesPokemon');
    let img = document.createElement('img');
    img.src = json.sprites.front_default;
    div.append(img);
  }
})
