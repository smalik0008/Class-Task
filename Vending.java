package vending;
abstract class machine{
    protected static int pepsi=1;
    protected static int dew=2;
    protected static int fanta=3;
    
    machine nextproduct;
    
    machine(machine nextproduct){
        this.nextproduct=nextproduct;
    }
    public void buy(int product,String tagline){
            nextproduct.buy(product, tagline);
    }
} 

class pepsi extends machine{
    pepsi(machine nextproduct){
        super(nextproduct);
    }
    public void buy(int product,String tagline){
        if(product==pepsi){
            System.out.println("PEPSI :"+ tagline);
        }
        else{
            super.buy(product, tagline);
        }
    }
}

class dew extends machine{
    dew(machine nextproduct){
        super(nextproduct);
    }
    public void buy(int product,String tagline)
    {
        if(product == dew){
            System.out.println("DEW :"+ tagline);
        }
        else{
            super.buy(product, tagline);
        }
    }
}

class fanta extends machine{
    fanta(machine nextproduct){
        super(nextproduct);
    }
    public void buy(int product,String tagline){
        if(product == fanta){
            System.out.println("FANTA :"+ tagline);
        }
        else{
            super.buy(product, tagline);
        }
    }
}
public class Vending {
    public static void main(String[] args) {
        machine buyobj=new pepsi(new dew(new fanta(null)));
        
        buyobj.buy(machine.pepsi, "pep tag");
        buyobj.buy(machine.dew, "dew tag");
        buyobj.buy(machine.fanta, "fan tag");
    }
}
