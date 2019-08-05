package library;

public class IntegerOrdList extends OrderedList {
	//compare function defined below 
    @Override
    protected int compare(Object obj1, Object obj2){
        return ((Integer)obj1).intValue() - ((Integer)obj2).intValue();
    }

}
