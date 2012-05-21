package hr.element.etb
package mailer

import net.liftweb.util.Mailer._
import scala.xml.XML

trait IMail {
  val sentFrom : String
  val subject : String
  val textBody : String
  val htmlBody : String
  val replyTo : Option[String]


  def getFrom = From(sentFrom)
  def getSubject = Subject(subject)
  def getReplyTo =
    replyTo match {
      case Some(rTAddr) => ReplyTo(rTAddr)
      case _ => ReplyTo(sentFrom)
    }
  def getTextBody = PlainMailBodyType(textBody)
  def getHtmlBody = XHTMLMailBodyType(XML.loadString(htmlBody))
}