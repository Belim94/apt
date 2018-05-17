package gui.classes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class main extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Бюджет проекта (в рублях): ");
//        int budget = Integer.parseInt(reader.readLine());
//        System.out.println("Продолжительность проекта (в месяцах): ");
//        int terms = Integer.parseInt(reader.readLine());
//        System.out.println("Размер команды: ");
//        int teamSize = Integer.parseInt(reader.readLine());
//        System.out.println("Стоимость одного участника пректа / час: ");
//        int payment = Integer.parseInt(reader.readLine());
//        System.out.println("Количество рабочих дней в неделю: ");
//        int workingDaysAWeek = Integer.parseInt(reader.readLine()) * 30 / 7;
//        System.out.println("Количество рабочих часов в день: ");
//        int workingHoursADay = Integer.parseInt(reader.readLine());
//        System.out.println("Манимальная длина спринта (в часах): ");
//        int minSprint = Integer.parseInt(reader.readLine());
//        System.out.println("Максимальное превышение бюджета проекта (в %): ");
//        //double maxOverbudget = Integer.parseInt(  reader.readLine()) * 0.01 * budget;
//        System.out.println("Максимальное превышение длительности проекта (в %): ");
//        //double maxTime = Integer.parseInt(reader.readLine()) * 0.01 * terms * 30;
//
//        int t1 = minSprint;
//        int t2 = terms * workingDaysAWeek * workingHoursADay;
//        int k1 = 1;
//        int k2 = terms * 4;
//
//        // Построение платежной матрицы алгоритмом BruteForce
//        ArrayList<Integer> quantityOfSprints = new ArrayList<>();
//        ArrayList<Integer> sprintTime = new ArrayList<>();
//        ArrayList<Integer> setOfSprintTimes = new ArrayList<>();
//        for (int i = 40; i < t2; i+=40) {
//            setOfSprintTimes.add(i);
//        }
//        int y;
//        int x = 0;
//        for (int i = k2; i > 0; i--) {
//            quantityOfSprints.add(i);
//            y = Integer.MAX_VALUE;
//            for (int j = 0; j < setOfSprintTimes.size(); j++) {
//                if (y > Math.abs(setOfSprintTimes.get(j) - t2 / i)) {
//                    y = Math.abs(setOfSprintTimes.get(j) - t2 / i);
//                    x = setOfSprintTimes.get(j);
//                }
//            }
//            sprintTime.add(x);
//        }
//
//        // Строим платежную матрицу
//        ArrayList<Integer> B1 = new ArrayList<>();
//        ArrayList<Integer> B2 = new ArrayList<>();
//        ArrayList<Integer> B3 = new ArrayList<>();
//
//        for (int i = 0; i < quantityOfSprints.size(); i++) {
//            B1.add(quantityOfSprints.get(i) * sprintTime.get(i) * payment * teamSize);
//
//            if (sprintTime.get(i) > 160 && sprintTime.get(i) < 480) B2.add(quantityOfSprints.get(i) * sprintTime.get(i) * payment * teamSize);
//            else B2.add(0);
//
//            if (quantityOfSprints.get(i) <=3) B3.add(quantityOfSprints.get(i) * sprintTime.get(i) * payment * teamSize);
//            else B3.add(0);
//        }
//        System.out.println("    B1  B2  B3");
//        for (int i = 0; i < B1.size(); i++) {
//            System.out.println("A"+ i + " " + B1.get(i) + " " + B2.get(i) + " " + B3.get(i));
//        }


    }

    public String calculator (String budget1, String terms1, String teamSize1, String payment1, String workingDaysAWeek1,
                              String workingHoursADay1, String minSprint1, String maxOverbudget1,
                              String maxTime1) throws IOException{

        int budget = Integer.valueOf(budget1);
        int terms = Integer.valueOf(terms1);
        int teamSize = Integer.valueOf(teamSize1);
        int payment = Integer.valueOf(payment1);
        int workingDaysAWeek = Integer.valueOf(workingDaysAWeek1) * 30 / 7;
        int workingHoursADay = Integer.valueOf(workingHoursADay1);
        int minSprint = Integer.valueOf(minSprint1);
        double maxOverbudget = Integer.valueOf(maxOverbudget1) * 0.01 * budget;
        double maxTime = Integer.valueOf(maxTime1) * 0.01 * terms * 30;

        int t1 = minSprint;
        int t2 = terms * workingDaysAWeek * workingHoursADay;
        int k1 = 1;
        int k2 = terms * 4;

        // Построение платежной матрицы алгоритмом BruteForce

        ArrayList<Integer> quantityOfSprints = new ArrayList<>();
        ArrayList<Integer> sprintTime = new ArrayList<>();
        ArrayList<Integer> setOfSprintTimes = new ArrayList<>();

        for (int i = 40; i < t2; i+=40) {
            setOfSprintTimes.add(i);
        }
        int y;
        int x = 0;

        for (int i = k2; i > 0; i--) {
            quantityOfSprints.add(i);
            y = Integer.MAX_VALUE;
            for (int j = 0; j < setOfSprintTimes.size(); j++) {
                if (y > Math.abs(setOfSprintTimes.get(j) - t2 / i)) {
                    y = Math.abs(setOfSprintTimes.get(j) - t2 / i);
                    x = setOfSprintTimes.get(j);
                }
            }
            sprintTime.add(x);
        }

        // Строим платежную матрицу
        ArrayList<Integer> B1 = new ArrayList<>();
        ArrayList<Integer> B2 = new ArrayList<>();
        ArrayList<Integer> B3 = new ArrayList<>();

        for (int i = 0; i < quantityOfSprints.size(); i++) {
            B1.add(quantityOfSprints.get(i) * sprintTime.get(i) * payment * teamSize);

            if (sprintTime.get(i) > 160 && sprintTime.get(i) < 480) B2.add(quantityOfSprints.get(i) * sprintTime.get(i) * payment * teamSize);
            else B2.add(0);

            if (quantityOfSprints.get(i) <=3) B3.add(quantityOfSprints.get(i) * sprintTime.get(i) * payment * teamSize);
            else B3.add(0);
        }

        for (int i = 0; i < B1.size(); i++) {
            if (B1.get(i) > budget + maxOverbudget) B1.set(i,0);
            if (B2.get(i) > budget + maxOverbudget) B2.set(i,0);
            if (B3.get(i) > budget + maxOverbudget) B3.set(i,0);
        }

        int value = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < B1.size(); i++) {
            if (value < B1.get(i)) {
                value = B1.get(i);
                index = i;
            }
        }

        int value1 = Integer.MIN_VALUE;
        int index1 = 0;
        for (int i = 0; i < B1.size(); i++) {
            if (value1 < B1.get(i)) {
                value1 = B1.get(i);
                index1 = i;
            }
            if (sprintTime.get(i)>240) break;
        }
        return String.valueOf(value)+ " " + String.valueOf(value1);
    }

    Stage window;
    Scene scene1, scene2, middleScene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        //Окно ввода данных

        GridPane homeGrid = new GridPane();
        homeGrid.setPadding(new Insets(10, 10, 10, 10));
        homeGrid.setVgap(1);
        homeGrid.setHgap(2);

        GridPane titleGrid = new GridPane();
        titleGrid.setPadding(new Insets(10, 10, 10, 10));
        titleGrid.setVgap(1);
        titleGrid.setHgap(2);

        Label title = new Label();
        title.setText("Добро пожаловать в Agile Planning Tools! Пожалуйста, заполните все поля:");
        GridPane.setConstraints(title, 0, 0);

        Label budget = new Label();
        budget.setText("Бюджет проекта (в рублях):");
        GridPane.setConstraints(budget, 0, 1);

        TextField budgetField = new TextField();
        budgetField.setPromptText("3000000");
        GridPane.setConstraints(budgetField, 1, 1);

        Label terms = new Label();
        terms.setText("Продолжительность проекта (в месяцах):");
        GridPane.setConstraints(terms, 0, 2);

        TextField termsField = new TextField();
        termsField.setPromptText("10");
        GridPane.setConstraints(termsField, 1, 2);

        Label teamSize = new Label();
        teamSize.setText("Размер команды:");
        GridPane.setConstraints(teamSize, 0, 3);

        TextField teamSizeField = new TextField();
        teamSizeField.setPromptText("5");
        GridPane.setConstraints(teamSizeField, 1, 3);

        Label payment = new Label();
        payment.setText("Стоимость одного участника пректа / час:");
        GridPane.setConstraints(payment, 0, 4);

        TextField paymentField = new TextField();
        paymentField.setPromptText("500");
        GridPane.setConstraints(paymentField, 1, 4);

        Label workingDaysAWeek = new Label();
        workingDaysAWeek.setText("Количество рабочих дней в неделю:");
        GridPane.setConstraints(workingDaysAWeek, 0, 5);

        TextField workingDaysAWeekField = new TextField();
        workingDaysAWeekField.setPromptText("5");
        GridPane.setConstraints(workingDaysAWeekField, 1, 5);

        Label workingHoursADay = new Label();
        workingHoursADay.setText("Количество рабочих часов в день:");
        GridPane.setConstraints(workingHoursADay, 0, 6);

        TextField workingHoursADayField = new TextField();
        workingHoursADayField.setPromptText("8");
        GridPane.setConstraints(workingHoursADayField, 1, 6);

        Label minSprint = new Label();
        minSprint.setText("Манимальная длина спринта (в часах):");
        GridPane.setConstraints(minSprint, 0, 7);

        TextField minSprintField = new TextField();
        minSprintField.setPromptText("40");
        GridPane.setConstraints(minSprintField, 1, 7);

        Label maxOverbudget = new Label();
        maxOverbudget.setText("Максимальное превышение бюджета проекта (в %):");
        GridPane.setConstraints(maxOverbudget, 0, 8);

        TextField maxOverbudgetField = new TextField();
        maxOverbudgetField.setPromptText("10");
        GridPane.setConstraints(maxOverbudgetField, 1, 8);

        Label maxTime = new Label();
        maxTime.setText("Максимальное превышение длительности проекта (в %):");
        GridPane.setConstraints(maxTime, 0, 9);

        TextField maxTimeField = new TextField();
        maxTimeField.setPromptText("10");
        GridPane.setConstraints(maxTimeField, 1, 9);

        Button calcButton = new Button();
        calcButton.setText("Далее");
        final String[] answer = new String[1];
        calcButton.setOnAction(e -> {
            isInt(budget, budgetField, calcButton);
            isInt(terms, termsField, calcButton);
            isInt(teamSize, teamSizeField, calcButton);
            isInt(payment, paymentField, calcButton);
            isInt(workingDaysAWeek, workingDaysAWeekField, calcButton);
            isInt(workingHoursADay, workingHoursADayField, calcButton);
            isInt(minSprint, minSprintField, calcButton);
            isInt(maxOverbudget, maxOverbudgetField, calcButton);
            isInt(maxTime, maxTimeField, calcButton);
            try {
                answer[0] = calculator(budgetField.getText(), termsField.getText(),
                        teamSizeField.getText(), paymentField.getText(),
                        workingDaysAWeekField.getText(), workingHoursADayField.getText(),
                        minSprintField.getText(), maxOverbudgetField.getText(),
                        maxTimeField.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String answer1 = answer[0];
        });
        GridPane.setConstraints(calcButton, 50, 70);

        homeGrid.getChildren().addAll(budget, budgetField, terms, termsField, teamSize, teamSizeField, payment, paymentField,
                workingDaysAWeek, workingDaysAWeekField, workingHoursADay, workingHoursADayField, minSprint, minSprintField,
                maxOverbudget, maxOverbudgetField, maxTime, maxTimeField, calcButton);

        titleGrid.getChildren().add(title);

        BorderPane homeBorderPane = new BorderPane();
        homeBorderPane.setTop(titleGrid);
        homeBorderPane.setLeft(homeGrid);

        scene1 = new Scene(homeBorderPane, 800, 450);

        //Окно прогресса

        ProgressBar pb = new ProgressBar();
        for (double i = 0; i < 1; i+=0.1) {
            pb.setProgress(i);
            if (pb.getProgress()==1)
                window.setScene(scene2);
            Thread.sleep(50);
        }

        middleScene = new Scene(pb, 800, 450);

        //Окно результатов

        GridPane answerBottomGrid1 = new GridPane();
        answerBottomGrid1.setPadding(new Insets(10, 10, 10, 10));
        answerBottomGrid1.setVgap(1);
        answerBottomGrid1.setHgap(2);
        GridPane answerBottomGrid2 = new GridPane();
        answerBottomGrid2.setPadding(new Insets(10, 10, 10, 10));
        answerBottomGrid2.setVgap(1);
        answerBottomGrid2.setHgap(2);

        TextArea calcResult = new TextArea();
        calcResult.setText("fsdfds");
        System.out.println(answer[0]);

        Label label2 = new Label();
        label2.setText("Хотите попробовать еще раз с другими данными?");
        GridPane.setConstraints(label2, 0, 0);

        Button againButton = new Button();
        againButton.setText("Да");
        againButton.setOnAction(e -> {
            boolean result = ConfirmBox.display("ATP",
                    "Попробовать еще?",
                    scene1, window);
        });
        GridPane.setConstraints(againButton, 0, 1);

        // Exit Functionality
        Button exitButton = new Button();
        exitButton.setText("Выход");
        exitButton.setOnAction(e -> closeProgram());
        GridPane.setConstraints(exitButton, 1, 1);

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        // Layout 2
        answerBottomGrid1.getChildren().add(label2);
        answerBottomGrid2.getChildren().addAll(againButton, exitButton);

        VBox footer = new VBox();
        footer.getChildren().addAll(answerBottomGrid1, answerBottomGrid2);

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(footer);
        borderPane.setTop(calcResult);
        borderPane.setPadding(new Insets(10, 10, 10, 10));

        scene2 = new Scene(borderPane, 800, 450);

        window.setScene(scene1);
        window.setTitle("APT");
        window.show();
    }

    private void isInt (Label name, TextField input, Button calcButton){
        try{
            int num = Integer.parseInt(input.getText());
            calcButton.setOnAction(e -> window.setScene(scene2));
        }catch (NumberFormatException e){
            ErrorAllert.display(name);
        }
    }

    public void closeProgram(){
        Boolean answer = ExitBox.display("APT", "Вы действительно хотите выйти?");
        if (answer)
            window.close();
    }

}
