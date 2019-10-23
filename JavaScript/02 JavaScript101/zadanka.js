// Paweł Bąk
// noprotect
/* jshint esnext: true */

// zadanie01
function zadanie01(x, y) {
  if (y < x) {
    [x, y] = [y, x]
  }
  return Math.floor(Math.random() * (y - x + 1) + x)
}

// zadanie02
let liczniki = new Array(10).fill(0)
for (let i = 0; i < 1000000; i++) {
  let wylosowana = zadanie01(1,10)
  liczniki[--wylosowana]++
}
console.log("Tablica z zadania drugiego")
console.log(liczniki)

// zadanie03
function zadanie03(x, y, rozmiar) {
  let tablica = new Array(rozmiar)
  for (let i = 0; i < rozmiar; i++) {
    tablica[i] = zadanie01(x, y)
  }
  return tablica
}
let tablica = zadanie03(-20, 89, 50)
console.log("Przykładowa tablica z zadania trzeciego")
console.log(tablica)

// zadanie04
let minimum = Math.min(...tablica)
console.log("Minimum: " + minimum)
let maximum = Math.max(...tablica)
console.log("Maksimum: " + maximum)
const policzSume = tablica => tablica.reduce((a,b) => a + b, 0)
let suma = policzSume(tablica)
let srednia = suma / tablica.length
console.log("Średnia: " + srednia)

let parzyste = 0
let nieparzyste = 0
for (let i = 0; i < tablica.length; i++) {
  if (tablica[i] % 2 === 0) {
    parzyste++
  } else {
    nieparzyste++
  }
}

console.log("Liczba liczb parzystych: " + parzyste)
console.log("Liczba liczb nieparzystych: " + nieparzyste)

// zadanie05
function zadanie05(tablica) {
  let minimum = Math.min(...tablica)
  let maximum = Math.max(...tablica)
  let nowaTablica = []
  for (let i in tablica)
    {
      nowaTablica[i] = (tablica[i] - minimum) / (maximum - minimum)
    }
  return nowaTablica
}
let nowaTablica = zadanie05(tablica)
console.log("Zmieniona tablica:")
console.log(nowaTablica)

// zadanie06
function zadanie06() {
  let punkty = []
  for (let i = 0; i < 20; i++) {
    let punkt = {}
    punkt.x = Math.random()
    punkt.y = Math.random()
    punkty[i] = punkt
  }
  return punkty
}
let punkty = zadanie06()
console.log("Punkty z zadania szóstego")
console.log(punkty)

// zadanie07
function zadanie07(tablica) {
  for (let punkt of tablica) {
    punkt.odleglosc = Math.sqrt(Math.pow(punkt.x, 2) + Math.pow(punkt.y, 2))
  }
  return tablica
}
let nowePunkty = zadanie07(punkty)
console.log("Punkty z odległością z zadania siódmego")
console.log(nowePunkty)