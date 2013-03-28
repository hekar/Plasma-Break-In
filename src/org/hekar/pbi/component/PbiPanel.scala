package org.hekar.pbi.component

import java.awt._
import java.awt.event._
import javax.swing._

class PbiPanel extends JPanel {
  def setWidth(width: Int): Int = {
    setSize(width, getHeight())
    getWidth()
  }

  def setHeight(height: Int): Int = {
    setSize(height, getHeight())
    getHeight()
  }

  def incrementWidth(width: Int): Unit = {
    setWidth(getWidth() + width)
  }

}
