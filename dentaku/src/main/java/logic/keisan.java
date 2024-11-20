package logic;

import java.util.ArrayList;

public class keisan {
    public double keisan(String display) {
        String[] keisan = display.split(" ");
        ArrayList<Double> kazu = new ArrayList<>();
        ArrayList<String> kigo = new ArrayList<>();
        
        for (int i = 0; i < keisan.length; i++) {
            try {
                kazu.add(Double.parseDouble(keisan[i]));
            } catch (NumberFormatException e) {
                kigo.add(keisan[i]);
            }
        }
        for (int i = 0; i < kigo.size(); i++) {
            if (kigo.get(i).equals("*") || kigo.get(i).equals("/")) {
                double num1 = kazu.get(i);
                double num2 = kazu.get(i + 1);
                double keka = 0;
                if (kigo.get(i).equals("*")) {
                    keka = num1 * num2;
                } else if (kigo.get(i).equals("/")) {
                    keka = num1 / num2;
                }
                kazu.set(i, keka);
                kazu.remove(i + 1);
                kigo.remove(i);
                i--; 
            }
        }
        for (int i = 0; i < kigo.size(); i++) {
            double num1 = kazu.get(i);
            double num2 = kazu.get(i + 1);
            double keka = 0;

            if (kigo.get(i).equals("+")) {
                keka = num1 + num2;
            } else if (kigo.get(i).equals("-")) {
                keka = num1 - num2;
            }
            kazu.set(i, keka);
            kazu.remove(i + 1);
            kigo.remove(i);
            i--;
        }
        return kazu.get(0);
    }
}
