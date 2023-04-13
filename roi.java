import java.util.*;
import java.text.DecimalFormat;

class Equipment{
    String name;
    double gain;
    double cost;
    double roi;

    public Equipment(String name, double gain, double cost, double roi) {
        this.name = name;
        this.gain = gain;
        this.cost = cost;
        this.roi = roi;
    }


    public String getName() {
        return name;
    }
    public double getGain() {
        return gain;
    }
    public double getCost() {
        return cost;
    }
    public double getRoi() {
        return roi;
    }
}

class Main{
    public static void main (String[] args) {
        List<Equipment> list=new LinkedList<Equipment>();
        String name;
        double cost;
        double gain;
        double roi;
        Scanner sc=new Scanner(System.in);

        int option=1;
        int index=1;


        while (option==1){
            System.out.println("Entry "+(index)+": ");
            System.out.print("Name of equipment: ");
            name= sc.nextLine();
            System.out.print("Gain of equipment: ");
            gain= sc.nextDouble();
            sc.nextLine();
            System.out.print("Cost of equipment: ");
            cost= sc.nextDouble();
            sc.nextLine();

            roi= (gain-cost)/cost;


            list.add(new Equipment(name, gain, cost,roi));
            System.out.println(" ");
            System.out.print("Press 1 to enter another piece of equipment. Press any other number to calculate entries.");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            index = index+1;
        }


        int n = list.size();
        Equipment temp;
        double key;
        for (int i = 1; i < n; ++i) {
            temp = list.get(i);
            key = temp.getRoi();
            int j = i - 1;

            while (j >= 0 && list.get(j).getRoi() < key) {
                list.set(j+1, list.get(j));
                j = j - 1;
            }
            list.set(j+1, temp);
        }

        DecimalFormat format1 = new DecimalFormat("#.00");
        System.out.println();
        System.out.println("Equipment"+ "\t"+"Gain"+ "\t"+"Cost"+ "\t"+"ROI");
        for(int j=0; j < n; j++) {
            System.out.println(list.get(j).getName() + "     " + format1.format(list.get(j).getGain()) + "     " +format1.format(list.get(j).getCost()) + "     "+ format1.format(list.get(j).getRoi()));
        }
        System.out.println();
        System.out.println("Thank you.");
    }
}
