package hr.element.etb
package mailer

import Mailer._
import scala.xml.NodeSeq

trait IMail {
  val sentFrom : String
  val subject : String
  val textBody : String
  val htmlBody : Option[String]
  val replyTo : Option[String]


  def getFrom = From(sentFrom)
  def getSubject = Subject(subject)
  def getReplyTo = replyTo.map{ReplyTo(_)}
  def getTextBody = PlainMailBodyType(textBody)
  def getHtmlBody = htmlBody.map(XHTMLMailBodyType(_))

}