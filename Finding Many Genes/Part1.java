
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
   public String findSimpleGene( String dna, int startCodon, String stopCodon ){
        String g = dna.toLowerCase();
        String stop = stopCodon.toLowerCase();
        int endIndex = g.indexOf(stop, startCodon + 3);
        while(endIndex != -1){
            
            if(endIndex < 0){
                return "";
            }
            
            if((endIndex - startCodon) % 3 == 0){
                System.out.println("David found " + endIndex);
                String temp = dna.substring(startCodon, endIndex + 3);
                System.out.println("David found " + temp);
                return temp;
                
            }
            
            endIndex = g.indexOf(stop, endIndex + 1);
        }
        return "";
    }
    
   public void testing() {
        String dna = "AATGCTAACTAGCTGACTAAT";
        String num = "01234567890123456";
        // find int startIndex and check it it found it
        String dnaLowerCase = dna.toLowerCase();
        int startIndex = dnaLowerCase.indexOf("atg");
        System.out.println("David startIndex is " + startIndex);
        // call findSimpleGene( for each codon)
        String taaGene = findSimpleGene(dna, startIndex, "TAA");
        String tagGene = findSimpleGene(dna, startIndex, "TAG");
        String tgaGene = findSimpleGene(dna, startIndex, "TGA");
        // find shortest gene by if statement
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
        System.out.println("David gene is " + gene);
       
        };
    }

