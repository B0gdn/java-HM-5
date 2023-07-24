import java.util.*;


public class Main {

    /*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
    отвечающие фильтру. Критерии фильтрации можно хранить в Map.
    Например:
            “Введите цифру, соответствующую необходимому критерию:
            1 - ОЗУ
            2 - Объем ЖД
            3 - Операционная система
            4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
    Работу сдать как обычно ссылкой на гит репозиторий
    Частые ошибки:
            1. Заставляете пользователя вводить все существующие критерии фильтрации
            2. Невозможно использовать более одного критерия фильтрации одновременно
            3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
            4. Работа выполнена только для каких то конкретных ноутбуков,
            и если поменять характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
    */
    public static void main(String[] args) {

        Set<Notepad> set = new HashSet<>();

        Notepad notepad1 = new Notepad("MSI", 16, 2000, "Windows", "Black");
        Notepad notepad2 = new Notepad("Asus", 32, 512, "Windows", "White");
        Notepad notepad3 = new Notepad("Acer", 8, 512, "Windows", "Red");
        Notepad notepad4 = new Notepad("Huawei", 4, 1000, "Windows", "Black");
        Notepad notepad5 = new Notepad("Huawei", 8, 512, "Windows", "Silver");
        Notepad notepad6 = new Notepad("Asus", 4, 256, "Windows", "Black");
        Notepad notepad7 = new Notepad("Asus", 4, 256, "Windows", "Black");
        Notepad notepad8 = new Notepad("Acer", 2, 2000, "Windows", "White");
        Notepad notepad9 = new Notepad("MSI", 2, 1000, "Windows", "Black");
        Notepad notepad10 = new Notepad("MSI", 8, 512, "Windows", "Red");
        Notepad notepad11 = new Notepad("Apple", 16, 1000, "Mac", "Black");

        set.add(notepad1);
        set.add(notepad2);
        set.add(notepad3);
        set.add(notepad4);
        set.add(notepad5);
        set.add(notepad6);
        set.add(notepad7);
        set.add(notepad8);
        set.add(notepad9);
        set.add(notepad10);
        set.add(notepad11);

        Map<Integer, Notepad> map = new HashMap<>();


        Scanner in = new Scanner(System.in);
        int findRam = 0;
        int findHdd = 0;
        String findOs = "";
        String findColor = "";
        for (Notepad find: set) {
            if (find.ram > findRam) {
                findRam = find.ram;
            }
            if (find.hdd > findHdd) {
                findHdd = find.hdd;
            }
        }

        boolean flag = true;

        while (flag == true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                    "            1 - ОЗУ\n" +
                    "            2 - Объем ЖД\n" +
                    "            3 - Операционная система\n" +
                    "            4 - Цвет\n" +
                    "            5 - Применить");
            int selection = in.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("ОЗУ: ");
                    findRam = in.nextInt();
                    break;
                case 2:
                    System.out.println("Объем ЖД: ");
                    findHdd = in.nextInt();
                    break;
                case 3:
                    System.out.println("Операционная система: ");
                    findOs = in.next();
                    break;
                case 4:
                    System.out.println("Цвет: ");
                    findColor = in.next();
                    break;
                case 5:
                    System.out.println("Результат: ");
                    Notepad findNotepad = new Notepad(findRam, findHdd, findOs, findColor);
                    System.out.println(findNotepad);
                    for (Notepad find: set) {
                        if (find.equals(findNotepad)) {
                            map.put(find.uid ,find);
                        }
                    }
                    System.out.println(map);
                    flag = false;
                    break;
            }
        }



    }
}