package org.arrnaux.actors

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object GreeterMain {
  def apply(): Behavior[SayHello] =
    Behaviors.setup { context =>
      val greeter = context.spawn(Greeter(), "greeter")

      Behaviors.receiveMessage { message =>
        val replyTo = context.spawn(GreeterBot(max = 3), message.name)
        greeter ! Greeter.Greet(message.name, replyTo)
        Behaviors.same
      }
    }

  final case class SayHello(name: String)
}
