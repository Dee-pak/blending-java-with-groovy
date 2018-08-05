/*

	Traits can be seen as Interfaces carrying both default implementation and state as well.
	Traits in Groovy are similar to Interfaces in Java 8 except that a trait can also carry the state.

*/

trait FlyingAbility {
	String fly(){
		"I'm flying..."
	}
}