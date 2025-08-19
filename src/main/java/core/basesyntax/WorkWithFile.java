package core.basesyntax;

import java.io.*;

public class WorkWithFile {
    public void getStatistic(String fromFileName, String toFileName) {
        try {
            FileReader fileReader = new FileReader(fromFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(toFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int supply = 0;
            int buy = 0;

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String operation = parts[0];
                int amount = Integer.parseInt(parts[1]);

                if (operation.equals("supply")) {
                    supply += amount;
                } else if (operation.equals("buy")) {
                    buy += amount;
                }
            }

            int result = supply - buy;

// Пишемо результат у файл
            bufferedWriter.write("supply," + supply);
            bufferedWriter.newLine();
            bufferedWriter.write("buy," + buy);
            bufferedWriter.newLine();
            bufferedWriter.write("result," + result);
            bufferedWriter.newLine();

// Закриваємо writer
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file doesn't run", e);
        } catch (IOException e) {
            throw new RuntimeException("file doesn't run", e);
        }
    }
}
