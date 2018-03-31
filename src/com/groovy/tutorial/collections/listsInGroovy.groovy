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
println mainList    // By default groovy creates and Instance of ArrayList

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


// add | remove | get | clear operations

mainList.push(28)    // appends 28 at the end of the list
mainList.putAt(0, 29)    //inserts 29 at index 0
mainList[1] = 93
println mainList