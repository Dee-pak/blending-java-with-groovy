/*
    Closures in Groovy
    A Closure in groovy is an open, anonymous block of code that can take arguments, return a value and can be assigned to a variable.

    Syntax : 
    { [ closureParameters -> ] statements }
    
    Reference Links:
    http://docs.groovy-lang.org/next/html/documentation/#_closures
*/

// A Closure in groovy is an instance of groovy.lang.Closure class
def c = { }
assert c instanceof Closure

// closure can take any number of typed or untyped arguments just like any method
def sayHello = { name ->
    println "Hello, $name"
}
// we call call closures just like any method
sayHello("Deepak")

// Note : The difference between a regular method and a closure is that a method cannot be passed around,
// whereas closure are objects and can be passed around in our program.

// Closures as objects (passing as an argument as last param)

def multiplyByTen( number, closure ) {    // defining a method which takes a number and a closure as an arguments
    closure( number * 10 )                // calling the closure from within the method
}

assert multiplyByTen( 10, {it} ) == 100   // invoking the method and passing in a number and a closure
 assert multiplyByTen( 5 ) {                 // Any method that accepts the closure at last argument has a special way to use closures
    it                       // We can skip the round braces while invoking that method and write the closure outside of it.
} == 50                                  // Hence, this method took 2 arguments, similar to the previous call.

// Example 2
def list = [1,2,3,4,5,6]
list.each { num ->
    print num                // Since 'each()' method takes a closure as the only argument and hence it can be invoked without braces
}

// Example 3
Random rand = new Random()
3.times {                      // The times method over here takes the closure an argument
    println rand.nextInt()
}

// ------------------------------------------- Closures accepting parameters --------------------------------------------------------- //

// Implicit parameter 'it'
def foo = {
    it    // This closure will implicity take one argument even if not defined
}
assert foo("Deepak") == "Deepak"

// Closure with no parameters
def noParamsClosure = { ->
    "I am a no params Closure!"       // We need to explicity give the lambda expression to specify a no params closure
}
assert noParamsClosure() == "I am a no params Closure!"

// Closures accepting multiple parameters
def multipleParamsClosure = { first, last -> 
    "Hello, $first $last"
}
assert multipleParamsClosure("Deepak", "Khobragade") == "Hello, Deepak Khobragade"

// Assigning a default value to a param in closure
def defaultValueClosure = { greeting="Wassup", name ->
    "$greeting, $name?"
}
assert defaultValueClosure("Deepak") == "Wassup, Deepak?"
assert defaultValueClosure("Howdy", "Deepak") == "Howdy, Deepak?"    // Passed value will override the given default value

// Closures with variable number of arguments
def closureWithVarargs = {String... args ->
    args.join('')
}
assert closureWithVarargs('a','b','c','d','e') == 'abcde'

//--------------------------------------------- Method accepting a Closure as an argument --------------------------------------------------------- //

def someMethod(Closure c){
    println c.maximumNumberOfParameters
    println c.parameterTypes
}

def someClosure = { x, y -> x + y }
someMethod( someClosure )

// ------------------------------------------- Closures in collection methods --------------------------------------------------------- //
// .each() and .eachWithIndex() methods accepting closures
def nums = [2,6,8,13,16,18,19]

for ( i in nums )
    print "$i "            // Basic way of printing elements of a list without closures
println ""
    
nums.each { i ->
    print "$i "            // printing elements using .each method which takes closure as an argument
}

for( int i = 0 ; i < nums.size() ; i++){
    System.out.println(i + "->" + nums[i])    // The traditional java way to print index and element at that index
}

nums.eachWithIndex { num, index ->
    println "$index -> $num"                // Groovy way using .eachWithIndex() method which takes in a closure
}
