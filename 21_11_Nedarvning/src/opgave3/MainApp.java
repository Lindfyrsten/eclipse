package opgave3;

import service.Service;

public class MainApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Service.createMekaniker("Per", "Skolegade 12", 1997, 115);
        Service.createVærkfører("Ole", "Gaden 1", 185, 2015, 50);
        Service.createSynsmand("Martin", "Hjemløs", 125, 1999);
        Service.createArbejdsdreng("Lilleper", "DWDW", 15);
        
        Service.getSynsmænd().get(0).setAntalSyn(7);
        System.out.println(Service.samletLoen(Service.getAnsatte()));
    }

}
