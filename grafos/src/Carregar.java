import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carregar {
	    private static final String ARQUIVO1 = "arquivodeteste.txt";
	    private static final String ARQUIVORESULTANTE = "A2.txt";

	   
	    
	    
	     public static ArrayList<String> ler() {
	        FileReader fr = null;
	        BufferedReader br = null;
	        ArrayList<String> dados = new ArrayList<String>();
	        try {
	            fr = new FileReader(ARQUIVO1);
	            br = new BufferedReader(fr);
	             
	            int ctl=0;

	            String linha ;
	          
	            while( (linha = br.readLine()) != null ) {
	            		dados.add(linha);
	            }
	            
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(Carregar.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(Carregar.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                br.close();
	                fr.close();
	            } catch (IOException ex) {
	                Logger.getLogger(Carregar.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
			return dados;
		 
	    }
	    
	     /*
	     public static void escreverArquivo() {
	         File f = new File(ARQUIVORESULTANTE);
	         FileWriter fw = null;
	         BufferedWriter bw = null;

	         try {
	             fw = new FileWriter(f);
	             bw = new BufferedWriter(fw);
	             
	            
	             
	             for(int linha = 0 ; linha < Multiplicacao.resultanteAuxC.length ; linha++) {
	     			
	     			for(int coluna = 0 ; coluna < Multiplicacao.resultanteAuxC[0][0].length() ; coluna++) {
	     				bw.write(Multiplicacao.resultanteAuxC[linha][coluna]+"");
	     				 
	     			}
	     			
	     			
	             
	                     
	                     
	             }
	         } catch (IOException e) {
	             e.printStackTrace();
	         } finally {
	             try {
	                     bw.close();
	                     fw.close();
	             } catch (IOException e) {
	                     e.printStackTrace();
	             }
	         }
	     }
	     
	    */
	     
	}




	    



