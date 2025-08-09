package MyNutritionapp.view

import javafx.event.ActionEvent
import javafx.fxml.FXML
import MyNutritionapp.MainApp

@FXML
class RootLayoutController():
  @FXML
  def handleClose(action: ActionEvent): Unit =
    System.exit(0)

  @FXML
  def handleAboutWindow(action: ActionEvent): Unit =
    MainApp.showAboutWindow()

  @FXML
  def handleHome(action: ActionEvent): Unit =
    MainApp.showOpeningWindow()

  @FXML
  def handleFeedbackWindow(action: ActionEvent): Unit =
    MainApp.showFeedbackWindow()

  @FXML
  def handleViewFoodPage(action: ActionEvent): Unit =
    MainApp.showMainWindow()

  @FXML
  def handleCombineFoodPage(action: ActionEvent): Unit =
    MainApp.showCombineWindow()





