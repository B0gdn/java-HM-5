import java.util.Objects;

public class Notepad {
    /*“Введите цифру, соответствующую необходимому критерию:
            1 - ОЗУ
            2 - Объем ЖД
            3 - Операционная система
            4 - Цвет …
     */
    static int count;
    int uid;
    String brand;
    int ram;
    int hdd;
    String system;
    String color;

    public Notepad(String brand, int ram, int hdd, String system, String color) {
        this.uid = count + 1;
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.system = system;
        this.color = color;
    }

    public Notepad(int ram, int hdd, String system, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.system = system;
        this.color = color;
    }

    @Override
    public String toString() {
        return  uid + " : " + brand +
                ", ram = " + ram +
                ", hdd = " + hdd +
                ", OS = '" + system + '\'' +
                ", color = '" + color + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Notepad) return false;
        Notepad notepad = (Notepad) o;
        if (notepad.system == "" && notepad.color == "") {
            return ram >= notepad.ram && hdd >= notepad.hdd;
        } else if (notepad.system == "") {
            return ram >= notepad.ram && hdd >= notepad.hdd && brand.equalsIgnoreCase(notepad.brand);
        } else if (notepad.color == "") {
            return ram >= notepad.ram && hdd >= notepad.hdd && system.equalsIgnoreCase(notepad.system);
        } else {
            return ram >= notepad.ram && hdd >= notepad.hdd
                    && system.equalsIgnoreCase(notepad.system) && brand.equalsIgnoreCase(notepad.brand);
        }
    }



    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, hdd, system);
    }
}
