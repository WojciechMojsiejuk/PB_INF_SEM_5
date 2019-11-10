let par = document.getElementsByTagName('p')
let body = document.getElementsByTagName('body')[0]
let colors = ['red', 'blue', 'green', 'orange', 'yellow']

let textField = document.createElement('input')
textField.type = 'text'
body.insertBefore(textField, par[0])
let submitButton = document.createElement('input')
submitButton.type = 'button'
submitButton.value = 'submit'
submitButton.onclick = function()
{
  let newP = document.createElement('p')
  newP.innerHTML = document.getElementsByTagName('input')[0].value
  colorsAndTitle(newP)
  body.appendChild(newP)
  let par = document.getElementsByTagName('p')
  let parNumber = par.length
  let title = document.createElement('h2')
  title.appendChild(document.createTextNode('Paragraf ' + parNumber.toString()))
  body.insertBefore(title, par[parNumber - 1])
  showHide(newP)
  addOnClickBorder()
}
body.insertBefore(submitButton, par[0])

for (let i = 0; i < par.length; i++)
{
  colorsAndTitle(par[i])
  let title = document.createElement('h2')
  title.appendChild(document.createTextNode('Paragraf ' + (i + 1).toString()))
  body.insertBefore(title, par[i])
  showHide(par[i])
}
addOnClickBorder()




function colorsAndTitle(p)
{
  p.style.color = colors[Math.floor(Math.random() * colors.length)]
  p.onmouseover = function()
  {
    p.title = p.innerHTML.length
  }
}

function addOnClickBorder()
{
  let par = document.getElementsByTagName('p')
  for (let i = 0; i < par.length; i++)
  {
    par[i].onclick = function()
    {
      resetBorders(par)
      par[i].style.border = 'thick solid green'
      if (i < par.length - 1)
      {
        par[i + 1].style.border = 'thick solid blue'
      }
      if (i > 0)
      {
        par[i - 1].style.border = 'thick solid orange'
      }
      if (i % 2)
      {
        par[i].style.backgroundColor = 'lightgray'
      } else {
        par[i].style.backgroundColor = 'darkgray'
      }
    }
  }
}

function resetBorders(par)
{
  for (let p of par)
  {
    p.style.border = 'none'
    p.style.backgroundColor = 'white'
  }
}

function showHide(p)
{
  let header = p.previousElementSibling
  header.onclick = function()
  {
    if (p.style.display == '')
      p.style.display = 'none'
    else
      p.style.display = ''
  }
}
