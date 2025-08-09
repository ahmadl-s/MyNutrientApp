package MyNutritionapp.view

import MyNutritionapp.MainApp
import javafx.fxml.FXML
import javafx.event.ActionEvent
import scalafx.Includes.*
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.Alert
import javafx.scene.control.{TextArea, Button}


@FXML
class FeedbackWindowController():
  @FXML
  def handleHome(action: ActionEvent): Unit =
    MainApp.showOpeningWindow()

  @FXML
  private var feedbackTextArea: TextArea = _

  @FXML
  private var submitButton: Button = _

  @FXML
  def handleSubmitFeedback(event: ActionEvent): Unit = {
    val userFeedback = feedbackTextArea.text.value

    if (userFeedback.trim.nonEmpty) {
      val alert = new Alert(AlertType.Information) {
        title = "Feedback Submitted"
        contentText = s"Thank you for your feedback:\n\n$userFeedback"
      }

      alert.showAndWait()

      feedbackTextArea.text = ""
    } else {
      val alert = new Alert(AlertType.Warning) {
        title = "No Feedback Entered"
        contentText = "Please enter your feedback before submitting."
      }
      alert.showAndWait()
    }
  }

