
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
   public String findSimpleGene( String dna, int startCodon, String stopCodon ){
        String g = dna.toLowerCase();
        String stop = stopCodon.toLowerCase();
        while(startCodon != -1){
            int endIndex = g.indexOf(stop, startCodon + 3);
            if(endIndex < 0){
                return "";
            }
            
            if((endIndex - startCodon) % 3 == 0){
                String temp = dna.substring(startCodon, endIndex + 3);
                return temp;
                
            }
            
            startCodon = endIndex;
        }
        return "";
   }
   
   // function findGene which call findSimpleGene
   public String findGene(String dna, int startIndex){
        
        String taaGene = findSimpleGene(dna, startIndex, "TAA");
        String tagGene = findSimpleGene(dna, startIndex, "TAG");
        String tgaGene = findSimpleGene(dna, startIndex, "TGA");
        
        String gene = "";
        int taaLength = taaGene.length();
        int tagLength = tagGene.length();
        if( taaLength == 0 || tagLength > 0 && taaLength > tagLength){
            gene = tagGene;
        } else { gene = taaGene;
        }
        if( gene.length() == 0 || tgaGene.length() > 0 && gene.length() > tgaGene.length()){
            gene = tgaGene;
        }
        return gene;
   }
   
   // function which call findGene and then count how many genes is in dna
   public int countGene(String dna){
       int count = 0;
       int startIndex = dna.indexOf("atg");
       while(startIndex != -1){
           //call findGene
           String gene = findGene(dna, startIndex);
           //update count
           if(gene.length() > 0){
               count = count + 1;
            }
           // update position
           int position = startIndex + gene.length();
           startIndex = dna.indexOf("atg", position);
           // update startIndex
        }
       return count;
   }
   
   public void testing() {
        String dna = "ookjeeeeeeeeeeeeeeeeeeeee";
        String dna1 = "ookjfoATGoooTaaTiiOinTaaEuuATGMooMooTagMooATGMooMtaAooTga";
        
        // find int startIndex and check it it found it
        String dnaLowerCase = dna.toLowerCase();
        
        // call findSimpleGene( for each codon)
        int count = countGene(dnaLowerCase);
        
        System.out.println("Count for gene is " + count);
       
        };
}
