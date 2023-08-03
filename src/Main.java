import java.util.Scanner;

class Calc {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение из двух чисел: ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int x;
        int y;
        String oper;
        String result;
        boolean rim;
        String[] operands = expression.split("[*/+-]");
        if (operands.length != 2) throw new Exception("Больше 2 чисел!");
        oper = detectOperation(expression);
        if (oper == null) throw new Exception("Действие невыполнимо!");
        if (Rome.rim(operands[0]) && Rome.rim(operands[1])) {
            x = Rome.convarab(operands[0]);
            y = Rome.convarab(operands[1]);
            rim = true;
        }
        else if (!Rome.rim(operands[0]) && !Rome.rim(operands[1])) {
            x = Integer.parseInt(operands[0]);
            y = Integer.parseInt(operands[1]);
            rim = false;
        }
        else {
            throw new Exception("Только для чисел одного формата!");
        }
        if (x > 10 || y > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arab = calc(x, y, oper);
        if (rim) {
            if (arab < 0) {
                throw new Exception("Только положительные римские числа!");
            }
            result = Rome.convrim(arab);
        } else {
            result = String.valueOf(arab);
        }
        return result;
    }

    static String detectOperation(String expression) {
        if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else return null;
    }

    static int calc(int x, int y, String oper) {

        return switch (oper) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            default -> x / y;
        };
    }

}

class Rome {
    static String[] rimarr = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static boolean rim(String val) {
        for (String s : rimarr) {
            if (val.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static int convarab(String roman) {
        for (int i = 0; i < rimarr.length; i++) {
            if (roman.equals(rimarr[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convrim(int arab) {
        return rimarr[arab];
    }

}
