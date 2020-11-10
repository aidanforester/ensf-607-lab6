package exercise3;
/** 
 * Started by M. Moussavi
 * March 2015
 * Completed by: STUDENT(S) NAME
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadRecord {
    
    private ObjectInputStream input;
    
    /**
     *  opens an ObjectInputStream using a FileInputStream
     */
    
    private void readObjectsFromFile(String name) throws EOFException
    {
        MusicRecord record ;
        
        try
        {
            input = new ObjectInputStream(new FileInputStream( name ) );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
        
        /* The following loop is supposed to use readObject method of
         * ObjectInputSteam to read a MusicRecord object from a binary file that
         * contains several records.
         * Loop should terminate when an EOFException is thrown.
         */
        
        try
        {
            while ( true )
            {
                
                
                // TO BE COMPLETED BY THE STUDENTS
                record = (MusicRecord) input.readObject();
                System.out.printf("%-10d%-23s%-18s%-10.2f\n", record.getYear(), record.getSongName(),record.getSingerName(),record.getPurchasePrice());
            }   // END OF WHILE
        }catch( ClassNotFoundException | IOException e) {
        	System.err.println("error");
        	e.printStackTrace();
        }
                // ADD NECESSARY catch CLAUSES HERE

    }           // END OF METHOD 
    
    
    public static void main(String [] args) throws EOFException
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("mySongs.ser");
    }
}