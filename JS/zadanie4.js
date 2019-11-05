//Zadanie 1
function zadanie1(tab){
  var sum = 0;
  [...tab].forEach(function(char){
    sum++;
  });
  return sum;
}

var str = "ABC";
console.log("Zadanie 1:")
console.log(zadanie1(str));

//Zadanie 2

function scale(element, min, max){
    return (element-min) / (max-min);
}

function zadanie2(tab){
  var tab2 = tab.filter(function(element, index){
    return index % 2 === 0;
  })

  var max = Math.max(...tab2);
  var min = Math.min(...tab2);

  var tab3 = tab2.map(e => scale(e, min, max));

  var tab4 = tab3.map(e => e.toFixed(2));

  return tab4;
}

var num = [1, 2, 12, 4, 7, 6];
console.log("Zadanie 2:")
console.log(zadanie2(num));

//Zadanie 3
function random(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

function zadanie3(size){
  var tab = new Array(size);
  tab.fill(0);
  var tab2 = tab.map(e => random(0, 10));
  var num = tab2.reduce(function(prev, curr){
    return prev*curr
  })
  console.log(tab2);
  return num;
}
console.log("Zadanie 3:")
console.log(zadanie3(3));

//Zadanie 4
//class Konto{}
class Konto1{
  wyplac(){
    console.log("Wyplacam 20 zl");
  }
}
class Konto2{
  wplac(){
    console.log("Wplacam 50 zl");
  }
}
class Konto3{
  wyplac(){
    console.log("Wyplacam 20 zl");
  }
  wplac(){
    console.log("Wplacam 50 zl");
  }
}
function type(e){
  if(e instanceof Konto1) e.wyplac();
  else if(e instanceof Konto2) e.wplac();
  else{
    e.wyplac();
    e.wplac();
  }
}
function zadanie4(){
  var tab = Array.prototype.slice.call(arguments);
  [...tab].forEach(e => type(e));
}
var k1 = new Konto1();
var k2 = new Konto2();
var k3 = new Konto3();
console.log("Zadanie 4:")
zadanie4(k1, k2, k3);
