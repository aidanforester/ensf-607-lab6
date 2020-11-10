/** 
 * Started by M. Moussavi
 * March 2015
 * Completed by: STUDENT(S) NAME
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * 
 * @author Aidan Forester and Ahmed Iqbal
 *
 */
public class ReadRecord {
    
    private ObjectInputStream input;
    
    /**
     *  opens an ObjectInputStream using a FileInputStream
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    
    private void readObjectsFromFile(String name) throws ClassNotFoundException, IOException
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
         * contains several reords.
         * Loop should terminate when an EOFException is thrown.
         */
        
        try
        {
            while (true)
            {
                record = (MusicRecord)input.readObject();
                System.out.println(record.getYear());
                System.out.println(record.getSongName());
                System.out.println(record.getSingerName());
                System.out.println(record.getPurchasePrice());
                
                // TO BE COMPLETED BY THE STUDENTS
                
           
            }   // END OF WHILE
        } catch (IOException EOFException){
        	System.out.println(EOFException);
        	System.out.println("End of file or end of stream has been reached unexpectedly during input.");
        }
                    // ADD NECESSARY catch CLAUSES HERE
    }           // END OF METHOD 
    
    
    public static void main(String [] args) throws ClassNotFoundException, IOException
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("allSongs.ser");
    }
}