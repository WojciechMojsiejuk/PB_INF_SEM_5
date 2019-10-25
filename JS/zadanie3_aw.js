//Zadanie 1 a
function Dodawanie(x, y){
  return x+y;
}

function Funkcja(tab1, tab2, funkcja){
  let tab = [];
  for(let i=0; i<tab1.length; i++){
    tab[i] = funkcja(tab1[i], tab2[i]);
  }
  return tab;
}

let tab1 = [1,2,3];
console.log("Zadanie 1 a: " + Funkcja(tab1, tab1, Dodawanie));

//Zadanie 1 b
function Slownik(x, y){
  let pkt = {};
  pkt.x = x;
  pkt.y = y;
  return pkt;
}
let tab2 = [7,8,9];
let tab = Funkcja(tab1, tab2, Slownik);
console.log("Zadanie 1 b: ")
for (let x in tab){
  console.log(tab[x]);
}

//Zadanie 2
function Zakres(x, y){
  var Licznik = (function () {
      var i = 0;

      return function () {
          return i++;
      }
  })();

  Licznik(); //Licznik();
  for(let i = -1; i<y; i++){
    let liczba = Licznik();
    if(liczba>y){ console.log("NaN"); break; }
    if(liczba>=x) console.log(liczba);
  }
}

console.log("Zadanie 2: ");
Zakres(3, 5);

//console.log("Inny zakres");
//Zakres(0, 4);

//Zadanie 3
class Zbior{
  /*constructor(tab){
  this.tab = tab;
}*/
  constructor(){
    this.tab = [];
    for(let i = 0; i<arguments.length; i++){
      this.tab.push(arguments[i]);
    }
  }
  add(x){
    let bool = true;
    if(Number.isInteger(x)){
      for (let i = 0; i<this.tab.length; i++){
        if(x == this.tab[i]) bool = false ;
      }
      if(bool) this.tab[this.tab.length++] = x;
    }
  }
  delete(x){
    let bool = false;
    for(let i = 0; i<this.tab.length; i++){
      if(x == this.tab[i]) bool = true;
    }
    if(bool) this.tab.splice(this.tab.indexOf(x), 1);
  }
  search(x){
    let bool = false;
    for(let i = 0; i<this.tab.length; i++){
      if(x == this.tab[i]) bool = true;
    }
    return bool;
  }
  view(){
    return this.tab;
  }
}

console.log("Zadanie 3: ");
var zbior = new Zbior(1, 2, 3)
console.log(zbior.view());
zbior.add(4);
zbior.add(3);
console.log(zbior.view());
zbior.add(5);
zbior.add(4.3);
zbior.add("String");
zbior.delete(3);
zbior.delete(8);
console.log(zbior.view());
console.log(zbior.search(1));
