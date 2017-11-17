/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        ListNode temp = A;
        int count = findSize(temp);
        if(count == 0 || count ==1 ) return A;
        
        
        ListNode prev = temp;
        ListNode start = temp;
        ListNode cur = temp;
        int half = count/2;
        
		// Get the half count
        while(half!=0){
            prev = cur;
            cur = cur.next;
            half --;
        }
        prev.next = null;
        ListNode list1 = start;
        ListNode list2= cur;
        list2 = reverseList(list2);
        
        subtractAndFill(list1,list2);
        list2 = reverseList(list2);
        
        
        temp = list1;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = list2;
        
        A = list1;
        //print(list1);
        //print(list2);
        return A;
    }
    
	
	// Reverses the linked list
    public ListNode reverseList(ListNode list){
        ListNode prevNode = null,nextNode=null, curNode = list;
        while(curNode!=null){
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        
        list = prevNode;
        
        return list;
        
    }
    
	
	// Subtracts : nodes of list2 - nodes of list1 and fills it to list1
    void subtractAndFill(ListNode list1, ListNode list2){
        ListNode temp1 = list1, temp2 = list2;
        
        while(temp1!=null){
            temp1.val = temp2.val - temp1.val;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
    }
    
    int findSize(ListNode A){
        int count = 0;
        ListNode temp = A;
        while(temp.next!=null){ 
            count ++;
            temp = temp.next;
        }
        count ++; // Increment the count for the last node

        return count;
        
    }
    
    //Printing the list
    void print(ListNode X){
        
        ListNode temp = X ;
        while(temp.next!=null){
            System.out.println("Temp = "+temp.val);
            temp = temp.next;
           
        }
        
        System.out.println("temp = "+temp.val);
    }
    
    
        
}

