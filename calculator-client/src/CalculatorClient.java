import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CalculatorClient extends JFrame {

    private JTextField firstNumber, secondNumber, result, ageField;
    private JComboBox<String> operation, genderBox;
    private JButton calculate;

    public CalculatorClient() {
        setTitle("Calculator Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 20, 20));

        Color c = new Color(230, 230, 250);
        getContentPane().setBackground(c);

        JLabel firstNumberLabel = new JLabel("Enter First Number:");
        firstNumber = new JTextField();

        JLabel secondNumberLabel = new JLabel("Enter Second Number:");
        secondNumber = new JTextField();

        JLabel operationLabel = new JLabel("Select Operation:");
        operation = new JComboBox<>(new String[]{"Add", "Subtract", "Multiply", "Divide",
        "Modulus", "Power", "Root", "Average", "BMI", "BMR"});

        JLabel ageLabel = new JLabel("Enter Age:");
        ageField = new JTextField();

        JLabel genderLabel = new JLabel("Enter Gender:");
        genderBox = new JComboBox<>(new String[]{"Male", "Female"});

        JLabel resultLabel = new JLabel("Result:");
        result = new JTextField();
        result.setEditable(false);

        calculate = new JButton("Calculate");
        calculate.addActionListener(this::calculate);

        add(firstNumberLabel);
        add(firstNumber);
        add(secondNumberLabel);
        add(secondNumber);
        add(operationLabel);
        add(operation);
        add(ageLabel);
        add(ageField);
        add(genderLabel);
        add(genderBox);
        add(resultLabel);
        add(result);
        add(new JLabel());
        add(calculate);
    }

    private void calculate(ActionEvent e) {
        try {
            double number1 = Double.parseDouble(firstNumber.getText());
            double number2 = Double.parseDouble(secondNumber.getText());
            String op = ((String) operation.getSelectedItem());

            String urlStr;

            switch (op) {
                case "Add":
                case  "Subtract":
                case "Multiply":
                case "Divide":
                case "Modulus":
                case "Average":
                    urlStr = String.format(
                            "http://localhost:8080/calculator/%s?number1=%s&number2=%s",op.toLowerCase(),number1,number2);
                    break;

                case "Power":
                    urlStr = String.format(
                            "http://localhost:8080/calculator/power?base=%s&exponent=%s",number1,number2);
                    break;

                case "Root":
                    urlStr = String.format(
                            "http://localhost:8080/calculator/root?number=%s",number1);
                    break;

                case "BMI":
                    urlStr = String.format(
                        "http://localhost:8080/calculator/bmi?height=%s&weight=%s",number1,number2);
                    break;

                case "BMR":
                    int age = Integer.parseInt(ageField.getText());
                    String gender = ((String) genderBox.getSelectedItem()).toLowerCase();
                    urlStr = String.format(
                            "http://localhost:8080/calculator/bmr?height=%s&weight=%s&age=%d&gender=%s",number1,number2, age, gender);
                    break;

                default:
                    throw new IllegalArgumentException("Unknown Operation Selected");
            }

            String response = sendGet(urlStr);
            result.setText(response.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers (and age)",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String sendGet(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        conn.disconnect();
        return response.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorClient().setVisible(true));
    }
}
