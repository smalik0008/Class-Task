package association.composton.aggregation;
//class p{
//    books obj;
//    void getdetails(){
//        obj=new books();
//    }
//}
class p{
    books obj;
    void getdetails(books ref){
        obj=ref;
    }
}
class books extends p{
    void bookname(){
//        abc
    }
}
public class AssociationCompostonAggregation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        p obj1=new p();
        obj1.getdetails(new books());
    }
}
