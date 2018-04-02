/*
    Interface Range<T extends java.lang.Comparable>
    Ranges allow you to create a list of sequential values. These can be used as List since Range extends java.util.List.
    
    A Range represents the list of all items obtained by starting from a from value and calling next() successively until you reach the to value. 
    For a reverse range, the list is obtained by starting at the to value and successively calling previous() until the from value is reached.
    http://docs.groovy-lang.org/latest/html/api/groovy/lang/Range.html
*/

// ---------- Ranges can be used with Integers ---------------- //
Range range = 1..10
println range
println range.class
println range.from
println range.to

// Ranges are object and hence we can also call methods on range objects
assert (0..10).contains(10)
assert (0..10).contains(0)
//assert (0..10).contains(11)    // false
//assert (0..<10).contains(10)    // Half range Excluding 'to' would assert false

// We can also iterate through ranges using a classic for loop
for ( i in 0..10 )
    println i
    
// Same effect can be acheived in a more Groovy idiomatic style, by iterating a range with each method:
( 0..10 ).each { i ->
    println "Num : $i"
}

// Ranges can also be used in switch statements
def age = 22
switch(age){
    case 1..20:
        println "I am still young!"
    case 21..30:
        println "I am getting old!"
}

// Ranges can also we used with Groovy Strings
Range letters = 'a'..'z'
println letters

// Ranges can also be used with Date
Date today = new Date()
Date weekFromToday = today + 7    // Thank you groovy for that simple one-liner
Range dateRange = today..weekFromToday
println dateRange    // Would print out dates from today till one week later

/* 
    Note : Ranges can also be created from enums
    Ranges can be used for any Java object which implements java.lang.Comparable 
    for comparison and also have methods next() and previous() to return the next / previous item in the range.
*/
// Example of enum:
enum Days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
def dayRange = Days.SUNDAY..Days.SATURDAY
dayRange.each { day ->
    println day
}
println dayRange.size()
println dayRange.from
println dayRange.to
