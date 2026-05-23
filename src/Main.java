import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("キーボードから整数を入力してください");
        System.out.println("1:データの追加");
        System.out.println("2:データの削除");
        System.out.println("3:データの取り出し");
        System.out.println("4:終了");
        Scanner scanner = new Scanner(System.in);
        int procces_number;
        procces_number = scanner.nextInt();
        if (procces_number < 1 && 4 < procces_number) {
            System.out.println("1~4の整数を入力してください");
        }
        else {
            Logic mian_logic = new Logic(procces_number);

        }
    }
}
