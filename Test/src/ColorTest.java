class Prefix {
    int val;
    String desc;

    Prefix(int value, String description) {
        val = value;
        desc = description;
    }
}

public class ColorTest {
    final static String CSI = "\u001b[";
    final static String RESET = CSI + "0m";

    final static Prefix[] prefixes = {
        new Prefix(0, " 0 normal"),
        new Prefix(1, " 1 bold/increased intensity"),
        new Prefix(3, " 3 italic on"),
        new Prefix(7, " 7 image negative"),
        new Prefix(8, " 8 conceal"),
        new Prefix(51, "51 framed"),
        new Prefix(9, " 9 crossed out (strike)"),
        new Prefix(4, " 4 underlined, single"),
        new Prefix(21, "21 undeline double")
    };
    final static Integer[] colors = {
        30, // normal
        40, // background
        90, // high intensity normal
        100 // high intensity background
    };

    static void test16() {
        int color;

        System.out.printf("==== ATTRIBUTES ====\n");
        System.out.printf("     %-28s", "Changing fg, default bg");
        System.out.printf("%-28s", "Default fg, changing bg");
        System.out.printf("%-28s", "High fg, default bg");
        System.out.printf("%s%n", "Default fg, high bg");
        for (Prefix prefix : prefixes) {
            System.out.printf("%03d: ", prefix.val);
            for (Integer command : colors) {
                for (color = 0; color <= 7; color++) {
                    System.out.printf(CSI + "%d;%dm{x}", prefix.val, command + color);
                }
                System.out.print(RESET + "    ");
            }
            System.out.printf(RESET + " // %s%n", prefix.desc);
        }
        System.out.println(RESET);
    }

    static void test16matrix() {
        System.out.printf("==== 16 COLOR MATRIX ====\n");
        System.out.printf("     %-28s", "Normal fg, Normal bg");
        System.out.printf("%-28s", "Normal fg, high bg");
        System.out.printf("%-28s", "High fg, default bg");
        System.out.printf("%s%n", "High fg, high bg");
        for (int fg = 0; fg < 8; fg++) {
            System.out.printf("%03d: ", fg);
            for (int bg = 0; bg < 8; bg++) {
                System.out.printf(CSI + "%d;%dm{x}", 30 + fg, 40 + bg);
            }
            System.out.print(RESET + "    ");
            for (int bg = 0; bg < 8; bg++) {
                System.out.printf(CSI + "%d;%dm{x}", 30 + fg, 100 + bg);
            }
            System.out.print(RESET + "    ");
            for (int bg = 0; bg < 8; bg++) {
                System.out.printf(CSI + "%d;%dm{x}", 90 + fg, 40 + bg);
            }
            System.out.print(RESET + "    ");
            for (int bg = 0; bg < 8; bg++) {
                System.out.printf(CSI + "%d;%dm{x}", 90 + fg, 100 + bg);
            }
            System.out.println(RESET);
        }
        System.out.println(RESET);
    }

    /* Java port of 256colors2.pl, http://www.frexx.de/xterm-256-notes */
    static void test256() {
        int color;
        // first the system ones:
        System.out.print("===== 256 COLORS =====\n");
        System.out.print("System colors:\n");
        for (color = 0; color < 16; color++) {
            System.out.printf(CSI + "38;5;%dm{x}", color);
        }
        System.out.println(RESET);
        for (color = 0; color < 16; color++) {
            System.out.printf(CSI + "48;5;%dm{x}", color);
        }
        System.out.println(RESET);

        // now the color cube
        System.out.print("Color cube, 6x6x6:\n");
        for (int green = 0; green < 6; green++) {
            for (int red = 0; red < 6; red++) {
                for (int blue = 0; blue < 6; blue++) {
                    color = 16 + (red * 36) + (green * 6) + blue;
                    System.out.printf(CSI + "38;5;%dm{x}", color);
                }
                System.out.print(RESET + " ");
            }
            System.out.print("\n");
        }
        for (int green = 0; green < 6; green++) {
            for (int red = 0; red < 6; red++) {
                for (int blue = 0; blue < 6; blue++) {
                    color = 16 + (red * 36) + (green * 6) + blue;
                    System.out.printf(CSI + "48;5;%dm   ", color);
                }
                System.out.print(RESET + " ");
            }
            System.out.print("\n");
        }

        // now the grayscale ramp
        System.out.print("Grayscale ramp:\n");
        for (color = 232; color < 256; color++) {
            System.out.printf(CSI + "38;5;%dm{x}", color);
        }
        System.out.println(RESET);
        for (color = 232; color < 256; color++) {
            System.out.printf(CSI + "48;5;%dm   ", color);
        }

        System.out.println(RESET + "\n");
    }

    public static void main(String[] args) {
        test16();
        test16matrix();
        test256();
    }
}
