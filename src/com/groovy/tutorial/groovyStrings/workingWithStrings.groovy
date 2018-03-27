/*

   This script shows the basic differences Java Strings and Groovy Strings.
   String Interpolation in Groovy
   
*/


//   -----Strings in Java-----
char c = 'c';
println c.class    // class java.lang.Character

String str = "Hello, World!"
println str.class    // String


//   -----Strings in Groovy-----
// Even a character in Groovy is considered as a String
def str1 = 'this is a string'
println str1.class    // Obviously class java.lang.String
def ch = 'c'
println ch.class    // Even this is a class java.lang.String


/* 
    java.lang.String Vs groovy.lang.String
    Groovy Strings allows us to place a placeholder to be interpreted at runtime.
    Ex of String Interpolation
*/
String name = "Deepak"
println "Hello, ${name}!"    // Remember the double quotes
println 'Hello, ${name}!'    // Considered as literal string
println "We can also evaluate expression like this : ${ 10 * 12 }"    // Evaluating expressions

//   -----Dollar Slashy-----
def dir = "C:\usr\bin\tomcat\logs"    // Unexpected Character
println dir

def dir1 = $/C:\usr\bin\tomcat\logs/$
println dir1




