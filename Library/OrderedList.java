package library;

abstract class OrderedList extends List{

    public ListNode find(Object newData){
        ListNode current = head;
        while (current != null){
            if (compare(newData, current.getData()) == 0){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public ListNode remove(Object newData){

        //If the we want to delete the head node
        if (compare(head.getData(), newData) == 0){
            ListNode returnValue = head;
            head = head.getNext();
            returnValue.setNext(null); // free up node's next link (else it's stuck in limbo)
            System.out.println("Node has been removed.");
            return returnValue;
        }

        //If the node we want to delete is not the head node
        //We create two reference nodes to go through
        ListNode current = head.getNext();
        ListNode previous = head;

        while (current != null){
            if (compare(newData, current.getData()) == 0){
                if (current.getNext() == null) { // if found node is the last
                    lastNode = previous;
                }
                previous.setNext(current.getNext());
                current.setNext(null); // free up node's next link (else it's stuck in limbo)
                System.out.println("Node has been removed.");
                return current;
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    public boolean insert(Object newData){
        //We only insert if the node doesn't exist yet
        if (find(newData) != null){
            System.out.println("This data already exists.");
            return false;
        } else {
            ListNode inserting = new ListNode(newData, null);
            ListNode previous = null;
            ListNode current = head;

            //Traverse through the list until we find the right place for the new node
            while (current != null && compare(current.getData(), newData) < 0){
                previous = current;
                current = current.getNext();
            }

            //If our new node's place is the first place
            if (previous == null){
                head = inserting;
            } else {
                previous.setNext(inserting);
            }
            inserting.setNext(current);
            return true;
        }
    }

    @Override
    public void insertAtFront(Object newData){
        System.out.println("This method is not available.");
    }

    @Override
    public void insertAtBack(Object newData){
        System.out.println("This method is not available.");
    }

    @Override
    public Object removeFront(){ System.out.println("This method is not available."); return null;}

    @Override
    public Object removeBack(){ System.out.println("This method is not available."); return null;}

    protected abstract int compare(Object obj1, Object obj2);

    protected abstract void printAll();
}
