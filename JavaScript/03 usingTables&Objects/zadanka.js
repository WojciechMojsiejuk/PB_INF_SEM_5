// Paweł Bąk

// zadanie01
function zadanie01() {
  let len = arguments.length-1
  let tables = Array.prototype.slice.call(arguments, 0, len)
  let result = []
    for (let i in arguments[0]) {
      let temporary = []
      for (let j in tables) {
        temporary[j] = tables[j][i]
      }
      result[i] = arguments[len](...temporary)
    }
  return result
}

function helper_sum() {
  let sum = 0
  for (let i in arguments) {
    sum += arguments[i]
  }
  return sum
}

function helper_points(x, y) {
  let point = {}
  point.x = x
  point.y = y
  return point
}
console.log(zadanie01([1,2,3], [7,8,9], helper_points))
console.log(zadanie01([1,2,3], [5,6,7], [10,20,30], helper_sum))

// zadanie02
function zadanie02(x, y) {
  let difference, current, stop
  if (x < y) {
    difference = 1
    current = Math.ceil(x)
    stop = Math.floor(y)
  } else {
    difference = -1
    current = Math.floor(x)
    stop = Math.ceil(y)
  }
    if(Math.abs(x-y) < 1){
    current = NaN
  }
  function result() {
    console.log(current)
    if (current == stop){
      current = NaN
    } else {
      current += difference
    }
  }
  return result
}

trial = zadanie02(-7.5, - 65)
trial()
trial()



function zadanie03() {
  this.set = []
  this.include = function(x) {
    return this.set.includes(x)
  }
  this.addNuber = function(x) {
    if (Number.isInteger(x)) {
      if (!this.include(x)){
        this.set.push(x)
      }
    }
  }
  for (let x of arguments) {
    this.addNuber(x)
  }
  this.deleteNumber = function(x) {
    if (this.include(x)){
      for(let i in this.set){ 
        if (this.set[i] === x) {
          this.set.splice(i, 1); 
        }
      } 
    }
  }
  this.show = function() {
    console.log(this.set)
  }
}

let myset = new zadanie03(1,2,3,4,15,4,6.34,8)
myset.addNuber(6)
myset.show()
myset.deleteNumber(3)
myset.show()