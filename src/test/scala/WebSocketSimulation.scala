import io.gatling.core.Predef._
import io.gatling.http.Predef._

class WebSocketSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:3000")
    .wsBaseURL("ws://localhost:3000")

  val scenario1 = scenario("WebSocket")
    .exec(session => session.set("name", "しばたこ"))
    .exec(ws("Connect WS").open("/char?name=${name}"))
    .pause(1)
    .exec(ws("Say Hello WS")
      .sendText("""Hello message to chat""")
      .check(wsAwait.within(3).until(1).regex(".*"))
    )
    .exec(ws("Close WS").close)

  setUp(
    scenario1.inject(atOnceUsers(10))
  ).protocols(httpConf)
}