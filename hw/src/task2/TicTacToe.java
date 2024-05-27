package task2;
import java.io.FileOutputStream;
import java.io.IOException;

// ������������, ��� ����� � �������� ������� �� 9 ��������� ����� ��������[0, 3],
// � ������������ �����, ��������, ��������� ����� ���� ��� ���� � ��������������,
// ��� 0 � ��� ������ ����, 1 � ��� ���� � ���������, 2 � ��� ���� � �������, 3 � ��������� ��������.
// ����� ������������� �������� ������� � ����� ����� ���� int �� ���� 3�3.
// �������� � ���� 9 �������� ���, ����� ��� ������ ��� �����.
public class TicTacToe {
    public static void run() {
        int[] field = {1, 2, 0, 3, 2, 1, 0, 3, 1}; // ������ ������� �� 9 ���������

        // ������� ���� ��� ������
        try (FileOutputStream fos = new FileOutputStream("tic_tac_toe_field.dat")) {
            int packedValue = 0; // �������������� ����������� ��������

            // ����������� �������� � ���� �����
            for (int i = 0; i < 9; i++) {
                packedValue |= (field[i] & 0x03) << (i * 2); // �������� �������� �� 2 ����
            }

            // ���������� ����������� �������� � ����
            fos.write(packedValue);
            System.out.println("�������� ������� �������� � ���� tic_tac_toe_field.dat.");
        } catch (IOException e) {
            System.err.println("������ ��� ������ � ����: " + e.getMessage());
        }
    }
}
