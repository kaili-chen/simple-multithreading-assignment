package proj.managers;

import proj.classes.*;
import java.util.*;

public class MedicineManager {

    private ArrayList<Medicine> medicineList = new ArrayList<Medicine>();

    public MedicineManager() {
        //initalise data
        medicineList.add(new Medicine(1, "Acetaminophen", 500.0, "mg", 100, "pill"));
        medicineList.add(new Medicine(2, "Paracetamol", 500.0, "mg", 100, "pill"));
        medicineList.add(new Medicine(3, "Guaifenesin", 600.0, "mg", 100, "pill"));
        medicineList.add(new Medicine(4, "Dextromethorphan", 110.0, "ml", 50, "bottle"));
        medicineList.add(new Medicine(5, "Oxymetazoline HCl 0.05%", 30.0, "ml", 50, "spray"));
        medicineList.add(new Medicine(6, "Naprozen Sodium", 200.0, "mg", 100, "tablet"));
    }

}