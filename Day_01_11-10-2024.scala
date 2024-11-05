// Databricks notebook source
// MAGIC %md
// MAGIC #### Hello World !

// COMMAND ----------

println("Hello world")

// COMMAND ----------

// MAGIC %md
// MAGIC #### Variables
// MAGIC * Scala has two types of variables: `mutable` and `immutable`
// MAGIC * Usage of mutable variables is highly discouraged
// MAGIC * A pure functional program would never use a mutable variable. So, they should be used
// MAGIC with caution
// MAGIC * A mutable variable is declared using the keyword `var` 
// MAGIC * An immutable variable is declared using the keyword `val`

// COMMAND ----------

var x = 10

// COMMAND ----------

x = 20

// COMMAND ----------

val y = 10

// COMMAND ----------

y = 20

// COMMAND ----------

// MAGIC %md
// MAGIC * Scala is a statically typed language, so everything has a type
// MAGIC * However, Scala compiler does not force a developer to declare the type of something if it can infer it
// MAGIC * Thus, coding in Scala requires less typing and the code looks less verbose
// MAGIC * Semicolons at the end of a statement are optional
// MAGIC * The following two statements are equivalent
// MAGIC  ```Scala
// MAGIC   val y: Int = 10;
// MAGIC   val y = 10
// MAGIC   ```

// COMMAND ----------

// MAGIC %md
// MAGIC #### Functions

// COMMAND ----------

def add(firstInput: Int, secondInput: Int): Int = {
  val sum = firstInput + secondInput
  return sum
}

// COMMAND ----------

val addNumbers = add(5,6)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput: Int) = firstInput + secondInput

// COMMAND ----------

val addTwoNumbers = addSimple(6,7)

// COMMAND ----------

// MAGIC %md
// MAGIC #### Higher-Order Functions
// MAGIC A function that takes a function as an input parameter is called a higher-order funtion

// COMMAND ----------

// MAGIC %md
// MAGIC The `encode` function takes two input parameters and returns a Long value. 
// MAGIC * The first input type is an Int. 
// MAGIC * The second input is a function f that takes an Int as input and returns a Long. 
// MAGIC * The body of the encode
// MAGIC function multiplies the first input by 10 and then calls the function that it received as an input

// COMMAND ----------

def encode(n: Int, f: (Int) => Long): Long = {
  val x = n * 10
  f(x)
}

// COMMAND ----------

// MAGIC %md
// MAGIC #### Function Literals
// MAGIC * A function literal is an `unnamed` or `anonymous function` in source code
// MAGIC * It can be used in an application just like a string literal
// MAGIC * It can be passed as an input to a higher-order method or function
// MAGIC * It can also be assigned to a variable
// MAGIC * A function literal is defined with input parameters in parenthesis, followed by a right arrow and the
// MAGIC body of the function
// MAGIC * The body of a functional literal is enclosed in optional curly braces. An example is
// MAGIC shown next
// MAGIC ```Scala
// MAGIC (x: Int) => {
// MAGIC   x + 100
// MAGIC }
// MAGIC ```
// MAGIC
// MAGIC <br>

// COMMAND ----------

val higherOrderFunctionTest1 = encode (5, (x: Int) => {x+100}) 

// COMMAND ----------

// MAGIC %md
// MAGIC If the function body consists of a single statement, the curly braces can be omitted. 
// MAGIC
// MAGIC A concise version of the same function literal is shown next.
// MAGIC ```Scala
// MAGIC (x: Int) => x + 100
// MAGIC ```
// MAGIC

// COMMAND ----------

val higherOrderFunctionTest2 = encode (5, (x: Int) => x + 100 ) 

// COMMAND ----------

// MAGIC %md
// MAGIC The higher-order function encode defined earlier can be used with a function literal, as shown below
// MAGIC
// MAGIC ```Scala
// MAGIC val code = encode(10, (x: Int) => x + 100)
// MAGIC ```

// COMMAND ----------

val higherOrderFunctionTest3 = encode (5, x => x + 100 ) 

// COMMAND ----------

// MAGIC %md
// MAGIC A function literal can be just `_`

// COMMAND ----------

val higherOrderFunctionTest4 = encode (5, _ + 100 ) 

// COMMAND ----------

// MAGIC %md
// MAGIC #### Classes
// MAGIC * A class is an object-oriented programming concept
// MAGIC * It provides a higher-level programming abstraction 
// MAGIC * At a very basic level, it is a code organization technique that allows you to bundle data and all of its operations
// MAGIC together. Conceptually, it represents an entity with properties and behavior
// MAGIC
// MAGIC * A class in Scala is similar to that in other object-oriented languages
// MAGIC * It consists of fields and methods
// MAGIC * A field is a variable, which is used to store data
// MAGIC * A method contains executable code. A method has access to all the fields of a class
// MAGIC * A class is a template or blueprint for creating objects at runtime. An object is an instance of a class. A
// MAGIC class is defined in source code, whereas an object exists at runtime. A

// COMMAND ----------

class Car(mk: String, ml: String, cr: String) {
  val make = mk
  val model = ml
  var color = cr
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Black")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Singletons
// MAGIC * One of the common design patterns in object-oriented programming is to define a class that `can be
// MAGIC instantiated only once`
// MAGIC * A class that can be instantiated only once is called a singleton
// MAGIC * Scala provides the keyword `object` for defining a singleton class
// MAGIC
// MAGIC ```Scala
// MAGIC object DatabaseConnection {
// MAGIC   def open(name: String): Int = {
// MAGIC   ...
// MAGIC   }
// MAGIC   def read (streamId: Int): Array[Byte] = {
// MAGIC   ...
// MAGIC   }
// MAGIC   def close (): Unit = {
// MAGIC   ...
// MAGIC   }
// MAGIC }
// MAGIC ```

// COMMAND ----------

// MAGIC %md
// MAGIC #### Case Classes
// MAGIC * A case class is a class with a `case` modifier
// MAGIC *  All input parameters specified in the definition of a case class implicitly get a `val prefix`. In
// MAGIC other words, Scala treats the case class Message as if it was defined

// COMMAND ----------

case class Message(from: String, to: String, content: String)
// This is actually equivalent to
// class Message(val from: String, val to: String, val content: String)

// COMMAND ----------

val request = Message("harry", "sam", "discussion")

// COMMAND ----------

// MAGIC %md
// MAGIC #### Pattern Matching
// MAGIC * Pattern matching is a Scala concept that looks similar to a switch statement in other languages
// MAGIC * However, it is a more powerful tool than a switch statement
// MAGIC * The code on the right-hand side of each right arrow is an expression returning a value
// MAGIC * Therefore, a pattern-matching statement itself is an expression returning a value

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "Red" => 1
    case "Blue" => 2
    case "Green" => 3
    case "Yellow" => 4
    case _ => 0
  }
  num
}

// COMMAND ----------

val colorName = "Red"
val colorCode = colorToNumber(colorName)
println(s"The color code for $colorName is $colorCode")


// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x / y.toDouble
  }
}

// COMMAND ----------

val sum = f(10,20, "+")
val product = f(10, 20, "*")
