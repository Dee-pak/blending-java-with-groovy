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

    BigDecimal balance = 0
    String type

    void deposit(BigDecimal amount){
        this.balance += amount
    }

    void withdraw(BigDecimal amount){
        this.balance -= amount
    }

    //Overloading the operator '+'
    BigDecimal plus(Account otherAccount){
        this.balance + otherAccount.balance 
    }
    
    String toString(){
        "account Balance : $balance"
    }

}

Account checking = new Account(type:"Checking")
checking.deposit(100.00)
Account savings = new Account(type:"Savings")
savings.deposit(50.00)

println "Checking $checking"
println "Saving $savings"

BigDecimal total = checking + savings
println "Total Balance : $total"