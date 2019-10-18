import services.GenerateField;
import services.MineSweeperService;

import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        int row = 10;
        int col = 10;
        int totalMineCount = 10;
        boolean isContinue = true;

        GenerateField generateField =
                new GenerateField(row, col, totalMineCount);
        MineSweeperService mineSweeperService =
                new MineSweeperService(generateField.createField());
        mineSweeperService.print(isContinue);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("ROW 값을 입력하세요(1~10) : ");
            int requestedRow = scanner.nextInt();

            System.out.print("COL 값을 입력하세요(1~10) : ");
            int requestedCol = scanner.nextInt();

            isContinue = mineSweeperService.isCheckSpot(requestedRow, requestedCol);
            mineSweeperService.print(isContinue);
        } while(isContinue);
    }
}
