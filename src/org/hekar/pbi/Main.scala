package org.hekar.pbi

import java.awt._
import java.awt.event._
import javax.swing._

import org.hekar.pbi.fix._

class BreakInWindow(var monitor: GraphicsDevice) extends JFrame {

  setLayout(new BorderLayout())
  setTitle("Plasma Break-In")

  private val containers = Array(new AspectRatioFix)
  private def currentContainer() = {
    containers(0)
  }

  add(currentContainer, BorderLayout.CENTER)

  addKeyListener(new KeyListener() {

    def keyPressed(e: KeyEvent): Unit = {
      currentContainer.keyPressed(e)
      currentContainer.validate()
    }

    def keyReleased(x$1: KeyEvent): Unit = {
    }

    def keyTyped(e: KeyEvent): Unit = {
    }
  })

  def makeFullscreen(): Unit = {
    val fullscreenSupported = monitor.isFullScreenSupported();
    setUndecorated(fullscreenSupported);
    setResizable(!fullscreenSupported);
    if (fullscreenSupported) {
      // Full-screen mode
      val window = BreakInWindow.this
      monitor.setFullScreenWindow(window)

      validate()
      currentContainer.validate()
    } else {
      throw new IllegalStateException("Cannot open fullscreen window on monitor")
    }
  }

}

object Main {
  def main(args: Array[String]): Unit = {
    try {
      val env = GraphicsEnvironment
        .getLocalGraphicsEnvironment()

      val primaryMonitor = env.getScreenDevices()(0)
      val window = new BreakInWindow(primaryMonitor)
      window.makeFullscreen()
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    } catch {
      case e: Exception =>
        JOptionPane.showMessageDialog(null, e.getMessage())
    }
  }
}