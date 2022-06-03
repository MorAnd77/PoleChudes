import java.util.Scanner;

public class Main {

    static String word = "Спортсмен";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Спортсмен ---------
        System.out.println("Угадай слово");
        int lengthWord = word.length(); //  вычисляем количество символов в слове
        String maskWord = "-".repeat(lengthWord); //   и заменяем на прочерки
        System.out.println(maskWord);
        // ---------
        // с
        // с----с---
        // о
        // с-о--с---
        do {
            System.out.println("Введите букву");
            char c = input.next().charAt(0);
            // a 2
            //w -1
            if (word.indexOf(c) >= 0) {
                System.out.println("Удача");
                for (char elem : word.toCharArray()) {
                    if (elem == c) {
                        maskWord = replaceMaskLetter(c, maskWord);
                    }
                }
                System.out.println(maskWord);
            } else {
                System.out.println("Промах, попробуй ещё раз");
                System.out.println(maskWord);

            }

        } while (maskWord.contains("-"));
        System.out.println("Поздравляем Вы выиграли");
    }
    // с----с--- п
    // сп---с---
    public static String replaceMaskLetter(char c, String maskWord) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                str.append(c);
            } else if (maskWord.charAt(i) != '-') {
                str.append(maskWord.charAt(i));
            } else {
                str.append("-");
            }
        }
        return str.toString();
    }
}
