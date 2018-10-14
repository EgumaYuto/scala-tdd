import org.scalatest.FunSpec

/**
  * @author cabos
  */
class UserTest extends FunSpec {

  private case class PasswordTestCase(actual: Boolean, expect: Boolean)
  private case class SignificationTestCase(actual: String, expect: String)

  describe("user") {
    it("password") {
      List.apply(
        PasswordTestCase(User(companyName = None, name = "", password = "passwor").hasValidPassword, expect = false),
        PasswordTestCase(User(companyName = None, name = "", password = "password").hasValidPassword, expect = true)
      ) foreach(testCase => assert(testCase.expect == testCase.actual))
    }

    it("signification") {
      List.apply(
        SignificationTestCase(User(Some("企業名"), "氏名", "password").signification, "企業名: 氏名 OK"),
        SignificationTestCase(User(Some("企業名2"), "氏名", "password").signification, "企業名2: 氏名 OK"),
        SignificationTestCase(User(Some("企業名"), "氏名2", "password").signification, "企業名: 氏名2 OK"),
        SignificationTestCase(User(Some("企業名"), "氏名2", "passwor").signification, "企業名: 氏名2 NG"),
        SignificationTestCase(User(None, "氏名2", "password").signification, "氏名2 OK"),
        SignificationTestCase(User(None, "氏名2", "passwor").signification, "氏名2 NG")
      ) foreach(testCase => assert(testCase.expect == testCase.actual))
    }
  }
}
