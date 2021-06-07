package org.arrnaux.actors

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

// An actor
// https://developer.lightbend.com/guides/akka-quickstart-scala/define-actors.html
object Greeter {
  def apply(): Behavior[Greet] =
    Behaviors.receive { (context, message) =>
      context.log.info("Hello {}!", message.whom)
      message.replyTo ! Greeted(message.whom, context.self)
      Behaviors.same
    }

  final case class Greet(whom: String, replyTo: ActorRef[Greeted])

  final case class Greeted(whom: String, from: ActorRef[Greet])
}
