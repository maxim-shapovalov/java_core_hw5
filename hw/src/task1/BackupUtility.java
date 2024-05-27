package task1;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


// �������� �������, ��������� ��������� ����� ���� ������ � ����������(��� �������������)
// �� ����� ��������� ����� ./backup
public class BackupUtility {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� ���� � ������� �����: ");
        String targetDirectoryPath = scanner.nextLine();

        // ������� ����� backup � ��������� ������� ����������
        String backupDirectoryPath = targetDirectoryPath + File.separator + "backup";
        File backupFolder = new File(backupDirectoryPath);
        if (!backupFolder.exists()) {
            backupFolder.mkdir();
        }

        // �������� ������ ������ � ������� ����������
        File[] files = new File(targetDirectoryPath).listFiles();

        // �������� ����� � ����� backup
        for (File file : files) {
            if (file.isFile()) {
                try {
                    Files.copy(file.toPath(), new File(backupDirectoryPath, file.getName()).toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("���� " + file.getName() + " ���������� � ����� backup.");
                } catch (IOException e) {
                    System.err.println("������ ��� ����������� ����� " + file.getName() + ": " + e.getMessage());
                }
            }
        }
    }



}
