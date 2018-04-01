/*
    
    Lists
    Groovy provides native support for various collection types, including lists, maps or ranges. 
    Most of those are based on the Java collection types and decorated with additional methods found in the Groovy development kit.
    
    http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/List.html
    http://docs.groovy-lang.org/next/html/documentation/working-with-collections.html#Collections-Lists

*/

// ----------- We can create an empty List using '[]' operator ----------- //
def emptyList = []
def mainList = [1,2,3,4,5,3,7,3,1,5,7,8,9,6]
println mainList
println mainList.class   // By default groovy creates and Instance of ArrayList

// We can create instance of another implementation of List using the 'as <Collection>' keyword as follows
def linkedList = [] as LinkedList
println linkedList.class

// Lists can be used as a source to construct another list
def list1 = ['a', 'b', 'c']
def list2 = new ArrayList<>(list1)
println "List2 : $list2"
assert list1 == list2    // checks that each corresponding element is same

def list3 = list1.clone() // clone can also be called
assert list1 == list3

assert mainList[-2] == 9    // We can use negative indexes to count from the end
assert mainList.getAt(-3) == 8    // Negative indexes can also be used with getAt() method

// ----------- Lists can also be evaluated as boolean expressions ----------- //

assert ![]    // empty list would assert to false
assert [1] && ['a'] && [null]    // non empty list including null would assert to true

// ----------- Iterating over a list can be done with traditional for loops, each, eachWithIndex. ----------- //

[1,2,3,4,5,6,7].each {
    print "Item : $it"    // 'it' is an implicit parameter corresponding to the current element
}

[1,2,3,4,5,6,7,8].eachWithIndex { it, i ->    // 'it' is the current element, while 'i' is the current index
    print "Element : $it, Index : $i"
}

// In addition to traversing we can also create a new list by transforming each of its element into something else using collect method from Groovy.
assert [1,2,3,4,5].collect { it * 5 } == [5,10,15,20,25]

// short syntax instead of collect
assert [1,2,3]*.multiply(2) == [2,4,6]

// It is also possible to give collect method a list as an argument which would collect the elements
def collectorList = []
[1,2,3].collect(collectorList) { it + 2 }
assert [3,4,5] == collectorList

/*
   -----------  Manupulating Lists ----------- 
*/

// Filtering and Searching
assert [1,2,3].find { it > 2 } == 3   // Would return the first element which matches the criteria
assert [9,8,7,6,5,4].findAll { it > 5 } == [9,8,7,6]    // Will maintain the order
assert ['a', 'b', 'c', 'd', 'e'].findIndexOf {
    it in ['d', 'e']    // finds index of 1st element in matching criteria
} == 3

assert ['a', 'b', 'c', 'd', 'e'].indexOf('c') == 2    // index of 'c' is returned
assert ['a', 'b', 'c', 'd', 'e'].indexOf('z') == -1    // index -1 means value is not in the list
assert ['a', 'e', 'b', 'c', 'd', 'e'].lastIndexOf('e') == 5

assert [1,2,3,4].every { it < 5 }    // assert true if EVERY element matches the predicate
assert ![9,8,7,6,5].every { it < 2 }

assert [1,2,3,4,9].any { it > 8 }    // would assert true if ANY of the element meets the predicate
assert ![9,8,7,6,5,1].any{ it < 1 }    

assert [10,20,30].sum() == 60    // can call sum() method to sum the elements of the list
assert ['a', 'b', 'c', 'd', 'e'].sum() { ((char)it) - ((char)'a') } == 10
assert [1,2,3].sum(1000) == 1006    // an initial value can be provided

assert [1,2,3].join('-') == '1-2-3'    // Strings can be joined with a delimiter

assert ['a','b','c'].inject('Reduced : ') { injectedString, listItem -> 
    println "$injectedString + $listItem = ${injectedString + listItem}"
    injectedString + listItem    // reduce operation
} == 'Reduced : abc'

assert [1,2,3].inject(10) { injectedValue, listItem -> 
    println "$injectedValue + $listItem = ${injectedValue + listItem}"    // inject() method is similar to operation 'total = total + something
    injectedValue + listItem
} == 16


// Using inject with custom objects
class Person {
    String username
    String email
}
def persons = [
        new Person(username:'deepack', email:'deepak@gmail.com'),
        new Person(username :'nand', email :'nand@gmail.com')
]
/*
    Converting a list to a map where the key is the value
    username of Person and the value is the email
    of Person. We inject an empty map as the starting
    point for the result.
*/
def map = persons.inject([:]) { result, person ->
    result[person.username] = person.email
     return result
}
println map


// --------- Adding and removing elements from the list -----------    //

def list = []
assert list.empty

list << 5
assert list.size == 1

list << 3 << 'i' << 11
assert list == [5,3,'i',11]

list << ['d', 'e']
assert list == [5,3,'i',11, ['d', 'e']]

assert ([1,2] << 6 << 7 << ['i','j']) == [1,2,6,7,['i', 'j']]    // first item in the chain of << is the target list

assert ([1,2,3] << 4) == [1,2,3].leftShift(4)    // using left shift is equivalent to << operator

assert [1,2] + 3 + [4,5] + 6 == [1,2,3,4,5,6]
assert [1,2].plus(3).plus([4,5]).plus(6) == [1,2,3,4,5,6]   // Note : '+' or plus() are not mutative operations compared to '<<', i.e. it will create and return a new list everytime

def a = [1,2,3]
a += 4                // creates a new list and assigns it to list 'a'
a += [5,6]            // everytime
assert a == [1,2,3,4,5,6]

assert [1,2,*[3,4,5],6,7,*[8,*[9,10],11],12] == [1,2,3,4,5,6,7,8,9,10,11,12]    // '*' is known as spreader which flattens the list
assert [1,2,[3,4,5],6,7,[8,[9,10],11],12].flatten() == [1,2,3,4,5,6,7,8,9,10,11,12]