package MyNutritionapp.view

import MyNutritionapp.MainApp
import MyNutritionapp.model.FoodItem
import javafx.event.ActionEvent
import javafx.scene.control.{Label, TableColumn, TableView}
import javafx.fxml.FXML
import scalafx.Includes.*


@FXML
class MainWindowController():
  @FXML
  private var foodTableView: TableView[FoodItem] = null
  @FXML
  private var foodNameColumn: TableColumn[FoodItem , String] = null
  @FXML
  private var nameLabel: Label = null
  @FXML
  private var caloriesLabel: Label = null
  @FXML
  private var proteinLabel: Label = null
  @FXML
  private var carbohydratesLabel: Label = null
  @FXML
  private var fatLabel: Label = null
  @FXML
  private var fiberLabel: Label = null
  @FXML
  private var sugarLabel: Label = null

  

  def initialize(): Unit =
    foodTableView.items = MainApp.foodData
    foodNameColumn.cellValueFactory = _.value.name

      showFoodDetails(None)
    foodTableView.selectionModel().selectedItem.onChange(
      (_, _, newValue) => showFoodDetails(Option(newValue))
  )

  private def showFoodDetails(person: Option[FoodItem]): Unit = {
    person match
      case Some(person) =>
        nameLabel.text <== person.name
        caloriesLabel.text = person.calories.value.toString
        proteinLabel.text = person.protein.value.toString
        carbohydratesLabel.text = person.carbohydrates.value.toString
        fatLabel.text = person.fat.value.toString
        fiberLabel.text = person.fiber.value.toString
        sugarLabel.text = person.sugar.value.toString

      case None =>
        nameLabel.text = ""
        caloriesLabel.text = ""
        proteinLabel.text = ""
        carbohydratesLabel.text = ""
        fatLabel.text = ""
        fiberLabel.text = ""
        sugarLabel.text = ""

  }

  @FXML
  def handleCombineWindow(action: ActionEvent): Unit = {
    MainApp.showCombineWindow()
  }

  @FXML
  def handleInstructionWindow(action: ActionEvent): Unit = {
    MainApp.showInstructionsWindow()
  }
