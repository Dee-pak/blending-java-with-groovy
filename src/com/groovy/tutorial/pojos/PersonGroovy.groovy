package com.groovy.tutorial.pojos

/**
 * Simple POJO in Groovy
 */

@groovy.transform.ToString
class PersonGroovy {

    // No need of access modifiers, properties are private by default in groovy
    String firstName
    String lastName
    long phone
    int age
    String email

    //no need of any constructor, groovy takes in named arguments while invoking
    // constructors and matches it with properties by name.

    //No need of any getters and setters, groovy removes the boiler-plate code and provides them implicitly.

    //No need of toString() method, groovy handles it with ASTs

    void sendMail(String message) {
<<<<<<< HEAD
        println "Message sent by $firstName $lastName $message."
=======
        println "Message sent by $firstName $lastName."
>>>>>>> e9a82d1dfa3a3ca224b907b914222777b58976ca
    }
}
