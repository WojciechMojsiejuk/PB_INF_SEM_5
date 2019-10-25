//Adrian Wolanowski

function Zadanie1(a, b){
  return Math.floor(Math.random()*(a, b) + a);
}

function Zadanie2(){
  let zliczanie = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  for(let i=0; i<1000000; i++){
    let wartosc = Zadanie1(1, 10);
    zliczanie[--wartosc]++;
  }
  return zliczanie;
}

function Zadanie3(rozmiar, a, b){
  let tab = [];
  for(let i = 0; i<rozmiar; i++){
        tab[i] = Zadanie1(a, b);
  }
  return tab;
}

function Zadanie4(){
  let tab = Zadanie3(10, 0, 100);
  let numbers = [0, 0];
  console.log("Zadanie 4: " + tab);
  console.log("Max: " + Math.max(...tab));
  console.log("Min: " + Math.min(...tab));
  let sum = tab.reduce((previous, current) => current += previous);
  let avg = sum/tab.length;
  console.log("Avg: " + avg);
  for(let i = 0; i<tab.length; i++){
    if(tab[i] % 2 == 0)numbers[0]++
    else numbers[1]++;
  }
  console.log("Parzyste, nieparzyste: " + numbers);
}

function Zadanie5(tab){
  //console.log("Zadanie 5: " + tab);
  let norm = []
  let max = Math.max(...tab);
  let min = Math.min(...tab);
  for(let i = 0; i<tab.length; i++){
    norm[i] = (tab[i]-min)/(max-min);
  }
  console.log("Norm: " + norm);
  return norm;
}

function Zadanie6(){
  let tab_pkt = [];

  for(let i=0; i<20; i++){
    let pkt = {};
    pkt.x = Zadanie1(0, 100);
    pkt.y = Zadanie1(0, 100);
    tab_pkt[i] = pkt;
  }
  //console.log(tab_pkt);

  let xVal = Array.from(tab_pkt, p => p.x);
  let yVal = Array.from(tab_pkt, p => p.y);
  let norm_x = Zadanie5(xVal);
  let norm_y = Zadanie5(yVal);
  let norm=[]

  for(let i=0;i<20;i++)
    {
      let point = {}
      point.x = norm_x[i]
      point.y = norm_y[i]
      norm[i]=point
    }

  console.log(norm);
  return norm;
}

function Zadanie7(tab){
  for(let i = 0; i<tab.length; i++){
    tab[i]["dist"] = Math.sqrt(Math.pow(tab[i].x,2)+Math.pow(tab[i].y,2));
  }
  console.log(tab);
}

console.log("Zadanie 1: " + Zadanie1(0,100));
console.log("Zadanie 2: " + Zadanie2());
console.log("Zadanie 3: " + Zadanie3(3, 0, 100));
Zadanie4();
console.log("Zadanie 5: ");
Zadanie5(Zadanie3(10, 0, 100));
console.log("Zadanie 6: ");
Zadanie6();
console.log("Zadanie 7: ")
Zadanie7(Zadanie6());
