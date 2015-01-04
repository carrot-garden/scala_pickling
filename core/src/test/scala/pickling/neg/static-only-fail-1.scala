package scala.pickling.staticonlyfail1

import scala.pickling._
import AllPicklers._
import NegativeCompilation._
import org.scalatest.FunSuite

class StaticOnlyFail1Test extends FunSuite {
  test("main") {
    expectError("cannot generate fully static pickler") {
      """
        | import _root_.scala.pickling._
        | import _root_.scala.pickling.json._
        | import _root_.scala.pickling.static.StaticOnly
        |
        | class C(val fld: Any)
        |
        | val x: C = new C(1)
        | val pickle: JSONPickle = x.pickle
      """.stripMargin
    }
  }
}
