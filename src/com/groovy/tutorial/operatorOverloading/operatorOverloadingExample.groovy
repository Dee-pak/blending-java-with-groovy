/*
    Operator Overloading:
    Groovy allows us to overload the various operators so that they can be used with our own classes.
    Ex: By overloading plus() method in any class, the class can then be used with '+' operator.
    All (non-comparator) Groovy operators have a corresponding method which we can implement in
    our own classes.
    The only requirements are that the method should be public, method should have correct number of
    arguments. The argument type depends on what types we want to support on right hand side of operator.
    
    Simple account example for operator overloading:
*/

class Account {

    BigDecimal balance
    
    Account plus(Account otherAccount){
        new Account(balance: this.balance + otherAccount.balance )
    }
    
    String toString(){
        "Account Balance : $balance"
    }

}

def checking = new Account( balance:8273.0 )
def savings = new Account( balance:7679.87 )

println "Checking : $checking"
println "Savings : $savings"
println "Total : " + (checking + savings)