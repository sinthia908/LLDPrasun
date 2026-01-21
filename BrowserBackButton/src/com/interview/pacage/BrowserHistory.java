package com.interview.pacage;

/* * Design:
 * - Uses a doubly-linked list where each node represents a visited page
 * - Current pointer tracks the current position in history
 * - visit() creates new node and clears forward history
 * - back()/forward() move the pointer and return the URL*/

public class BrowserHistory {

    private BrowserNode current ;

    public BrowserHistory(String url){
    BrowserNode browserNode = new BrowserNode(url);
    this.current = browserNode;
    }

   public void visit(String url) {
       BrowserNode newNode = new BrowserNode("url");

       /**
        * Visit a new URL. This clears any forward history.
        * @param url the URL to visit
        */

       current.next = newNode;
       newNode.previous = current;

       // Move current pointer to the new node
       // This effectively clears forward history as current.next becomes null
       current = newNode;
   }


    /**
     * Go back to the previously visited page.
     * @return the URL of the previous page, or current URL if no previous page
     */

     public String back(){
         if ( current.previous != null){
             current = current.previous;
         }
         return current.url;
     }

    /**
     * Go forward to the next page if a back operation was done before.
     * @return the URL of the next page, or current URL if no forward history
     */


    public String forward(){
        if ( current.next != null){
            current = current.next;
        }
        return current.url;
    }


    /**
     * Get the current URL being viewed.
     * @return the current URL
     */
    public String getCurrentPage() {
        return current.url;
    }
}
