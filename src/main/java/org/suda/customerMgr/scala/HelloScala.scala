package org.suda.customerMgr.scala
import scala.collection.mutable.ArrayBuffer


/**
 * Created by user1 on 23.10.15.
 */
object HelloScala {
        def  main(args: Array[String]) {

                var fruits = ArrayBuffer[String]()
                fruits += "Apple"
                fruits += "Banana"
                fruits += "Orange"
                for (i<-fruits) println(i)
        }
        for (i <- 0 to 10) {
                println("iteration" + i)

        }
        def get() =  println("it is shit is working")
}
