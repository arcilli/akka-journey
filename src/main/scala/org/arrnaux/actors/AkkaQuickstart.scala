package org.arrnaux.actors

import akka.actor.typed.ActorSystem

object AkkaQuickstart extends App {
  val greeterMain: ActorSystem[GreeterMain.SayHello] =
    ActorSystem(GreeterMain(), "AkkaQuickStart")
  greeterMain ! SayHello("Charles")
}
