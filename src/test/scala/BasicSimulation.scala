import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8000")

  val scenario1 = scenario("BasicSimulation")
    .exec(http("request_1")
    .get("/"))
    .pause(1)

  val scenario2 = scenario("BasicSimulation2")
    .exec(http("request_2")
      .get("/"))
    .pause(1)

  setUp(
    scenario1.inject(atOnceUsers(10)),
    scenario2.inject(atOnceUsers(10))
  ).protocols(httpConf)
}