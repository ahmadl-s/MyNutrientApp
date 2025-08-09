package MyNutritionapp


import MyNutritionapp.view.{AboutWindowController, CombineWindowController, FeedbackWindowController, InstructionsWindowController}
import javafx.fxml.FXMLLoader
import scalafx.stage.Stage
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import MyNutritionapp.model.{FoodItem, Fruit, Grain, Meat, Vegetable}

import java.net.URL
import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import scalafx.stage.Modality.ApplicationModal





object MainApp extends JFXApp3:

  var rootPane: Option[javafx.scene.layout.BorderPane] = None

  val foodData = new ObservableBuffer[FoodItem]()


  foodData += new Grain("White Rice", 130, 2.7, 28, 0.3, 0.4, 0.1)
  foodData += new Grain("Brown Rice", 123, 2.7, 25.6, 1.0, 1.6, 0.2)
  foodData += new Grain("Oats", 389, 16.9, 66.3, 6.9, 10.6, 0.0)
  foodData += new Grain("Whole Wheat Bread", 265, 9.0, 49, 3.2, 2.7, 5.0)
  foodData += new Grain("Corn Flakes", 378, 8.5, 84.3, 1.8, 3.3, 8.0)
  foodData += new Grain("Pasta (Cooked)", 131, 5.2, 25, 1.1, 4.0, 1.6)
  foodData += new Grain("Pancake", 227, 8.4, 42.6, 2.7, 2.2, 8.8)
  foodData += new Grain("Tortilla", 218, 5.7, 44.8, 1.8, 2.5, 0.8)
  foodData += new Grain("Couscous", 112, 3.8, 23.2, 0.2, 1.4, 0.1)
  foodData += new Grain("Quinoa", 120, 4.4, 21.3, 1.9, 2.8, 0.9)

  foodData += new Meat("Salmon", 208, 20.4, 0, 13.4, 0, 0)
  foodData += new Meat("Chicken Breast", 165, 31, 0, 3.6, 0, 0)
  foodData += new Meat("Beef Steak", 271, 29.0, 0, 17.0, 0, 0)
  foodData += new Meat("Ground Turkey", 189, 22, 0, 11, 0, 0)
  foodData += new Meat("Cod", 82, 18, 0, 0.7, 0, 0)
  foodData += new Meat("Lamb Chop", 305, 19, 0, 25, 0, 0)
  foodData += new Meat("Tuna (Canned)", 128, 28, 0, 1.0, 0, 0)
  foodData += new Meat("Duck", 337, 19, 0, 28, 0, 0)
  foodData += new Meat("Veal Chop", 200, 29, 0, 8, 0, 0)
  foodData += new Meat("Venison Steak", 157, 28, 0, 4, 0, 0)

  foodData += new Fruit("Apple", 52, 0.3, 14, 0.2, 2.4, 10.4)
  foodData += new Fruit("Banana", 89, 1.1, 22.8, 0.3, 2.6, 12.2)
  foodData += new Fruit("Orange", 47, 0.9, 11.8, 0.1, 2.4, 9.4)
  foodData += new Fruit("Avocado", 160, 2.0, 8.5, 14.7, 6.7, 0.7)
  foodData += new Fruit("Strawberries", 32, 0.7, 7.7, 0.3, 2.0, 4.9)
  foodData += new Fruit("Blueberries", 57, 0.7, 14.5, 0.3, 2.4, 9.9)
  foodData += new Fruit("Grapes", 69, 0.6, 18.1, 0.2, 0.9, 15.5)
  foodData += new Fruit("Mango", 60, 0.8, 15, 0.4, 1.6, 13.7)
  foodData += new Fruit("Pineapple", 50, 0.5, 13.1, 0.1, 1.4, 9.9)
  foodData += new Fruit("Watermelon", 30, 0.6, 7.6, 0.2, 0.4, 6.2)

  foodData += new Vegetable("Carrot", 41, 0.9, 10, 0.2, 2.8, 4.7)
  foodData += new Vegetable("Broccoli", 55, 3.7, 11.2, 0.6, 5.1, 2.2)
  foodData += new Vegetable("Spinach", 23, 2.9, 3.6, 0.4, 2.2, 0.4)
  foodData += new Vegetable("Sweet Potato", 86, 1.6, 20.1, 0.1, 3.0, 4.2)
  foodData += new Vegetable("Bell Pepper (Red)", 31, 1.0, 6.0, 0.3, 2.1, 4.2)
  foodData += new Vegetable("Tomato", 18, 0.9, 3.9, 0.2, 1.2, 2.6)
  foodData += new Vegetable("Cucumber", 15, 0.7, 3.6, 0.1, 0.5, 1.7)
  foodData += new Vegetable("Potato", 77, 2.0, 17.5, 0.1, 2.2, 0.8)
  foodData += new Vegetable("Onion", 40, 1.1, 9.3, 0.1, 1.7, 4.2)
  foodData += new Vegetable("Kale", 49, 4.3, 8.8, 0.9, 3.6, 1.3)

  // Combine all into a single list of FoodItem

  var totalCalories: Double = 0.0
  var totalProtein: Double = 0.0
  var totalCarbohydrates: Double = 0.0
  var totalFat: Double = 0.0
  var totalFiber: Double = 0.0
  var totalSugar: Double = 0.0


  override def start(): Unit = {
    val rootLayoutResource: URL = getClass.getResource("/MyNutritionapp/view/RootLayout.fxml")
    val loader = new FXMLLoader(rootLayoutResource)
    val rootLayout = loader.load[javafx.scene.layout.BorderPane]()
    rootPane = Option(loader.getRoot[javafx.scene.layout.BorderPane]())
    stage = new PrimaryStage():
      title = "My Nutrition App"
      scene = new Scene():
        root = rootLayout
    showOpeningWindow()
  }

  def showOpeningWindow(): Unit =
    val OpeningWindowResource = getClass.getResource("/MyNutritionapp/view/OpeningWindow.fxml")
    val loader = new FXMLLoader(OpeningWindowResource)
    val OpeningWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(OpeningWindowPane))

  def showMainWindow(): Unit = {
    val MainWindowResource = getClass.getResource("/MyNutritionapp/view/MainWindow.fxml")
    val loader = new FXMLLoader(MainWindowResource)
    val MainWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(MainWindowPane))
}


  def showAboutWindow(): Boolean = {
    val aboutResource = getClass.getResource("/MyNutritionapp/view/AboutWindow.fxml")
    val loader = new FXMLLoader(aboutResource)
    loader.load()
    val AboutWindowpane = loader.getRoot[javafx.scene.layout.AnchorPane]()
    val aboutWindowStage = new Stage():
      initOwner(stage)
      initModality(ApplicationModal)
      title = "About"
      scene = new Scene():
        root = AboutWindowpane
    val ctrl = loader.getController[AboutWindowController]()
    ctrl.stage = Option(aboutWindowStage)
    aboutWindowStage.showAndWait()
    ctrl.okCliked

  }

  def showCombineWindow(): Unit = {
    val CombineWindowResource = getClass.getResource("/MyNutritionapp/view/CombineWindow.fxml")
    val loader = new FXMLLoader(CombineWindowResource)
    val CombineWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(CombineWindowPane))
  }

  def showAnalysisWindow(): Unit = {
    val AnalysisWindowResource = getClass.getResource("/MyNutritionapp/view/AnalysisWindow.fxml")
    val loader = new FXMLLoader(AnalysisWindowResource)
    val AnalysisWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(AnalysisWindowPane))
  }

  def showFeedbackWindow(): Unit = {
    val FeedbackWindowResource = getClass.getResource("/MyNutritionapp/view/FeedbackWindow.fxml")
    val loader = new FXMLLoader(FeedbackWindowResource)
    val FeedbackWindowPane = loader.load[javafx.scene.layout.AnchorPane]()
    rootPane.foreach(_.setCenter(FeedbackWindowPane))
  }

  def showInstructionsWindow(): Unit = {
    val InstructionResource = getClass.getResource("/MyNutritionapp/view/InstructionsWindow.fxml")
    val loader = new FXMLLoader(InstructionResource)
    loader.load()
    val InstructionWindowpane = loader.getRoot[javafx.scene.layout.AnchorPane]()
    val InstructionWindowStage = new Stage():
      initOwner(stage)
      initModality(ApplicationModal)
      title = "Instructions and Tips"
      scene = new Scene():
        root = InstructionWindowpane
    val ctrl = loader.getController[InstructionsWindowController]()
    ctrl.stage = Option(InstructionWindowStage)
    InstructionWindowStage.showAndWait()
    ctrl.okCliked
  }














