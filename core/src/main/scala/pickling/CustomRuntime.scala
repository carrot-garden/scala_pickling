package scala.pickling

import scala.reflect.runtime
import runtime.{universe => ru}

import scala.collection.generic.CanBuildFrom

import internal._

trait RuntimePicklersUnpicklers {

  GlobalRegistry.picklerMap   += ("scala.Tuple2" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2" -> (new Tuple2RTPickler(null)))

  /* Register all specialized variants of Tuple2.
   */
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcII$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcIJ$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcID$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcIC$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcIZ$sp" -> (tag => new Tuple2RTPickler(tag)))

  GlobalRegistry.picklerMap += ("scala.Tuple2$mcJI$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcJJ$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcJD$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcJC$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcJZ$sp" -> (tag => new Tuple2RTPickler(tag)))

  GlobalRegistry.picklerMap += ("scala.Tuple2$mcDI$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcDJ$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcDD$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcDC$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcDZ$sp" -> (tag => new Tuple2RTPickler(tag)))

  GlobalRegistry.picklerMap += ("scala.Tuple2$mcCI$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcCJ$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcCD$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcCC$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcCZ$sp" -> (tag => new Tuple2RTPickler(tag)))

  GlobalRegistry.picklerMap += ("scala.Tuple2$mcZI$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcZJ$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcZD$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcZC$sp" -> (tag => new Tuple2RTPickler(tag)))
  GlobalRegistry.picklerMap += ("scala.Tuple2$mcZZ$sp" -> (tag => new Tuple2RTPickler(tag)))

  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcII$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcIJ$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcID$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcIC$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcIZ$sp" -> (new Tuple2RTPickler(null)))

  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcJI$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcJJ$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcJD$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcJC$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcJZ$sp" -> (new Tuple2RTPickler(null)))

  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcDI$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcDJ$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcDD$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcDC$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcDZ$sp" -> (new Tuple2RTPickler(null)))

  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcCI$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcCJ$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcCD$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcCC$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcCZ$sp" -> (new Tuple2RTPickler(null)))

  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcZI$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcZJ$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcZD$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcZC$sp" -> (new Tuple2RTPickler(null)))
  GlobalRegistry.unpicklerMap += ("scala.Tuple2$mcZZ$sp" -> (new Tuple2RTPickler(null)))


  def mkAnyRefArrayTravPickler[C <% Traversable[_]](mirror: ru.Mirror, classLoader: ClassLoader)(implicit cbf: CanBuildFrom[C, AnyRef, C]):
    SPickler[C] /*with Unpickler[C]*/ = new SPickler[C] /*with Unpickler[C]*/ {

    def pickle(coll: C, builder: PBuilder): Unit = {
      builder.hintTag(FastTypeTag.ArrayAnyRef)
      builder.beginEntry(coll)

      builder.beginCollection(coll.size)
      (coll: Traversable[_]).asInstanceOf[Traversable[AnyRef]].foreach { (elem: AnyRef) =>
        builder putElement { b =>
          val elemClass = elem.getClass
          val elemTag = FastTypeTag.mkRaw(elemClass, mirror) // slow: `mkRaw` is called for each element
          b.hintTag(elemTag)
          val pickler = SPickler.genPickler(classLoader, elemClass, elemTag).asInstanceOf[SPickler[AnyRef]]
          pickler.pickle(elem, b)
        }
      }
      builder.endCollection()

      builder.endEntry()
    }
  }

  def mkRuntimeTravPickler[C <% Traversable[_]](elemClass: Class[_], elemTag: FastTypeTag[_], collTag: FastTypeTag[_],
                                                elemPickler0: SPickler[_], elemUnpickler0: Unpickler[_]):
    SPickler[C] with Unpickler[C] = new SPickler[C] with Unpickler[C] {

    val elemPickler   = elemPickler0.asInstanceOf[SPickler[AnyRef]]
    val elemUnpickler = elemUnpickler0.asInstanceOf[Unpickler[AnyRef]]

    val isPrimitive = elemTag.tpe.isEffectivelyPrimitive

    def pickle(coll: C, builder: PBuilder): Unit = {
      builder.beginEntry(coll)
      builder.beginCollection(coll.size)

      builder.pushHints()
      if (isPrimitive) {
        builder.hintStaticallyElidedType()
        builder.hintTag(elemTag)
        builder.pinHints()
      }

      (coll: Traversable[_]).asInstanceOf[Traversable[AnyRef]].foreach { (elem: AnyRef) =>
        builder putElement { b =>
          if (!isPrimitive) b.hintTag(elemTag)
          elemPickler.pickle(elem, b)
        }
      }

      builder.popHints()
      builder.endCollection()
      builder.endEntry()
    }

    def unpickle(tag: => FastTypeTag[_], preader: PReader): Any = {
      val reader = preader.beginCollection()

      preader.pushHints()
      if (isPrimitive) {
        reader.hintStaticallyElidedType()
        reader.hintTag(elemTag)
        reader.pinHints()
      }

      val length = reader.readLength()
      val newArray = java.lang.reflect.Array.newInstance(elemClass, length).asInstanceOf[Array[AnyRef]]

      var i = 0
      while (i < length) {
        try {
          val r = reader.readElement()
          r.beginEntryNoTag()
          val elem = elemUnpickler.unpickle(elemTag, r)
          r.endEntry()
          newArray(i) = elem.asInstanceOf[AnyRef]
          i = i + 1
        } catch {
          case PicklingException(msg, cause) =>
            throw PicklingException(s"""error in unpickle of 'mkRuntimeTravPickler':
                                       |collTag: '${collTag.key}'
                                       |elemTag: '${elemTag.key}'
                                       |message:
                                       |$msg""".stripMargin, cause)
          case e: Exception =>
            e.printStackTrace()
            throw PicklingException(s"""exception in unpickle of 'mkRuntimeTravPickler':
                                       |collTag: '${collTag.key}'
                                       |elemTag: '${elemTag.key}'""".stripMargin, Some(e))
        }
      }

      preader.popHints()
      preader.endCollection()
      newArray
    }
  }

}


class Tuple2RTPickler(tag: FastTypeTag[_]) extends SPickler[(Any, Any)] with Unpickler[(Any, Any)] {
  def pickleField(name: String, value: Any, builder: PBuilder): Unit = {
    val (tag1, pickler1) = if (value == null) {
      (FastTypeTag.Null.asInstanceOf[FastTypeTag[Any]], SPickler.nullPicklerUnpickler.asInstanceOf[SPickler[Any]])
    } else {
      val clazz = value.getClass
      val tag = FastTypeTag.mkRaw(clazz, runtime.currentMirror).asInstanceOf[FastTypeTag[Any]]
      val pickler = SPickler.genPickler(clazz.getClassLoader, clazz, tag).asInstanceOf[SPickler[Any]]
      (tag, pickler)
    }

    builder.putField(name, b => {
      b.hintTag(tag1)
      pickler1.pickle(value, b)
    })
  }

  def pickle(picklee: (Any, Any), builder: PBuilder): Unit = {
    // println(s"@@@ using runtime ${this.getClass.getName}")
    builder.beginEntry(picklee)

    val fld1 = picklee._1
    pickleField("_1", fld1, builder)

    val fld2 = picklee._2
    pickleField("_2", fld2, builder)

    builder.endEntry()

    // val specialPickler = new SpecialTuple2Pickler(tag1, pickler1, tag2, pickler2)
    // SpecialTuple2Pickler.classSelection += ((class1 -> class2) -> Selection(specialPickler, tag))
    // println(s"@@@ registered dynamic specialized pickler ${specialPickler.getClass.getName}")
  }

  def unpickleField(name: String, reader: PReader): Any = {
    val reader1 = reader.readField(name)
    val tag1 = reader1.beginEntry()

    val value = {
      if (reader1.atPrimitive) {
        reader1.readPrimitive()
      } else {
        val unpickler1 = Unpickler.genUnpickler(runtime.currentMirror, tag1)
        try {
          unpickler1.unpickle(tag1, reader1)
        } catch {
          case PicklingException(msg, cause) =>
            throw PicklingException(s"""error in unpickle of '${this.getClass.getName}':
                                       |field name: '$name'
                                       |field tag: '${tag1.key}'
                                       |message:
                                       |$msg""".stripMargin, cause)
        }
      }
    }
    reader1.endEntry()
    value
  }

  def unpickle(tag: => FastTypeTag[_], reader: PReader): Any = {
    val fld1 = unpickleField("_1", reader)
    val fld2 = unpickleField("_2", reader)
    (fld1, fld2)
  }
}
