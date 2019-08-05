package library;


public class StudentRecordOrdList extends OrderedList{
	//compare method defined below 
    @Override
    protected int compare(Object student1, Object student2){
        String fullName1, fullName2;
        fullName1 = ((StudentRecord)student1).surname + ((StudentRecord)student1).name;
        fullName2 = ((StudentRecord)student2).surname + ((StudentRecord)student2).name;
        return fullName1.compareTo(fullName2);
    }
   //printAll method defined below 
    @Override
    public void printAll(){
        ListNode current = head;
        System.out.println("List of students:");
        System.out.println("----------------------------");
        do
        	if(current == null) {
        		System.out.println("null");
        	}
        	else {
        		System.out.println(current.getData().toString());
                current = current.getNext();
        	}
        while(current != null);
        }
    }

