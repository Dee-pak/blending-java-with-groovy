/*
    Currying in Groovy Closures.
    Curring is a technique to create a clone of a closure and fixing values for some of the parameters.
    We can fix one or more parameters, depending on the number of parameters we pass to the curry() method.
    The parameters are bound from left to right.
    
    Note: In Groovy, currying refers to the concept of partial application. It does not corresponds to the real
    concepts of currying in functional programming because of the different scoping rules that Groovy applies 
    on Closures. Currying in Groovy will let us set the value of one of the parameter of the Closure, and it
    will return a new closure accepting one less argument.
    
    Links:
    http://groovy-lang.org/closures.html#_currying
    http://mrhaki.blogspot.com/2009/09/groovy-goodness-add-some-curry-for.html
*/

// Example 1 :
// Note : This simple currying is also known as left currying
def addNumbers = { x,y -> x + y }
def addOne = addNumbers.curry(1)
assert 10 == addOne(9)

// Example 2 :
// Closure to add filter on a List
def filterList = { filter, list -> list.findAll(filter) }
def evenNumberFilter = { it % 2 == 0 }    // filter to find even numbers
def oddNumberFilter = { !evenNumberFilter(it) }    // filter to find odd numbers
def evenFilterList = filterList.curry(evenNumberFilter)
def oddFilterList = filterList.curry(oddNumberFilter)
assert [ 0,2,4,6,8,10,12 ] == evenFilterList(0..12)
assert [ 1,3,5,7,9,11,13 ] == oddFilterList(1..13)


// Right currying : Right currying is the way of setting the right-most parameter of a closure
def nCopies = { n, str -> 
    str * n 
}
def strToPrint = nCopies.rcurry('Print me twice bro ')
assert strToPrint(2) == 'Print me twice bro Print me twice bro '

// Indexed based currying : In case a closure accepts more than 2 parameters, it is possible to set an arbitrary parameter using "ncurry"
def volume = { l,b,h -> l * b * h }
def fixedBreadthVolume = volume.ncurry(1, 5)    // Fixing breadth to be 5 for every call
assert volume(10,5,12) == fixedBreadthVolume(10,12)

// ----------------------------------------- Memoization ----------------------------------------------------- //
// Memoization allows the result of the call to a closure to be cached.
// Classsic fibonacci example
def fib
fib = { long n ->
    n < 2 ? n : fib( n - 1 ) + fib( n - 2 )
}
println fib(5)

// Same example using memoization
def fibMemo
fibMemo = { n ->
    n < 2 ? n : fibMemo( n - 1 ) + fibMemo( n - 2)
}.memoize()
println fibMemo(35)

/*
    Note : The behaviour of the cached can be tweaked using alternate methods:
    - memoizeAtMost
    - memoizeAtLeast
    - memoizeBetween
    Also, the cached used in all memoize opetarations is LRU cache.
*/

// ----------------------------------------- Composition ----------------------------------------------------- //
// Closure composition corresponds to the concept of function composition, i.e creating a new function by
// composing two or more functions (chaining calls)
def plus2 = { it + 2 }
def times3 = { it * 3 }
def times3plus2 = plus2 << times3
assert times3plus2(5) == plus2(times3(5))

def plus2times3 = times3 << plus2
assert plus2times3(5) == times3(plus2(5))