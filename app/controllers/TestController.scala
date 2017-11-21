package controllers

import play.api.libs.json._
import play.api.libs.json.{JsNull,Json,JsString,JsValue}
/**
  * Created by ruth on 2017/11/21.
  */
class TestController {


  object Hello extends App {
    val json: JsValue = Json.parse(
      """
{
  "name" : "Watership Down",
  "location" : {
    "lat" : 51.235685,
    "long" : -1.309197
  },
  "residents" : [ {
    "name" : "Fiver",
    "age" : 4,
    "role" : null
  }, {
    "name" : "Bigwig",
    "age" : 6,
    "role" : "Owsla"
  } ]
}
""")
  }

  val json2: JsValue = JsObject(Seq(
    "name" -> JsString("Watership Down"),
    "location" -> JsObject(Seq("lat" -> JsNumber(51.235685), "long" -> JsNumber(-1.309197))),
    "residents" -> JsArray(Seq(
      JsObject(Seq(
        "name" -> JsString("Fiver"),
        "age" -> JsNumber(4),
        "role" -> JsNull
      )),
      JsObject(Seq(
        "name" -> JsString("Bigwig"),
        "age" -> JsNumber(6),
        "role" -> JsString("Owsla")
      ))
    ))
  ))


  val json3: JsValue = Json.obj(
    "name" -> "Watership Down",
    "location" -> Json.obj("lat" -> 51.235685, "long" -> -1.309197),
    "residents" -> Json.arr(
      Json.obj(
        "name" -> "Fiver",
        "age" -> 4,
        "role" -> JsNull
      ),
      Json.obj(
        "name" -> "Bigwig",
        "age" -> 6,
        "role" -> "Owsla"
      )
    )
  )


  // basic types
  val jsonString = Json.toJson("Fiver")
  val jsonNumber = Json.toJson(4)
  val jsonBoolean = Json.toJson(false)

  // collections of basic types
  val jsonArrayOfInts = Json.toJson(Seq(1, 2, 3, 4))
  val jsonArrayOfStrings = Json.toJson(List("Fiver", "Bigwig"))

  case class Location(lat: Double, long: Double)
  case class Resident(name: String, age: Int, role: Option[String])
  case class Place(name: String, location: Location, residents: Seq[Resident])

  

}
