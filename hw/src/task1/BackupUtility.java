package task1;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


// Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
// во вновь созданную папку ./backup
public class BackupUtility {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к целевой папке: ");
        String targetDirectoryPath = scanner.nextLine();

        // Создаем папку backup в указанной целевой директории
        String backupDirectoryPath = targetDirectoryPath + File.separator + "backup";
        File backupFolder = new File(backupDirectoryPath);
        if (!backupFolder.exists()) {
            backupFolder.mkdir();
        }

        // Получаем список файлов в текущей директории
        File[] files = new File(targetDirectoryPath).listFiles();

        // Копируем файлы в папку backup
        for (File file : files) {
            if (file.isFile()) {
                try {
                    Files.copy(file.toPath(), new File(backupDirectoryPath, file.getName()).toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Файл " + file.getName() + " скопирован в папку backup.");
                } catch (IOException e) {
                    System.err.println("Ошибка при копировании файла " + file.getName() + ": " + e.getMessage());
                }
            }
        }
    }



}
