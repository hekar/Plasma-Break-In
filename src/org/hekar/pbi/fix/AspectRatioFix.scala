package org.hekar.pbi.fix

import java.awt._
import java.awt.event._
import javax.swing._

import org.hekar.pbi.component._

class AspectRatioFix extends JPanel {
  private val defaultWidth = 50

  private val left = new PbiPanel()
  private val middle = new PbiPanel()
  private val right = new PbiPanel()

  left.setWidth(defaultWidth)
  middle.setWidth(0)
  right.setWidth(defaultWidth)

  setLayout(null)
  add(left)
  add(right)
  add(middle)

  def keyPressed(e: KeyEvent): Unit = {
    e.getKeyCode() match {
      case KeyEvent.VK_LEFT =>
        left.incrementWidth(-3)
        right.incrementWidth(-3)
      case KeyEvent.VK_RIGHT =>
        left.incrementWidth(3)
        right.incrementWidth(3)
      case _ =>
      // ignore...
    }
  }

  override def validate(): Unit = {
    super.validate()

    def fillHeight(panel: JPanel): Unit = {
      panel.setSize(panel.getWidth(), getHeight())
    }

    fillHeight(left)
    fillHeight(right)
    fillHeight(middle)

    left.setBackground(Color.white)
    left.setLocation(0, 0)

    right.setBackground(Color.white)
    right.setLocation(getWidth() - right.getWidth(), 0)

    middle.setBackground(Color.black)
    middle.setWidth(getWidth() - left.getWidth() - right.getWidth())
    middle.setLocation(left.getWidth(), 0)
  }
}
