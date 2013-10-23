/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

/**
 *
 * @author mbaxkak4
 */
public class WordCount {
   private int count=0; 
  //  public WordCount
 public WordCount (String string){
     
     String[] words = string.split(" ");  // split input string on space

for (int i = 0; i < words.length; i++) {  // iterate over array
    
        count++;
    
}

}
 public int getCount(){
 
 
 return count;}
}
