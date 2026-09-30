# Project_22106710 — MyNutritionapp

MyNutritionapp is a Scala 3 desktop application built with **ScalaFX** and **JavaFX** for exploring food nutrition information. The app lets users browse a food database, inspect detailed nutrient values, combine foods, and view supporting screens such as instructions, analysis, and feedback.

## Features

- Browse foods in a searchable-style table view
- View nutrient details for the selected food item
- Combine multiple foods for comparison and analysis
- Navigate between dedicated app windows for instructions, analysis, and feedback
- Shared styling across the UI for a consistent look and feel

## Tech Stack

- **Scala 3.3.6**
- **ScalaFX 21.0.0-R32**
- **JavaFX 21.0.4**
- FXML-based UI layout
- CSS styling for the interface

## Project Structure

- `src/main/scala-3/MyNutritionapp` — application source code
- `src/main/resources/MyNutritionapp/view` — FXML view files
- `src/main/resources/application.css` — shared stylesheet
- `build.sbt` — SBT build configuration

## How to Run

From the project root, run:

```bash
sbt run
```

Useful additional commands:

```bash
sbt compile
sbt package
```

## Notes

- The main entry point is `MyNutritionapp.MainApp`.
- On Windows, the project uses the JavaFX `win` classifier automatically through the SBT build.

## License

No license file was provided with the project.

