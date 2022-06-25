
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
   public int howMany( String stringa, String stringb ){
        // put all to lower case
        String lowerStringa = stringa.toLowerCase();
        String lowerStringb = stringb.toLowerCase();
        
        int count = 0;
        int aIndex = lowerStringb.indexOf(lowerStringa);
        // 
        while (aIndex !=-1){
            count = count + 1;
            aIndex = lowerStringb.indexOf(lowerStringa, aIndex + 1);
        }
        return count;
   }
    
   public void testing() {
        String dna = "ATGAACGAATTGAATC";
        String find = "yui";
        String dna1 = "ATAA";
        String find1 = "AA";
        
        // call function howMany for each
        int result1 = howMany(find, dna);
        int result2 = howMany(find1, dna1);
        // print how many
        // find int startIndex and check it it found it
       
        System.out.println("David 1 " + result1);
        System.out.println( "result " + result2);
       
        };
}
