// Paweł Bąk

// zadanie01
function zadanie01(text) {
  let dict = new Map()
  function include(element) {
    if (dict.has(element)) {
      dict.set(element, dict.get(element) + 1)
    } else {
      dict.set(element, 1)
    }
  }
  text = text.split("")
  text.forEach(include)
  console.log([...dict])
}
zadanie01("bardzo cieszę się, że udało mi się to zrobić")

// zadanie02
function zadanie02(list) {
  function odd(element, index) {
    return (index % 2 === 0)
  }
  function normalize(element, index, array) {
    let max = Math.max(...array)
    let min = Math.min(...array)
    return Math.trunc((element - min) * 100 / (max - min)) / 100
  }
  list = list.filter(odd)
  list = list.map(normalize)
  console.log(list)
}
zadanie02([0,1,2,3,4,5,6,7,8,9,10,11,12,12])

// zadanie03
function zadanie03(size) {
  function multiplication(last, curr) {
     return last * curr;
  }
  function generate() {
    return Math.floor(Math.random() * 10 + 1)
  }
  let list = new Array(size).fill(0)
  list = list.map(generate)
  return list.reduce(multiplication)
}
console.log(zadanie03(5))

// zadanie04
class Account {
  constructor() {
    this.balance = 0
  }
  show() {
    return this.balance
  }
}

class AccountD extends Account {
  constructor() {
    super()
  }
  deposit(amount) {
    this.balance += amount
  }
}

class AccountW extends Account {
  constructor() {
    super()
  }
  withdraw(amount) {
    this.balance -= amount
  }
}

class AccountDW extends Account {
  constructor() {
    super()
  }
  deposit(amount) {
    this.balance += amount
  }
  withdraw(amount) {
    this.balance -= amount
  }
}

function zadanie04(number_deposit, number_withdraw, number_both) {
  function generate(element, index, array) {
    if (index < number_deposit) {
      return new AccountD()
    }
    if (index < (number_deposit + number_withdraw)) {
      return new AccountW()
    }
    return new AccountDW()
  }
  function operate(element) {
    if (typeof element.deposit === 'function') {
      element.deposit(50)
    }
    if (typeof element.withdraw === 'function') {
      element.withdraw(20)
    }
  }
  function log(element) {
    console.log("Stan konta: " + element.show())
  }
  let list = new Array(number_deposit + number_withdraw + number_both).fill(0)
  list = list.map(generate)
  list.forEach(operate)
  list.forEach(log)
}
zadanie04(5,5,5)
