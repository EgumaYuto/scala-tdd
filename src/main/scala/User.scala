/**
  * @author cabos
  */
case class User(companyName: Option[String], name: String, password: String) {

  def hasValidPassword: Boolean = {
    password.length >= 8
  }

  def signification: String = {
    val companyName = this.companyName.map(n => n + ": ").getOrElse("")
    val validResult = if (hasValidPassword) "OK" else "NG"
    companyName + name + " " + validResult
  }
}
