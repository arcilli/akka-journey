package org.arrnaux.actors

import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit
import org.arrnaux.actors.Greeter.{Greet, Greeted}
import org.scalatest.wordspec.AnyWordSpecLike

class AkkaQuickstartSpec extends ScalaTestWithActorTestKit with AnyWordSpecLike {
  "reply to greeted" in {
    val replyProbe = createTestProbe[Greeted]()
    val underTest = spawn(Greeter())
    underTest ! Greet("Santa", replyProbe.ref)
    replyProbe.expectMessage(Greeted("Santa", underTest.ref))
  }
}
