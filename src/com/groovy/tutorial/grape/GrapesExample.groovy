/*
    Grape is a JAR dependency manager embedded into Groovy. Grape lets you quickly add maven repository dependencies to your classpath, 
    making scripting even easier. The simplest use is as simple as adding an annotation to your script.
    http://groovy-lang.org/grape.html
*/

// Simple example using apache commons lang library. This will allow you to send a script to anyone without worrying about script's dependencies.
// @Grab => for single dependency, @Grapes([@Grap(abc), @Grab(xyz)]) => for multiple dependencies

@Grapes(
    @Grab(group='org.apache.commons', module='commons-lang3', version='3.7')
)
import org.apache.commons.lang3.text.WordUtils

String name = "Deepak Khobragade"
WordUtils wordUtils = new WordUtils();
println wordUtils.initials(name)