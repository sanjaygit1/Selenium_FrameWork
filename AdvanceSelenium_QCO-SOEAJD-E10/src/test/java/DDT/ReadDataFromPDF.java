package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadDataFromPDF {

	public static void main(String[] args) throws Throwable {
		
		File fis = new File("./src/test/resources/multipage-pdf.pdf");

	    PDDocument doc = PDDocument.load(fis);
	
	 //   int pages = doc.getNumberOfPages();//----->Prints num of pages present
	 //   System.out.println(pages);
	    
	   PDFTextStripper pdfData = new PDFTextStripper();
	  //  String read = pdfData.getText(doc);//------>Reading all the data present in pdf
	  //  System.out.println(read);
	    
	   pdfData.setStartPage(1);//-------->reading perticular page data
	   String read = pdfData.getText(doc);
	   System.out.println(read);
	   
//	   pdfData.setStartPage(3);
//	   pdfData.setEndPage(5);
//	   String read = pdfData.getText(doc);
//	   System.out.println(read);
	  }

}
