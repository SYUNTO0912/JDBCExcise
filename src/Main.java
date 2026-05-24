import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("キーボードから整数を入力してください");
        System.out.println("1:データの追加");
        System.out.println("2:データの削除");
        System.out.println("3:データの取り出し");
        System.out.println("4:終了");
        Scanner scanner = new Scanner(System.in);
        int process_number;
        process_number = scanner.nextInt();
        if (process_number < 1 || 4 < process_number) {
            System.out.println("1~4の整数を入力してください");
        }
        else {
            Logic main_logic = new Logic(process_number);
            main_logic.choose_process();
        }
    }
}
