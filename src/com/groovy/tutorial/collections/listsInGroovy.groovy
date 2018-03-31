/*
    
    Lists
    Groovy provides native support for various collection types, including lists, maps or ranges. 
    Most of those are based on the Java collection types and decorated with additional methods found in the Groovy development kit.
    
    http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/List.html
    http://docs.groovy-lang.org/next/html/documentation/working-with-collections.html#Collections-Lists

*/

// We can create an empty List using '[]' operator
def mainList = [1,2,3,4,5,3,7,3,1,5,7,8,9,6]
println mainList
println mainList.class   // By default groovy creates and Instance of ArrayList

// We can create instance of another collection using the 'as <Collection>' keyword as follows
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

// Lists can also be evaluated as boolean expressions

assert ![]    // empty list would assert to false
assert [1] && ['a'] && [null]    // non empty list including null would assert to true

// Iterating over a list can be done with traditional for loops, each, eachWithIndex.

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
    Manupulating Lists
*/

// Filtering and Searching
assert [1,2,3].find { it > 2 } == 3   // Would return the first element which matches the criteria
assert [9,8,7,6,5,4].findAll { it > 5 } == [9,8,7,6]
assert ['a', 'b', 'c', 'd', 'e'].findIndexOf {
    it in ['d', 'e']    // finds index of 1st element in matching criteria
} == 3

assert ['a', 'b', 'c', 'd', 'e'].indexOf('c') == 2    // index of 'c' is returned
assert ['a', 'b', 'c', 'd', 'e'].indexOf('z') == -1    // index -1 means value is not in the list
assert ['a', 'e', 'b', 'c', 'd', 'e'].lastIndexOf('e') == 5