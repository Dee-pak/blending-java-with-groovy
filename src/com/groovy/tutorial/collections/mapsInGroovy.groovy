/*
    Maps in Groovy
    Maps associate keys to values, separating keys and values with colon, and each key,value pair with commas
    and the whole keys and values surrounded by a square bracket.
    By default, groovy creates an instance of java.util.LinkedHashMap
*/

// ------------- Initializing a map in groovy ------------- //
def map = [:]
assert map.class == null    // map.class will return null on a map that doesn’t contain the 'class' string as key in the map. Should we really want to know the class, then we must use getClass()
assert map.getClass().getName() == "java.util.LinkedHashMap"

def person = [firstName : "Deepak", lastName : "Khobragade", cell : 6178935747]
assert person == [firstName:"Deepak", lastName:"Khobragade", cell:6178935747]
assert person.firstName == "Deepak"    // We can get value of any key from the map by directly calling the key on the map

// Adding a new key-value pair to map
person.hobby = "Swimming"
assert person == [firstName:"Deepak", lastName:"Khobragade", cell:6178935747, hobby:"Swimming"]

// By default keys in map are Strings, if we need to use variables as keys we need to surround the variable with '()'
def keyToAdd = "emailAddress"
def map2 = [keyToAdd : "deepak@gmail.com"]
assert map2 == [keyToAdd: "deepak@gmail.com"]

map2 = [(keyToAdd) : "deepak@gmail.com"]
assert map2 == ["emailAddress": "deepak@gmail.com"]

// ------------- Iterating over a map in groovy ------------- //

def map3 = [
    Deepak : 25,
    NG     : 26,
    Mayank : 36,
    Saksham: 27,
    Aniket : 30
]

map3.each { entry ->
    println "Name : $entry.key, Age : $entry.value"    // 'entry' is an entry in the map
}

map3.eachWithIndex { entry, i ->
    println "$i - Name : $entry.key, Age : $entry.value"    // 'entry' is the map entry and 'i' is the index in the mao
}

map3.each { key, value ->
    println "Name : $key, Age : $value"
}

// ------------- Adding or removing entries in a map in groovy ------------- //

// Adding elements in the map can be done either by using put() method, the subscript operator or the putAll() method.
def defaults = [1: 'a', 2: 'b', 3: 'c', 4: 'd']
def overrides = [2: 'z', 5: 'x', 13: 'x']

def results = new LinkedHashMap(defaults)
results.put(15, 't')    // using put method
results[17] = 'u'       // directly assigning the value to the key
assert results == [1:'a', 2:'b', 3:'c', 4:'d', 15:'t', 17:'u']
results.putAll(overrides)    // using putAll method
assert results == [1:'a', 2:'z', 3:'c', 4:'d', 15:'t', 17:'u', 5:'x', 13:'x']
results.remove(17)        // removing element using the remove method and passing the key to it.
assert results == [1:'a', 2:'z', 3:'c', 4:'d', 15:'t', 5:'x', 13:'x']

/*
    Note: Maps created using the map literal syntax are using the object's equals and hashcode methods.
    Hence, we should not use an object whose hashcode is subjected to change over time, 
    else the value associated with it could be nondeterministic.
*/

// Moreover, we should not use GString as the key in the map, because the hashcode of the GString and its equivalent string is not equal.
def key = 'some key'
def mp = [:]
def gstringKey = "${key.toUpperCase()}"
mp.put(gstringKey,'value')
assert mp.get('SOME KEY') == null


// ------------- Inspecting keys, values and entries in a view in a map in groovy ------------- //

def map4 = [1:'a', 2:'b', 3:'c',4:'d']
def entries = map4.entrySet()
entries.each { entry ->
    assert entry.key in [1,2,3,4]
    assert entry.value in ['a', 'b', 'c','d']
}

// ------------- Filtering and searching in a map in groovy ------------- //

def people = [
    1 : [name:'Deepak', age : 26, gender : 'M'],
    2 : [name:'Apurva', age : 24, gender : 'F'],
    3 : [name:'NG', age : 29, gender : 'M'],
    4 : [name:'Pallavi', age : 21, gender : 'F']
]

def Ng = people.find { it.value.name == 'NG'}    // would return the entry whose name is NG
def girls = people.findAll { it.value.gender == 'F'}    // would return all the entries whose gender is 'F'

def ageOfFemales = people.findAll {
    it.value.gender == 'F'
}.collect {                        // 'collect' method collects all the values returned from the previous predicate and the values that matches the following predicate into a List
    it.value.age
}
assert ageOfFemales == [24,21]

def ageOfMales = people.findAll {
    it.value.gender == 'M'
}.collect { id, p ->
    p.age
}
assert ageOfMales == [26, 29]

// ------------- Grouping in a map in groovy ------------- //
// We can group a list into a map using some criteria
// Example 1: Grouping list by element's class
def l = ['a', 3, 'b', [7,8,6], 1]
def m = l.groupBy {
    it.class
}
assert m == [
          (java.lang.String) : ['a', 'b'], 
          (java.lang.Integer) : [3, 1], 
          (java.util.ArrayList) : [[7, 8, 6]]
      ]
      
// Example 2: Grouping players by their clubs
def playerLocations = [
    [player : "Messi", club : "Barcelona"],
    [player : "Salah", club : "Liverpool"],
    [player : "Ronaldo", club : "Madrid"],
    [player : "Suarez", club : "Barcelona"],
    [player : "Ansenio", club : "Madrid"],
    [player : "Firmino", club : "Liverpool"]
]
def playerToLocationMap = playerLocations.groupBy { it.club }
assert playerToLocationMap == [
    Barcelona:[[player:'Messi', club:'Barcelona'], [player:'Suarez', club:'Barcelona']], 
    Liverpool:[[player:'Salah', club:'Liverpool'], [player:'Firmino', club:'Liverpool']],
    Madrid:[[player:'Ronaldo', club:'Madrid'], [player:'Ansenio', club:'Madrid']]
    ]
