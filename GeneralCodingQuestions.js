//Q1

const start = 1
const end = 100
function fizzBuzz(start, end) {
  for (let num = start; num <= end; num++) {
    if (num % 5 === 0 && num % 3 === 0) {
      console.log('FizzBuzz')
    } else if (num % 3 === 0) {
      console.log('Fizz')
    } else if (num % 5 === 0) {
      console.log('Buzz')
    } else {
      console.log(num)
    }
  }
}

fizzBuzz(start, end)

//Q2

let num = 35
function fibonacci(num) {
  if (num < 2) return num
  return fibonacci(num - 1) + fibonacci(num - 2)
}
let result = fibonacci(num)
console.log(result)
