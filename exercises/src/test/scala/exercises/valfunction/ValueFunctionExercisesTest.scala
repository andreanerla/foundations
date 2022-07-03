package exercises.valfunction

import exercises.valfunction.ValueFunctionExercises._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class ValueFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  /////////////////////////////////////////////////////
  // Exercise 1: String API with higher-order functions
  /////////////////////////////////////////////////////

  // replace `ignore` by `test` to enable the test
  test("selectDigits examples") {
    assert(selectDigits("hello4world-80") == "480")
    assert(selectDigits("welcome") == "")
  }

  // replace `ignore` by `test` to enable the test
  test("selectDigits length is smaller") {
    forAll { (text: String) =>
      assert(selectDigits(text).length <= text.length)
    }
  }

  // checks if all chars returns null
  test("selectDigits is null") {
    assert(selectDigits("text").length == 0)
    }
  

  // checks that every output char is digit
  test("Every output elem is digit ") {
    selectDigits("text").foreach(c => assert(c.isDigit))
    }
  


  //secret returns same length
  test("secret returns same length") {
    secret("text").length == ("text").length
    }
  

  //every char after secret is asterisk
  test("every char after secret is asterisk") {
    secret("text").foreach(c => assert(c == '*'))
    }
  

  test("secret is idempotent") {
    secret("text").foreach(c => assert(c == '*'))
  val secret_once = secret("text")  
  val secret_twice = secret(secret("text"))
  assert(secret_once == secret_twice)
  }

  test("isValidUsernameCharacter returns alse if '^' ") {
    assert(isValidUsernameCharacter('^') == false)  
  }
  
  test("isValidUsername returns true if john-doe ") {
    isValidUsername("john-doe") == true  
  }

  test("isValidUsername returns false if john*doe ") {
    forAll{(username: String) =>
    isValidUsername(username.reverse) == isValidUsername(username)  
    }
  }



}

  ///////////////////////
  // Exercise 2: Point
  ///////////////////////



