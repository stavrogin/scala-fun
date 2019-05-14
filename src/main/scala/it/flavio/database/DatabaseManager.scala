package it.flavio.database

import java.sql.{Connection, DriverManager}

/**
  * Test class for using H2 database
  * Created by riccif on 29/05/2017.
  */
object DatabaseManager {

  def main(args: Array[String]) {

    // connect to the database named "mysql" on the localhost
    val driver = "org.h2.Driver"
    val url = "jdbc:h2:~/test.db"
    val username = "root"
    val password = "root"

    // there's probably a better way to do this
    var connection: Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()

      val resultSet = statement.executeUpdate("CREATE TABLE track (id number)")

      connection.close()
    } catch {
      case e: Throwable => e.printStackTrace
    }
  }
}