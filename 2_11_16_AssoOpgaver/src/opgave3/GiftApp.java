/**
 *
 */
package opgave3;

/**
 * @author Kristian
 */
public class GiftApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Person kristian = new Person("Kristian", 29);
        Person julemanden = new Person("Julemanden", 85);
        Person jesus = new Person("Jesus", 37);

        Gift socks = new Gift("Gamle sokker fra den lokale genbrug", julemanden);
        socks.setPrice(5);
        Gift ipad = new Gift("iPad", kristian);
        ipad.setPrice(2000);
        Gift sofa = new Gift("Sofa fra IKEA", jesus);
        sofa.setPrice(5000);

//        julemanden.gives(socks, kristian);
//        jesus.gives(sofa, kristian);
//      System.out.println("Folk der elsker mig: " + kristian.getGivers().toString());
        
        kristian.recieves(ipad);
        kristian.recieves(socks);
        kristian.recieves(sofa);
        
        System.out.println("Pris for gaver i alt: " + kristian.getGiftPrices() + "kr.");
        
        System.out.println("Folk der elsker mig:");
        for (Gift g : kristian.getGifts()) {
            System.out.println(g.getGiver().toString() + " som gav mig: " + g.getDescription());
        }

        System.out.println(kristian.mostExpensiveGift().getGiver().toString()
            + " elsker mig mest fordi " + kristian.mostExpensiveGift().getDescription()
            + " var dyrest og kostede " + kristian.mostExpensiveGift().getPrice() + " kr.");

    }

}
