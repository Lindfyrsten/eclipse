package opgave2;

import service.Service;

public class MainApp {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Service.createMekaniker("Per", "Skolegade 12", 1997, 115);
        Service.createVærkfører("Ole", "Gaden 1", 1865, 185, 2015, 50);

        System.out.println(Service.getPersoner().toString());

        System.out.println(Service.samletLoen(Service.getPersoner()));
    }
    
}
