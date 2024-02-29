public class Main {
    public static void main(String[] args) {
        String arguments[] = {"-o", "-p", "-a", "-s", "-f"};
        FileOperation operation = new FileOperation();
        operation.readFile();

        for (int i = 0; i < args.length; i++) {
            if (arguments[4].equals(args[i])) {
                operation.viewStringStatistic();
                operation.viewIntStatistic();
                operation.viewFloatStatistic();
            }
            if (arguments[3].equals(args[i])) {
                operation.viewShortStatistic();
            }
        }
    }
}

/*
Java 17
*/
    /* Args:
     -o меняет путь для расположения конечных файлов
     -p задает префикс имен выходных файлов
     -a добавление текста в существующие файлы
     -s краткая статистика
     -f полная статистика


      Аргумент №0- -o
      Аргумент №1- -p
      Аргумент №2- -a
      Аргумент №3- -s
      Аргумент №4- -f
 */

