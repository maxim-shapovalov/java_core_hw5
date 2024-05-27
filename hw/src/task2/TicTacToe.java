package task2;
import java.io.FileOutputStream;
import java.io.IOException;

// Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
// и представляют собой, например, состояния ячеек поля для игры в крестикинолики,
// где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
// Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
// Записать в файл 9 значений так, чтобы они заняли три байта.
public class TicTacToe {
    public static void run() {
        int[] field = {1, 2, 0, 3, 2, 1, 0, 3, 1}; // Пример массива из 9 элементов

        // Создаем файл для записи
        try (FileOutputStream fos = new FileOutputStream("tic_tac_toe_field.dat")) {
            int packedValue = 0; // Инициализируем упакованное значение

            // Упаковываем значения в одно число
            for (int i = 0; i < 9; i++) {
                packedValue |= (field[i] & 0x03) << (i * 2); // Сдвигаем значения на 2 бита
            }

            // Записываем упакованное значение в файл
            fos.write(packedValue);
            System.out.println("Значения успешно записаны в файл tic_tac_toe_field.dat.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
