package MyNutritionapp.view

import MyNutritionapp.MainApp
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.layout.AnchorPane
import scalafx.Includes.*
import scalafx.scene.chart.PieChart
import scalafx.scene.chart.PieChart.Data


@FXML
class AnalysisWindowController():
  @FXML
  def handleBack(action: ActionEvent): Unit = {
    MainApp.showCombineWindow()
  }

  @FXML
  var AnalysisLabel: Label = null
  @FXML
    private var chartPane: AnchorPane = _

  private def createPieChart(): PieChart = {
    val pieChart = new PieChart {
      data = Seq(
        Data("Protein", MainApp.totalProtein),
        Data("Carbohydrate", MainApp.totalCarbohydrates),
        Data("Fat", MainApp.totalFat),
        Data("Fiber", MainApp.totalFiber),
        Data("Sugar", MainApp.totalSugar)
      )
      clockwise = false

    }
    pieChart
  }

  @FXML
  def initialize(): Unit = {
    // Create the chart and add it to the pane.
    val chart = createPieChart()
    chartPane.children.add(chart)


    AnalysisLabel.text = generateReview()

    AnchorPane.setTopAnchor(chart, 0.0)
    AnchorPane.setBottomAnchor(chart, 0.0)
    AnchorPane.setLeftAnchor(chart, 0.0)
    AnchorPane.setRightAnchor(chart, 0.0)

  }

  def generateReview(): String = {
    val sb = new StringBuilder
    sb.append(s"Based on your selection, the total calories are ${"%.2f".format(MainApp.totalCalories)} kcal.\n")
    sb.append(s"You have consumed ${"%.2f".format(MainApp.totalProtein)}g of protein, ")
    sb.append(s"${"%.2f".format(MainApp.totalCarbohydrates)}g of carbohydrates, ")
    sb.append(s"${"%.2f".format(MainApp.totalFat)}g of fat, ")
    sb.append(s"${"%.2f".format(MainApp.totalFiber)}g of fiber, and ")
    sb.append(s"${"%.2f".format(MainApp.totalSugar)}g of sugar.\n\n")

    //Calories Review
    if (MainApp.totalCalories < 300) {
      sb.append("This is a very light combination. It might not be sufficient for a full meal.")
    } else if (MainApp.totalCalories < 500) {
      sb.append("This combination is relatively low in calories. Consider if it meets your energy needs.")
    } else if (MainApp.totalCalories > 1500) {
      sb.append("This combination is quite high in calories. Be mindful of your daily intake.")
    } else if (MainApp.totalCalories > 1000) {
      sb.append("The calorie count for this combination is on the higher side.")
    } else {
      sb.append("The calorie count for this combination seems moderate and balanced.")
    }

    //Protein Review
    if (MainApp.totalProtein > 50) {
      sb.append("\nExcellent protein intake, great for muscle support and satiety!")
    } else if (MainApp.totalProtein > 30) {
      sb.append("\nYour protein intake is good. It's a key macronutrient for many body functions.")
    } else if (MainApp.totalProtein < 10) {
      sb.append("\nThis combination is very low in protein. Consider adding a protein source like meat, beans, or nuts.")
    } else if (MainApp.totalProtein < 20) {
      sb.append("\nConsider adding more protein sources to your meal to feel fuller for longer.")
    }

    //Carbohydrates Review
    if (MainApp.totalCarbohydrates > 100) {
      sb.append("\nThis is a high-carbohydrate meal, providing a quick source of energy.")
    } else if (MainApp.totalCarbohydrates > 50) {
      sb.append("\nYour carbohydrate intake is moderate. Carbs are essential for energy.")
    } else if (MainApp.totalCarbohydrates < 20) {
      sb.append("\nThis combination is low in carbohydrates. Ensure you have enough energy for your activities.")
    }

    //Fat Review
    if (MainApp.totalFat > 40) {
      sb.append("\nThis combination is quite high in fat. Opt for healthy fats where possible.")
    } else if (MainApp.totalFat > 20) {
      sb.append("\nYour fat intake is moderate. Fats are important for nutrient absorption.")
    } else {
      sb.append("\nThe fat content is low. Healthy fats are important for a balanced diet.")
    }

    //Fiber Review
    if (MainApp.totalFiber > 10) {
      sb.append("\nExcellent fiber intake! This is great for digestive health and blood sugar control.")
    } else if (MainApp.totalFiber > 5) {
      sb.append("\nGood fiber intake. This will help with digestion.")
    } else {
      sb.append("\nTry to include more fiber-rich foods like vegetables, fruits, and whole grains.")
    }

    //Sugar Review
    if (MainApp.totalSugar > 30) {
      sb.append("\nThis combination is high in sugar. Moderation is advised to maintain a healthy diet.")
    } else if (MainApp.totalSugar > 15) {
      sb.append("\nThe sugar content is moderate. Be mindful of added sugars.")
    } else {
      sb.append("\nThis is a low-sugar combination, which is great for your health.")
    }

    sb.toString()
  }

  @FXML
  def handleInstructionWindow(action: ActionEvent): Unit = {
    MainApp.showInstructionsWindow()
  }