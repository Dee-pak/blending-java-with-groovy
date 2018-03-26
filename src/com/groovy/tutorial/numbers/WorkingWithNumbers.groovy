// Groovy Number Defaults
def number = 10
println number.class    //Integer

def decimal = 5.50
println decimal.class    //BigDecimal

//----------------------------------------------------------------------------------------
// Converting Data types
// Explict : Casting    
def myFloat = (float) 1.0
println myFloat.class


// Implicit : Coercion

//----------------------------------------------------------------------------------------
// Rules for +, - , *
// If either operand is a float or double then the result is double
// In Java, if only floats are involved the result is a float

Float f = 5.67
Double d = 10.70
def result = d / f
println result
println result.class

// If both operands are float, the result is still double 
Float a = 15.67
Float b = 20.70
def result1 = a / b
println result1
println result1.class

// If either operand is a BigDecimal, the result is BigDecimal 
def x = 115.67
def y = 20
def result2 = x / y
println result2
println result2.class

/*
    Similarly,
    BigInteger + x = BigInteger
    Long + x = Long
    Integer + x = Integer

*/

// Integer Division
def intDiv = 1 / 2
println intDiv //This would give us 0 in Java
println intDiv.class //Groovy converts this to BigDecimal


/* 
    Few GDK methods
*/

assert 2 == 2.9.toInteger()    // conversion
assert 2 == 2.8 as Integer    // Forced coercion
assert 2 == (int) 2.5    // casting

// times example :
100.times {
    print '-'
}

// upto example :
1.upto(20) { num ->
    print num + ' '
}

// downto example :
20.downto(-5) { num ->
    print num + ' '
}

//step
0.step(10, 2) { num ->
    print num + ' '
}